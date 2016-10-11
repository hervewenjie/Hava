package instructions.math;

import instructions.Instruction;
import instructions.base.BytecodeReader;
import rtdata.Frame;

public class IINC implements Instruction {
	int index;
	int constant;
	
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		int val=frame.localVars.getInt(index);
		val+=constant;
		frame.localVars.setInt(index, val);
	}
	
	@Override
	public void fetchOperands(BytecodeReader reader) {
	// TODO Auto-generated method stub
		index=reader.readInt8();
		constant=reader.readInt8();
	}
}
