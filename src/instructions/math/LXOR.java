package instructions.math;

import instructions.NoOperandsInstruction;

public class LXOR extends NoOperandsInstruction {
	@Override
	public void execute(rtdata.Frame frame) {
		// TODO Auto-generated method stub
		long v1=frame.operandStack.popLong();
		long v2=frame.operandStack.popLong();
		frame.operandStack.pushLong(v1^v2);
	}
}
