package instructions.stores;

import instructions.Index8Instruction;
import rtdata.Frame;

public class DSTORE extends Index8Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		super.execute(frame);
	}
	
	public static void _dstore(Frame frame,int index){
		double val=frame.operandStack.popDouble();
		frame.localVars.setDouble(index, val);
	}
}
