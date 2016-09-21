package instructions.constants;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class ICONST_4 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		frame.operandStack.pushInt(4);
	}
}
