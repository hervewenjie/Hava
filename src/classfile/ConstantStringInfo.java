package classfile;

import java.io.InputStream;

public class ConstantStringInfo extends ConstantInfo {
	ConstantPool cp;
	int index;
	
	public ConstantStringInfo(ConstantPool cp) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
	}
	
	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		index=ClassReader.read16(in);
	}
	public String getString(){
		return cp.getUtf8(index);
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "String #"+index;
	}
}
