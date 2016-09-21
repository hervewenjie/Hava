package instructions.constants;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class ACONST_NULL extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		frame.operandStack.pushRef(null);
	}

}
