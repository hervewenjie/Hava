package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class F2D extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		float f=frame.operandStack.popFloat();
		double d=(double)f;
		frame.operandStack.pushDouble(d);
	}
}
