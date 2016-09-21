package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class ILOAD_0 extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val=frame.localVars.getInt(3);
		frame.operandStack.pushInt(val);
	}
}
