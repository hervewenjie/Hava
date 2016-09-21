package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class I2C extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int i=frame.operandStack.popInt();
		char c=(char)i;
		frame.operandStack.pushInt((int)c);
	}
}
