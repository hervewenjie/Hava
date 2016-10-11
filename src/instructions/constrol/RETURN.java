package instructions.constrol;

import instructions.NoOperandsInstruction;
import rtdata.Frame;

public class RETURN extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		frame.thread.popFrame();
	}
}
