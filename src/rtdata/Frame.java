package rtdata;

public class Frame {
	public Frame lower;
	public LocalVars localVars;
	public OperandStack operandStack;
	public _Thread thread;
	public int nextPC;
	
	static Frame newFrame(int maxLocals,int maxStack){
		Frame frame=new Frame();
		frame.localVars=LocalVars.newLocalVars(maxLocals);
		frame.operandStack=OperandStack.newOperandStack(maxStack);
		return frame;
	}
	
	public void setThread(_Thread thread){
		this.thread=thread;
	}
	
	public void printLocalVars(){
		System.out.println("Local vars:");
		Slot[] slots=localVars.vars;
		for(int i=0;i<slots.length;i++){
			System.out.print(slots[i].num+" ");
		}
		System.out.println();
	}
}
