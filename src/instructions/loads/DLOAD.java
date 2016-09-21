package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;

public class DLOAD extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double val=frame.localVars.getDouble(index);
		frame.operandStack.pushDouble(val);
	}
}
