package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class LLOAD_0 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long val=frame.localVars.getLong(0);
		frame.operandStack.pushLong(val);
	}
}
