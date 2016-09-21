package classfile;

import java.io.InputStream;

public class ConstantLongInfo extends ConstantInfo {
	long val;
	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		val=ClassReader.read64(in);
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Long "+val;
	}
}
