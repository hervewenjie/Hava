package instructions.references;

import heap.CP_FieldRef;
import heap.ConstantPool;
import heap._Class;
import heap._Field;
import heap._Method;
import instructions.Index16Instruction;
import rtdata.Frame;
import rtdata.OperandStack;
import rtdata.Slot;

public class PUTSTATIC extends Index16Instruction {
	
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_Method currentMethod = frame.method;
		_Class currentClass = currentMethod.get_Class();
		ConstantPool cp=currentClass.getConstantPool();
		CP_FieldRef fieldRef=(CP_FieldRef)cp.getConstant(index);
		
		_Field field=fieldRef.resolvedField();
		_Class _class=field.get_Class();
		// TODO verify final and static
		
		String descriptor=field.getDescriptor();
		int slotId=field.getSlotId();
		Slot[] slots=_class.getStaticVars();
		OperandStack stack=frame.operandStack;
	
		if(descriptor.equals("Z")||descriptor.equals("B")||descriptor.equals("C")||
				descriptor.equals("S")||descriptor.equals("I")){
			slots[slotId].setNum(stack.popInt());
		}
		if(descriptor.equals("F")){
			slots[slotId].setNum((int)stack.popFloat());
		}
		if(descriptor.equals("J")){
			slots[slotId].setNum((int)stack.popLong());
			slots[slotId+1].setNum(0);
		}
		if(descriptor.equals("D")){
			slots[slotId].setNum((int)stack.popDouble());
			slots[slotId+1].setNum(0);
		}
		if(descriptor.equals("L")||descriptor.equals("[")){
			slots[slotId].setRef(stack.popRef());
		}
	}
}
