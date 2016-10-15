package instructions.references;

import heap.CP_FieldRef;
import heap.ConstantPool;
import heap._Class;
import heap._Field;
import heap._Method;
import instructions.Index16Instruction;
import rtdata.Frame;
import rtdata.OperandStack;
import rtdata._Object;

public class PUT_FIELD extends Index16Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_Method currentMethod=frame.method;
		_Class currentClass=currentMethod.get_Class();
		ConstantPool cp=currentClass.getConstantPool();
		CP_FieldRef fieldRef=(CP_FieldRef)cp.getConstant(index);
		_Field field = fieldRef.resolvedField();
		System.out.println("curmethod="+currentMethod.getName());
		System.out.println("curclass="+currentClass.getName());
		System.out.println("field="+field.getName());
		
		// TODO check static and final
		
		String descriptor = field.getDescriptor();
		int slotId=field.getSlotId();
		OperandStack stack=frame.operandStack;
		
		if(descriptor.equals("Z")||descriptor.equals("B")||
				descriptor.equals("C")||descriptor.equals("S")||
				descriptor.equals("I")){
			int val=stack.popInt();
			_Object ref=stack.popRef();
			ref.getFields()[slotId].setNum(val);	
		}
		if(descriptor.equals("F")){
			float val=stack.popFloat();
			_Object ref=stack.popRef();
			ref.getFields()[slotId].setNum((int) val);
		}
		if(descriptor.equals("J")){
			long val=stack.popLong();
			_Object ref=stack.popRef();
			ref.getFields()[slotId].setNum( (int) val);
		}
		if(descriptor.equals("D")){
			double val=stack.popDouble();
			_Object ref=stack.popRef();
			ref.getFields()[slotId].setNum( (int) val);
		}
		if(descriptor.equals("L")||descriptor.equals("[")){
			_Object val=stack.popRef();
			_Object ref=stack.popRef();
			ref.getFields()[slotId].setRef(val);
		}
	}
}
