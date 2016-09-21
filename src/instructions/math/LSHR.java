package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class LSHR extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int v2=frame.operandStack.popInt();
		long v1=frame.operandStack.popLong();
		long s=v2&0x3F;
		frame.operandStack.pushLong(v1>>s);
	}
}
