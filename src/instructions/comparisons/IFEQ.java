package instructions.comparisons;

import instructions.BranchInstruction;
import rtdata.Frame;

public class IFEQ extends BranchInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val=frame.operandStack.popInt();
		if(val==0){
			BranchInstruction.branch(frame, offset);
		}
	}
}
