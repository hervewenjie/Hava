package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class L2I extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long l=frame.operandStack.popLong();
		int i=(int)l;
		frame.operandStack.pushInt(i);
	}
}
