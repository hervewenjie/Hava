package instructions.references;

import heap.CP_ClassRef;
import heap.ConstantPool;
import heap._Class;
import instructions.Index16Instruction;
import rtdata.Frame;
import rtdata.OperandStack;
import rtdata._Object;

public class INSTANCE_OF extends Index16Instruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		OperandStack stack=frame.operandStack;
		_Object ref=stack.popRef();
		if(ref==null){stack.pushInt(0);return;}
		ConstantPool cp=frame.method.get_Class().getConstantPool();
		CP_ClassRef classRef=(CP_ClassRef)cp.getConstant(index);
		_Class _class=classRef.resolvedClass();
		// TODO ...super todo
		if(ref.getClassName().equals(_class.getName())){
			stack.pushInt(1);
		} else {
			stack.pushInt(0);
		}
	}
}
