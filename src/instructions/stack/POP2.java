package instructions.stack;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class POP2 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		frame.operandStack.popSlot();
		frame.operandStack.popSlot();
	}
}
