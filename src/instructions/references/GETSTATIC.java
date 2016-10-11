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

public class GETSTATIC extends Index16Instruction {
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
	
		descriptor=descriptor.substring(0, 1);
		if(descriptor.equals("Z")||descriptor.equals("B")||descriptor.equals("C")||
				descriptor.equals("S")||descriptor.equals("I")){
			stack.pushInt(slots[slotId].getNum());
		}
		if(descriptor.equals("F")){
			stack.pushFloat(slots[slotId].getNum());;
		}
		if(descriptor.equals("J")){
			stack.pushLong(slots[slotId].getNum());
		}
		if(descriptor.equals("D")){
			stack.pushDouble(slots[slotId].getNum());
		}
		if(descriptor.equals("L")||descriptor.equals("[")){
			stack.pushRef(slots[slotId].getRef());
		}
	}
}
