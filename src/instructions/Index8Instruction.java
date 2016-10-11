package instructions;

import instructions.base.BytecodeReader;
import rtdata.Frame;

public class Index8Instruction implements Instruction {
	public int index;
	@Override
	public void fetchOperands(BytecodeReader reader) {
		// TODO Auto-generated method stub
		index = reader.readUint8();
	}

	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		
	}
	
}