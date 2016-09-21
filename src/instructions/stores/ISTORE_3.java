package instructions.stores;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class ISTORE_3 extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		ISTORE._istore(frame, 3);
	}
}
