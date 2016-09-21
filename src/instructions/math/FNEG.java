package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class FNEG extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		float val=frame.operandStack.popFloat();
		frame.operandStack.pushFloat(-val);
	}
}
