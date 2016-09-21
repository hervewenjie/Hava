package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class ILOAD_1 extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val=frame.localVars.getInt(1);
		frame.operandStack.pushInt(val);
	}
}
