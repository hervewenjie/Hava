package instructions.comparisons;

import instructions.NoOperandsInstruction;
import rtdata.Frame;
import rtdata.OperandStack;

public class FCMPG extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_fcmp(frame, true);
	}
	
	static void _fcmp(Frame frame,boolean gflag){
		OperandStack stack=frame.operandStack;
		float v1=stack.popFloat();
		float v2=stack.popFloat();
		if(v1>v2){
			stack.pushInt(1);
		} else if(v1==v2){
			stack.pushInt(0);
		} else if (v1<v2) {
			stack.pushInt(-1);
		} else if (gflag) {
			stack.pushInt(1);
		} else {
			stack.pushInt(-1);
		}
	}
}
