package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class D2L extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double d=frame.operandStack.popDouble();
		long l=(long)d;
		frame.operandStack.pushLong(l);
	}
}
