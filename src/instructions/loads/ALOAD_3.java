package instructions.loads;

import instructions.NoOperandsInstruction;
import rtdata.Frame;
import rtdata._Object;

public class ALOAD_3 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_Object ref=frame.localVars.getRef(3);
		frame.operandStack.pushRef(ref);
	}
}
