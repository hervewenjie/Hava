package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class F2L extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		float f=frame.operandStack.popFloat();
		long l=(long)f;
		frame.operandStack.pushLong(l);
	}
}
