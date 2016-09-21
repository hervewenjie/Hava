package rtdata;

public class _Thread {
	public int pc;
	public Stack stack;
	
	public _Thread() {
		// TODO Auto-generated constructor stub
		stack=Stack.newStack(1024);
	}
	
	public int PC(){
		return pc;
	}
	
	public void setPC(int pc){
		this.pc=pc;
	}
	
	public void pushFrame(Frame frame){
		stack.push(frame);
	}
	
	public Frame popFrame(){
		return stack.pop();
	}
	
	public Frame currentFrame(){
		return stack.top();
	}
	
	public Frame newFrame(int maxLocals,int maxStack){
		return Frame.newFrame(maxLocals, maxStack);
	}
}
