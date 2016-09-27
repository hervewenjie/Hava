package classfile;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConstantDoubleInfo extends ConstantInfo {
	public double val;
	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		byte[] bytes=ClassReader.readBytes(in, 8);
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(bytes));
	    try {
	    		val=dis.readDouble();
	    		dis.close();
	    	} catch (IOException e) {e.printStackTrace();}
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Double "+String.valueOf(val);
	}
}
