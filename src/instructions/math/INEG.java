package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class INEG extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val=frame.operandStack.popInt();
		frame.operandStack.pushInt(-val);
	}
}
