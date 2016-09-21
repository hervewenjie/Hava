package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class D2F extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double d=frame.operandStack.popDouble();
		float f=(float)d;
		frame.operandStack.pushFloat(f);
	}
}
