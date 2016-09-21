package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class ILOAD_2 extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val=frame.localVars.getInt(2);
		frame.operandStack.pushInt(val);
	}
}
