package instructions.references;

import heap.CP_MethodRef;
import heap.ConstantPool;
import heap._Class;
import heap._Method;
import instructions.Index16Instruction;
import instructions.base.ClassInitLogic;
import instructions.base.MethodInvokeLogic;
import rtdata.Frame;

public class INVOKE_STATIC extends Index16Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		ConstantPool cp=frame.method.get_Class().getConstantPool();
		CP_MethodRef methodRef=(CP_MethodRef)cp.getConstant(index);
		_Method resolvedMethod=methodRef.resolvedMethod();
		if(!resolvedMethod.isStatic()){
			System.err.println("java.lang.IncompatibleClassChangeError");
		}
		_Class _class=resolvedMethod.get_Class();
		if(!_class.initStarted()){
			frame.revertNextPC();
			ClassInitLogic.initClass(frame.thread, _class);
		}
		MethodInvokeLogic.invokeMethod(frame, resolvedMethod);
	}
}
