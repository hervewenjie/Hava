package instructions.loads;

import instructions.Index8Instruction;
import rtdata.Frame;
import rtdata._Object;

public class ALOAD extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_Object ref=frame.localVars.getRef(index);
		frame.operandStack.pushRef(ref);
	}
}
