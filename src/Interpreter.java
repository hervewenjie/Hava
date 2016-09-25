import classfile.CodeAttribute;
import classfile.MemberInfo;
import instructions.BytecodeReader;
import instructions.Factory;
import instructions.Instruction;
import rtdata.Frame;
import rtdata._Thread;

public class Interpreter {
	
	public void interpret(MemberInfo memberInfo){
		CodeAttribute codeAttr=memberInfo.getCodeAttribute();
		int maxLocals=codeAttr.maxLocals;
		int maxStack=codeAttr.maxStack;
		byte[] bytecode=codeAttr.code;
		
		_Thread thread=new _Thread();
		Frame frame=thread.newFrame(maxLocals, maxStack);
		frame.setThread(thread);
		
		thread.pushFrame(frame);
		
		System.out.println("Byte Code:");
		for(int i=0;i<bytecode.length;i++){
			System.out.printf("%x ",bytecode[i]);
		}
		System.out.println("\n==============");
		
		loop(thread, bytecode);
	}
	
	public void loop(_Thread thread,byte[] bytecode){
		Frame frame=thread.popFrame();
		
		BytecodeReader reader=new BytecodeReader();
		
		while(true){
			int pc=frame.nextPC;
			thread.setPC(pc);
			
			// decode
			reader.reset(bytecode, pc);
			int opcode=reader.readInt8();
			System.out.printf("pc="+pc+" this code=%x \n",opcode);
			Instruction inst=Factory.newInstruction(opcode);
			inst.fetchOperands(reader);
			frame.nextPC=reader.pc;
			
			// execute
			inst.execute(frame);
			
			frame.printLocalVars();
		}
	}
}
