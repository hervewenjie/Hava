package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class LSUB extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long v2=frame.operandStack.popLong();
		long v1=frame.operandStack.popLong();
		frame.operandStack.pushLong(v1-v2);
	}
}
