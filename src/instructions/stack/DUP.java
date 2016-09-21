package instructions.stack;

import instructions.NoOperandsInstruction;
import rtdata.Frame;
import rtdata.Slot;

public class DUP extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		Slot slot=frame.operandStack.popSlot();
		frame.operandStack.pushSlot(slot);
		frame.operandStack.pushSlot(slot);
	}
}
