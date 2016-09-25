package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class ILOAD_1 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val=frame.localVars.getInt(1);
		frame.operandStack.pushInt(val);
	}
}
