package instructions.stores;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class LSTORE_0 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		LSTORE._lstore(frame, 0);
	}
}
