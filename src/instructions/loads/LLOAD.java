package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class LLOAD extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long val=frame.localVars.getLong(index);
		frame.operandStack.pushLong(val);
	}
}
