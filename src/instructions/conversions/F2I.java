package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class F2I extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		float f=frame.operandStack.popFloat();
		int i=(int)f;
		frame.operandStack.pushInt(i);
	}
}
