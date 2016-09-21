package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class L2F extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long l=frame.operandStack.popLong();
		float f=(float)l;
		frame.operandStack.pushFloat(f);
	}
}
