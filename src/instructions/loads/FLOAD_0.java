package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class FLOAD_0 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		float val=frame.localVars.getFloat(0);
		frame.operandStack.pushFloat(val);
	}
}
