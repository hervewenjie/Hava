package instructions.conversions;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class D2I extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double d=frame.operandStack.popDouble();
		int i=(int)d;
		frame.operandStack.pushInt(i);
	}
}
