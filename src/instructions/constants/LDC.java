package instructions.constants;

import heap.ConstantPool;
import instructions.Index8Instruction;
import rtdata.Frame;
import rtdata.OperandStack;

public class LDC extends Index8Instruction {
	
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		_ldc(frame, index);
	}
	
	public static void _ldc(Frame frame, int index){
		OperandStack stack=frame.operandStack;
		ConstantPool cp=frame.method.get_Class().getConstantPool();
		Object c=cp.getConstant(index);
		if(c instanceof Integer){
			stack.pushInt((int)c);
		}
		if(c instanceof Float){
			stack.pushFloat((float)c);
		}
	}
}
