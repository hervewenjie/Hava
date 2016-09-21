package instructions.comparisons;

import instructions.NoOperandsInstruction;
import rtdata.Frame;
import rtdata.OperandStack;

public class DCMPG extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_dcmp(frame, true);
	}
	
	public static void _dcmp(Frame frame,boolean gflag){
		OperandStack stack=frame.operandStack;
		double v1=stack.popDouble();
		double v2=stack.popDouble();
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
