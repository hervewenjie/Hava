package instructions.comparisons;

import instructions.BranchInstruction;
import rtdata.Frame;

public class IF_ICMPEQ extends BranchInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val1=frame.operandStack.popInt();
		int val2=frame.operandStack.popInt();
		if(val1==val2){
			BranchInstruction.branch(frame, offset);
		}
	}
	
	 
}
