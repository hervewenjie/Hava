package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class DLOAD_0 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double val=frame.localVars.getDouble(0);
		frame.operandStack.pushDouble(val);
	}
}
