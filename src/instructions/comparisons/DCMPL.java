package instructions.comparisons;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class DCMPL extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		DCMPG._dcmp(frame, false);
	}
}
