package instructions.constants;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class FCONST_0 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		frame.operandStack.pushFloat(0.0f);
	}
}
