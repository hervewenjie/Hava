package instructions;

import rtdata.Frame;

public class Index16Instruction implements Instruction {
	int index;
	@Override
	public void fetchOperands(BytecodeReader reader) {
		// TODO Auto-generated method stub
		index = reader.readUint16();
	}

	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
	}
	
}
