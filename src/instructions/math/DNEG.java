package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class DNEG extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double val=frame.operandStack.popDouble();
		frame.operandStack.pushDouble(-val);
	}
}
