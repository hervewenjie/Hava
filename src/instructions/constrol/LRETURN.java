package instructions.constrol;

import instructions.NoOperandsInstruction;
import rtdata.Frame;
import rtdata._Object;
import rtdata._Thread;

public class LRETURN extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_Thread thread=frame.thread;
		Frame currentFrame=thread.popFrame();
		Frame invokerFrame=thread.topFrame();
		long val=currentFrame.operandStack.popLong();
		invokerFrame.operandStack.pushLong(val);
	}
}
