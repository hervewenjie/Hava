package instructions.stores;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class ASTORE_2 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		ASTORE._astore(frame, 2);
	}
}
