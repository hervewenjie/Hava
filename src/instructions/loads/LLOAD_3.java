package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class LLOAD_3 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long val=frame.localVars.getLong(3);
		frame.operandStack.pushLong(val);
	}
}
