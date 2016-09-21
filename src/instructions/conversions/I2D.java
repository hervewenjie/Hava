package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class I2D extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int i=frame.operandStack.popInt();
		double d=(double)i;
		frame.operandStack.pushDouble((int)d);
	}
}
