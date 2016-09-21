package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class LLOAD_1 extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long val=frame.localVars.getLong(1);
		frame.operandStack.pushLong(val);
	}
}
