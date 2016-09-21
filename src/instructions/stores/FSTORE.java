package instructions.stores;

import instructions.Index8Instruction;
import rtdata.Frame;

public class FSTORE extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		super.execute(frame);
	}
	
	public static void _fstore(Frame frame,int index){
		float val=frame.operandStack.popFloat();
		frame.localVars.setFloat(index, val);
	}
}
