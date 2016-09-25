package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class DLOAD_2 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double val=frame.localVars.getDouble(2);
		frame.operandStack.pushDouble(val);
	}
}
