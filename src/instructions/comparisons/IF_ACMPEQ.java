package instructions.comparisons;

import instructions.BranchInstruction;
import rtdata.Frame;
import rtdata._Object;

public class IF_ACMPEQ extends BranchInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		if(_acmp(frame)){
			BranchInstruction.branch(frame, offset);
		}
	}
	
	static boolean _acmp(Frame frame){
		_Object ref1=frame.operandStack.popRef();
		_Object ref2=frame.operandStack.popRef();
		return ref1==ref2;
	}
}
