package instructions.stores;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class DSTORE_0 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		DSTORE._dstore(frame, 0);
	}
}
