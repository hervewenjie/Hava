package classfile;

import java.io.InputStream;

public class ConstantIntegerInfo extends ConstantInfo {
	
	int val;
	
	@Override
	public void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		val=ClassReader.read16(in);
	}
}
