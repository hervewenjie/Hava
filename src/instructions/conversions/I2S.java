package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class I2S extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int i=frame.operandStack.popInt();
		short s=(short)i;
		frame.operandStack.pushInt((int)s);
	}
}
