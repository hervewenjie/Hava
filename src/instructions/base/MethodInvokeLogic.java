package instructions.base;

import heap._Method;
import rtdata.Frame;
import rtdata.Slot;
import rtdata._Thread;

public class MethodInvokeLogic {
	public static void invokeMethod(Frame invokerFrame, _Method method){
		
		_Thread thread=invokerFrame.thread;
		Frame newFrame=thread.newFrame(method);
		thread.pushFrame(newFrame);
		
		int argSlotCount=method.getArgSlotCount();
		if(argSlotCount>0){
			for(int i=argSlotCount-1;i>=0;i--){
				Slot slot=invokerFrame.operandStack.popSlot();
				newFrame.localVars.setSlot(i, slot);
			}
		}
		
		// TODO native methods
		if(method.isNative()){
			// hack 
			if(method.getName().equals("registerNatives")){
				thread.popFrame();
			} else {
				System.err.println("Native Method "+method.getName());
				System.exit(1);
			}
		}
		
	}
}
