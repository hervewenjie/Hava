package instructions.stores;

import instructions.Index8Instruction;
import rtdata.Frame;
import rtdata._Object;

public class ASTORE extends Index8Instruction {
	
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_astore(frame, index);
	}

	public static void _astore(Frame frame, int index){
		_Object ref=frame.operandStack.popRef();
		frame.localVars.setRef(index, ref);
	}
}
