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
}
