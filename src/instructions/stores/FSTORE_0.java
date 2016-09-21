package instructions.stores;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class FSTORE_0 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		FSTORE._fstore(frame, 0);
	}
}
