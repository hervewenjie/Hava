package instructions.constants;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class DCONST_1 extends NoOperandsInstruction{
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		frame.operandStack.pushDouble(1.0);
	}
}
