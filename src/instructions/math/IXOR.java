package instructions.math;

import instructions.NoOperandsInstruction;

public class IXOR extends NoOperandsInstruction {
	@Override
	public void execute(rtdata.Frame frame) {
		// TODO Auto-generated method stub
		int v1=frame.operandStack.popInt();
		int v2=frame.operandStack.popInt();
		frame.operandStack.pushInt(v1^v2);
	}
}
