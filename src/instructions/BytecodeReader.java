package instructions;

public class BytecodeReader {
	byte[] code;
	int pc;
	
	public int readInt8(){return readUint8();}
	
	public int readUint8(){
		int i=code[pc];
		pc++;
		return i;
	}
	
	public int readInt16(){return readUint16();}
	
	public int readUint16(){
		int b1=readInt8();
		int b2=readInt8();
		return (b1<<8) | b2;
	}
	
	public int readInt32(){
		int b1=readInt8();
		int b2=readInt8();
		int b3=readInt8();
		int b4=readInt8();
		return (b1 << 24) | (b2 << 16) | (b3 << 8) | b4;
	}
	
	public int[] readInt32s(int n){
		int[] ints=new int[n];
		for(int i=0;i<n;i++){
			ints[i]=readInt32();
		}
		return ints;
	}
	
	public void skipPadding(){
		while(pc%4!=0){
			readInt8();
		}
	}
}
