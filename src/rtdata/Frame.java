package rtdata;

import heap._Method;

public class Frame {
	public Frame lower;
	public LocalVars localVars;
	public OperandStack operandStack;
	public _Thread thread;
	public _Method method;
	public int nextPC;
	
	static Frame newFrame(_Thread thread, _Method method){
		Frame frame=new Frame();
		frame.localVars=LocalVars.newLocalVars(method.maxLocals);
		frame.operandStack=OperandStack.newOperandStack(method.maxStack);
		frame.method=method;
		return frame;
	}
	
	public void printLocalVars(){
		System.out.println("\nLocal vars:");
		Slot[] slots=localVars.vars;
		for(int i=0;i<slots.length;i++){
			System.out.print(slots[i].num+" ");
		}
		System.out.println();
	}
	
	public void setThread(_Thread thread){
		this.thread=thread;
	}
	
	public void revertNextPC(){
		nextPC=thread.pc;
	}
}
