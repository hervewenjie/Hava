package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class DSUB extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double v2=frame.operandStack.popDouble();
		double v1=frame.operandStack.popDouble();
		frame.operandStack.pushDouble(v1-v2);
	}
}
