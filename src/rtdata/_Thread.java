package rtdata;

import heap._Method;

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
	
	public Frame topFrame(){
		return stack.top();
	}
	
	public Frame newFrame(_Method method){
		return Frame.newFrame(this,method);
	}
	
	public boolean isStackEmpty(){return stack.isEmpty();}
}
