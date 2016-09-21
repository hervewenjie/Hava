package instructions.constrol;

import instructions.BranchInstruction;
import rtdata.Frame;

public class GOTO extends BranchInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		BranchInstruction.branch(frame, offset);
	}
}
