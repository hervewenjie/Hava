package instructions;

import instructions.base.BytecodeReader;
import rtdata.Frame;

public class BranchInstruction implements Instruction {
	public int offset;
	@Override
	public void fetchOperands(BytecodeReader reader) {
		// TODO Auto-generated method stub
		offset=reader.readInt16();
	}

	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		
	}
	
	public static void branch(Frame frame,int offset){
		
		int pc=frame.thread.pc;
		int nextPC=pc+offset;
		frame.nextPC=nextPC;
	}
	
}
