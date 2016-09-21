package rtdata;

public class Stack {
	int maxSize;
	int size;
	Frame _top;
	
	public Stack(int maxSize) {
		// TODO Auto-generated constructor stub
		size=0;
		this.maxSize=maxSize;
		_top=null;
	}
	
	static Stack newStack(int maxSize){
		return new Stack(maxSize);
	}
	
	void push(Frame frame){
		if(size>=maxSize){
			System.err.println("java.lang.StackOverflowError");
			System.exit(1);
		}
		if(_top!=null){
			frame.lower=_top;
		}
		_top=frame;
		size++;
	}
	
	Frame pop(){
		if(_top==null){
			System.err.println("jvm stack is empty!");
			System.exit(1);
		}
		Frame top=_top;
		_top=top.lower;
		top.lower=null;
		size--;
		return top;
	}
	
	Frame top(){
		if(_top==null){
			System.err.println("jvm stack is empty!");
			System.exit(1);
		}
		return _top;
	}
}
