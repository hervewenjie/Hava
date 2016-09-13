package classfile;

import java.io.InputStream;

public class ConstantClassInfo extends ConstantInfo {
	ConstantPool cp;
	int nameIndex;
	
	public ConstantClassInfo(ConstantPool cp) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
	}
	
	@Override
	public void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		nameIndex=ClassReader.read16(in);
	}
	
	public String getName(){
		return cp.getUtf8(nameIndex);
	}
}
