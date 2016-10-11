package instructions;

import instructions.base.BytecodeReader;
import rtdata.Frame;

public interface Instruction {
	void fetchOperands(BytecodeReader reader);
	void execute(Frame frame);
}
