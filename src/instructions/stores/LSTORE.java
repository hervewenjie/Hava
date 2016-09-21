package instructions.stores;

import instructions.Index8Instruction;
import rtdata.Frame;

public class LSTORE extends Index8Instruction {
	public static void _lstore(Frame frame,int index){
		long val=frame.operandStack.popLong();
		frame.operandStack.pushLong(val);
	}
}
