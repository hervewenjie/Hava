package instructions.comparisons;

import instructions.BranchInstruction;
import rtdata.Frame;

public class IF_ACMPNE extends BranchInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		if(!IF_ACMPEQ._acmp(frame)){
			BranchInstruction.branch(frame, offset);
		}
	}
}
