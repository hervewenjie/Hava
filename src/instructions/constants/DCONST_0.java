package instructions.constants;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class DCONST_0 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		frame.operandStack.pushDouble(0.0);
	}
}
