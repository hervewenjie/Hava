package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class I2F extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int i=frame.operandStack.popInt();
		float f=(float)i;
		frame.operandStack.pushFloat((int)f);
	}
}
