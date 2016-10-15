
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
			frame.setThread(thread);
			
			//frame.printLocalVars();
			
			int pc=frame.nextPC;
			thread.setPC(pc);
			
			// decode
			reader.reset(frame.method.code, pc);
			int opcode=reader.readInt8();
			System.err.printf("class="+frame.method.get_Class().getName()+
					" method="+frame.method.getName()+" pc="+pc+" this code=%x \n",opcode);
//			for(int i=0;i<frame.method.code.length;i++){System.out.printf("%x ",frame.method.code[i]);
//			}System.out.println();
			
			Instruction inst=Factory.newInstruction(opcode);
			inst.fetchOperands(reader);
			frame.nextPC=reader.pc;
			
			// execute
			inst.execute(frame);
			if(thread.isStackEmpty()){
				System.out.println("thread framestack empty");
				break;
			}
		
		}
	}
}
