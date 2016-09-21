package instructions.stack;

import instructions.NoOperandsInstruction;
import rtdata.Frame;
import rtdata.Slot;

public class DUP_X2 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		Slot slot1=frame.operandStack.popSlot();
		Slot slot2=frame.operandStack.popSlot();
		Slot slot3=frame.operandStack.popSlot();
		frame.operandStack.pushSlot(slot1);
		frame.operandStack.pushSlot(slot3);
		frame.operandStack.pushSlot(slot2);
		frame.operandStack.pushSlot(slot1);
	}
}
