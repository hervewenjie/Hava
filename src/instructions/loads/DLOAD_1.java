package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class DLOAD_1 extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double val=frame.localVars.getDouble(1);
		frame.operandStack.pushDouble(val);
	}
}
