package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class DLOAD_2 extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double val=frame.localVars.getDouble(2);
		frame.operandStack.pushDouble(val);
	}
}
