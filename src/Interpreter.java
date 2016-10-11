
import config.DEBUG;
import heap._Method;
import instructions.Factory;
import instructions.Instruction;
import instructions.base.BytecodeReader;
import rtdata.Frame;
import rtdata._Thread;

public class Interpreter {
	
	public void interpret(_Method mainMethod){
		_Thread thread=new _Thread();
		Frame frame=thread.newFrame(mainMethod);
		frame.setThread(thread);
		thread.pushFrame(frame);
		
		if(DEBUG.CLASSINFO_DEBUG){
			System.out.println("Byte Code:");
			for(int i=0;i<mainMethod.code.length;i++){
				System.out.printf("%x ",mainMethod.code[i]);
			}
			System.out.println("\n==============");
		}
		
		loop(thread, mainMethod.code);
	}
	
	public void loop(_Thread thread,byte[] bytecode){
		BytecodeReader reader=new BytecodeReader();
		
		while(true){
			Frame frame=thread.currentFrame();
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
			if(thread.isStackEmpty()){
				break;
			}
			frame.printLocalVars();
		}
	}
}
