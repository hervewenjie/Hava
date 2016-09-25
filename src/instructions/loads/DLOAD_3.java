package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class DLOAD_3 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		double val=frame.localVars.getDouble(3);
		frame.operandStack.pushDouble(val);
	}
}
