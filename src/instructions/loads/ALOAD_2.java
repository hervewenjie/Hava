package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;
import rtdata._Object;

public class ALOAD_2 extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_Object ref=frame.localVars.getRef(2);
		frame.operandStack.pushRef(ref);
	}
}
