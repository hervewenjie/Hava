package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class IADD extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int v1=frame.operandStack.popInt();
		int v2=frame.operandStack.popInt();
		frame.operandStack.pushInt(v1+v2);
	}
}
