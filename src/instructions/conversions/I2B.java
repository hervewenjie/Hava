package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class I2B extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int i=frame.operandStack.popInt();
		byte b=(byte)i;
		frame.operandStack.pushInt((int)b);
	}
}
