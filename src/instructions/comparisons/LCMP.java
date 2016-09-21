package instructions.comparisons;

import instructions.BranchInstruction;
import rtdata.Frame;

public class LCMP extends BranchInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		long val1=frame.operandStack.popLong();
		long val2=frame.operandStack.popLong();
		if(val1>val2){
			frame.operandStack.pushInt(1);
		} else if (val1==val2) {
			frame.operandStack.pushInt(0);
		} else {
			frame.operandStack.pushInt(-1);
		}
	}
}
