package instructions.references;

import heap.CP_ClassRef;
import heap.ConstantPool;
import heap._Class;
import instructions.Index16Instruction;
import rtdata.Frame;
import rtdata._Object;

public class NEW extends Index16Instruction {
	
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		ConstantPool cp=frame.method.get_Class().getConstantPool();
		CP_ClassRef classRef=(CP_ClassRef) cp.getConstant(index);
		_Class _class=classRef.resolvedClass();
		
		if(_class.isInterface() || _class.isAbstract()){
			System.err.println("Cannot init interface or abstract class");
			System.exit(1);
		}
		_Object _object=_class.newObject();
		frame.operandStack.pushRef(_object);
	}
	
}
