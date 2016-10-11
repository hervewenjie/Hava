package instructions.references;

import heap.CP_MethodRef;
import heap.ConstantPool;
import heap.Method_Lookup;
import heap._Class;
import heap._Method;
import instructions.Index16Instruction;
import instructions.base.MethodInvokeLogic;
import rtdata.Frame;
import rtdata._Object;

public class INVOKE_SPECIAL extends Index16Instruction {
	@Override
	public void execute(Frame frame) {

		// TODO Auto-generated method stub
		_Class currentClass=frame.method.get_Class();
		ConstantPool cp=currentClass.getConstantPool();
		CP_MethodRef methodRef=(CP_MethodRef)cp.getConstant(index);
		_Class resolvedClass=methodRef.resolvedClass();
		_Method resolvedMethod=methodRef.resolvedMethod();
		
		if(resolvedMethod.getName().equals("<init>")&&
				resolvedMethod.get_Class()!=resolvedClass){
			System.err.println("java.lang.NoSuchMethodError");
		}
		if(resolvedMethod.isStatic()){
			System.err.println("java.lang.IncompatibleClassChangeError");
		}
		_Object ref=frame.operandStack.getRefFromTop(resolvedMethod.getArgSlotCount()-1);
		
		// TODO check IllegalAccessError
		
		_Method methodToBeInvoked=resolvedMethod;
		if(currentClass.isSuper() &&
				resolvedClass.getSuperClass()==currentClass
				&& !resolvedMethod.getName().equals("<init>")){
			methodToBeInvoked=Method_Lookup.LookupMethodInClass(currentClass.getSuperClass(),
					methodRef.getName(), methodRef.getDescriptor());
		}
		if(methodToBeInvoked==null){
			System.err.println("java.lang.AbstractMethodError");
		}
		MethodInvokeLogic.invokeMethod(frame, methodToBeInvoked);
	}
}
