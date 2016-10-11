package rtdata;

public class OperandStack {
	public int size;
	public Slot[] slots;
	
	public OperandStack(int maxStack) {
		// TODO Auto-generated constructor stub
		size=0;
		slots=new Slot[maxStack];
		for(int i=0;i<maxStack;i++){
			slots[i]=new Slot();
		}
	}
	
	public static OperandStack newOperandStack(int maxStack){
		if(maxStack>0){
			return new OperandStack(maxStack);
		}
		return null;
	}
	
	public void pushInt(int val){
		slots[size].num=val;
		size++;
	}
	
	public int popInt(){
		size--;
		return slots[size].num;
	}
	
	public void pushFloat(float val){
		slots[size].num=(int)val;
		size++;
	}
	
	public float popFloat(){
		size--;
		return slots[size].num;
	}
	
	public void pushLong(long val){
		slots[size].num=(int)val;
		slots[size+1].num=(int)(val>>32);
		size+=2;
	}
	
	public long popLong(){
		size-=2;
		long low=slots[size].num;
		long high=slots[size+1].num;
		return high<<32 | low;
	}
	
	public void pushDouble(double val){
		pushLong((long)val);
	}
	
	public double popDouble(){
		return popLong();
	}
	
	public void pushRef(_Object ref){
		slots[size].ref=ref;
		size++;
	}
	
	public _Object popRef(){
		size--;
		_Object ref=slots[size].ref;
		slots[size].ref=null;
		return ref;
	}
	
	public void pushSlot(Slot slot){
		slots[size]=slot;
		size++;
	}
	
	public Slot popSlot(){
		size--;
		return slots[size];
	}
	
	public _Object getRefFromTop(int n){
		return slots[size-1-n].ref;
	}
}
