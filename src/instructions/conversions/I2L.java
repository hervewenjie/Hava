package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class I2L extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int i=frame.operandStack.popInt();
		long l=(long)i;
		frame.operandStack.pushInt((int)l);
	}
}
