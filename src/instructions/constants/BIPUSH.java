package instructions.constants;

import instructions.Instruction;
import instructions.base.BytecodeReader;
import rtdata.Frame;

public class BIPUSH implements Instruction {
	int val;
	@Override
	public void fetchOperands(BytecodeReader reader) {
		// TODO Auto-generated method stub
		val=reader.readInt8();
	}

	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		frame.operandStack.pushInt(val);
	}
	
}
