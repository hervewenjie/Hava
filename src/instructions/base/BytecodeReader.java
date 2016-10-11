package instructions.base;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class BytecodeReader {
	public byte[] code;
	public int pc;
	
	public int readInt8(){return readUint8();}
	
	public int readUint8(){
		int i=code[pc]&0xFF;
		pc++;
		return i;
	}
	
	public int readInt16(){return readUint16();}
	
	public int readUint16(){
		byte b1=code[pc++];
		byte b2=code[pc++];
		byte[] bs={b1,b2};
		DataInputStream in=new DataInputStream(new ByteArrayInputStream(bs));
		int ret=0;
		try {
			ret = in.readShort();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Read 16 failed");
			e.printStackTrace();
		}
		return ret;
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
	
	public void reset(byte[] code,int pc){
		this.code=code;
		this.pc=pc;
	}
}
