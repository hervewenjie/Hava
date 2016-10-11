package instructions.constrol;

import instructions.NoOperandsInstruction;
import rtdata.Frame;
import rtdata._Object;
import rtdata._Thread;

public class DRETURN extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_Thread thread=frame.thread;
		Frame currentFrame=thread.popFrame();
		Frame invokerFrame=thread.topFrame();
		double val=currentFrame.operandStack.popDouble();
		invokerFrame.operandStack.pushDouble(val);
	}
}
