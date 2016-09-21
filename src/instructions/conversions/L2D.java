package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class L2D extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long l=frame.operandStack.popLong();
		double d=(double)l;
		frame.operandStack.pushDouble(d);
	}
}
