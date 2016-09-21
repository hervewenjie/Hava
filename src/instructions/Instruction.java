package instructions;

import rtdata.Frame;

public interface Instruction {
	void fetchOperands(BytecodeReader reader);
	void execute(Frame frame);
}
