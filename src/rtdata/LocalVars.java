package rtdata;

public class LocalVars {
	Slot[] vars;
	
	public LocalVars(int maxLocals) {
		// TODO Auto-generated constructor stub
		vars=new Slot[maxLocals];
	}
	
	static LocalVars newLocalVars(int maxLocals){
		if(maxLocals>0){
			return new LocalVars(maxLocals);
		}
		return null;
	}
	
	public void setInt(int index, int val){
		vars[index].num=val;
	}
	
	public int getInt(int index){
		return vars[index].num;
	}
	
	public void setFloat(int index, float val){
		vars[index].num=(int)val;
	}
	
	public float getFloat(int index){
		return vars[index].num;
	}
	
	public void setLong(int index,long val){
		vars[index].num=(int)val;
		vars[index+1].num=(int)(val>>32);
	}
	
	public long getLong(int index){
		long low=vars[index].num;
		long high=vars[index+1].num;
		return high<<32 | low;
	}
	
	public void setDouble(int index,double val){
		setLong(index, (long)val);
	}
	
	public double getDouble(int index){
		return getLong(index);
	}
	
	public void setRef(int index,_Object ref){
		vars[index].ref=ref;
	}
	
	public _Object getRef(int index){
		return vars[index].ref;
	}
}
