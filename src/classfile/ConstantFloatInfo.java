package classfile;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ConstantFloatInfo extends ConstantInfo {
	float val;
	
	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		byte[] bytes=ClassReader.readBytes(in, 4);
		
		// float 内存结构
		// 31        30        29-23    22-0
		// 实数符号位  指数符号位  指数位     有效数位
		DataInputStream dis=new DataInputStream(new ByteArrayInputStream(bytes));
	    try {
	    		val=dis.readFloat();
	    		dis.close();
	    	} catch (IOException e) {e.printStackTrace();}
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Float "+String.valueOf(val);
	}
}
