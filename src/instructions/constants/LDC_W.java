package instructions.constants;

import instructions.Index16Instruction;
import rtdata.Frame;

public class LDC_W extends Index16Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		LDC._ldc(frame, index);
	}
}
