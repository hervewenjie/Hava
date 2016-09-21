package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class LLOAD_2 extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long val=frame.localVars.getLong(2);
		frame.operandStack.pushLong(val);
	}
}
