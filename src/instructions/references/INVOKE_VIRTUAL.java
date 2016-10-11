package instructions.references;

import heap.CP_MethodRef;
import heap.ConstantPool;
import heap.Method_Lookup;
import heap._Class;
import heap._Method;
import instructions.Index16Instruction;
import instructions.base.MethodInvokeLogic;
import rtdata.Frame;
import rtdata.OperandStack;
import rtdata._Object;

public class INVOKE_VIRTUAL extends Index16Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_Class currentClass=frame.method.get_Class();
		ConstantPool cp=currentClass.getConstantPool();
		CP_MethodRef methodRef=(CP_MethodRef)cp.getConstant(index);
		_Method resolvedMethod=methodRef.resolvedMethod();
		if(resolvedMethod.isStatic()){
			System.err.println("java.lang.IncompatibleClassChangeError");
		}
		
		_Object ref=frame.operandStack.getRefFromTop(resolvedMethod.getArgSlotCount()-1);
		if(ref==null){
			// hack
			if(methodRef.getName().equals("println")){
				System.out.println("\nHack println!!!\n");
				_println(frame.operandStack, methodRef.getDescriptor());
				return;
			}
		}
		// TODO check
		_Method methodToBeInvoked=Method_Lookup.LookupMethodInClass(ref.get_Class(),
				methodRef.getName(), methodRef.getDescriptor());
		if(methodToBeInvoked==null){
			System.err.println("java.lang.AbstractMethodError");
		}
		MethodInvokeLogic.invokeMethod(frame, methodToBeInvoked);
	}
	
	private void _println(OperandStack stack,String descriptor){
		System.out.println("++++++++++++++++++++++++++");
		if(descriptor.equals("(Z)V")||descriptor.equals("(C)V")||
				descriptor.equals("(I)V")||descriptor.equals("(B)V")||descriptor.equals("(S)V")){
			System.out.println(stack.popInt());
		}
		if(descriptor.equals("(F)V")){
			System.out.println(stack.popFloat());
		}
		if(descriptor.equals("(J)V")){
			System.out.println(stack.popLong());
		}
		if(descriptor.equals("(D)V")){
			System.out.println(stack.popDouble());
		}
		System.out.println("++++++++++++++++++++++++++");
		stack.popRef();
	}
}
