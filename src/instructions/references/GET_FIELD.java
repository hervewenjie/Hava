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
import rtdata._Object;

public class GET_FIELD extends Index16Instruction {
	@Override
	public void execute(Frame frame) {

		// TODO Auto-generated method stub
		ConstantPool cp=frame.method.get_Class().getConstantPool();
		CP_FieldRef fieldRef=(CP_FieldRef)cp.getConstant(index);
		_Field field=fieldRef.resolvedField();
		
		OperandStack stack=frame.operandStack;
		_Object ref=stack.popRef();
		
		String descriptor=field.getDescriptor();
		int slotId=field.getSlotId();
		Slot[] slots=ref.getFields();
		
		if(descriptor.equals("Z")||descriptor.equals("B")||
				descriptor.equals("C")||descriptor.equals("S")||
				descriptor.equals("I")){
			stack.pushInt(slots[slotId].getNum());
		}
		if(descriptor.equals("F")){
			stack.pushFloat(slots[slotId].getNum());
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
