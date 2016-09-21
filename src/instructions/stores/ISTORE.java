package instructions.stores;

import instructions.Index8Instruction;
import rtdata.Frame;

public class ISTORE extends Index8Instruction {
	
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_istore(frame, index);
	}
	
	public static void _istore(Frame frame,int index){
		int val=frame.operandStack.popInt();
		frame.localVars.setInt(index, val);
	}
}
