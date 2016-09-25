package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;
import rtdata._Object;

public class ALOAD_1 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_Object ref=frame.localVars.getRef(1);
		frame.operandStack.pushRef(ref);
	}
}
