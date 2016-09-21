package instructions.comparisons;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class FCMPL extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		FCMPG._fcmp(frame, false);
	}
}
