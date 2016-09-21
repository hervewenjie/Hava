package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class ILOAD extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val=frame.localVars.getInt(index);
		frame.operandStack.pushInt(val);
	}
}
