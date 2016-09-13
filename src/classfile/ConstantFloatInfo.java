package classfile;

import java.io.InputStream;

public class ConstantFloatInfo extends ConstantInfo {
	float val;
	
	@Override
	public void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		byte[] bytes=ClassReader.readBytes(in, 4);
		// TODO
	}
}
