package classfile;

import java.io.InputStream;

public class ConstantLongInfo extends ConstantInfo {
	long val;
	@Override
	public void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		val=ClassReader.read64(in);
	}
}
