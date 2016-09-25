package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class ILOAD_0 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val=frame.localVars.getInt(3);
		frame.operandStack.pushInt(val);
	}
}
