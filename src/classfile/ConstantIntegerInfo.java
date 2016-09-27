package classfile;

import java.io.InputStream;

public class ConstantIntegerInfo extends ConstantInfo {
	
	public int val;
	
	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		val=ClassReader.read32(in);
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Integer "+val;
	}
}
