package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class LNEG extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long val=frame.operandStack.popLong();
		frame.operandStack.pushLong(-val);
	}
}
