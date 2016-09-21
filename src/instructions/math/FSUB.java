package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class FSUB extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		float v2=frame.operandStack.popFloat();
		float v1=frame.operandStack.popFloat();
		frame.operandStack.pushFloat(v1-v2);
	}
}
