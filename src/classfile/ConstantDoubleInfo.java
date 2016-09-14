package classfile;

import java.io.InputStream;

public class ConstantDoubleInfo extends ConstantInfo {
	double val;
	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		byte[] bytes=ClassReader.readBytes(in, 8);
		// TODO
	}
}
