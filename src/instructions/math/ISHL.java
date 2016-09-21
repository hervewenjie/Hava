package instructions.math;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class ISHL extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int v2=frame.operandStack.popInt();
		int v1=frame.operandStack.popInt();
		int s=v2&0x1F;
		frame.operandStack.pushInt(v1<<s);
	}
}
