package classfile;

import java.io.InputStream;

public class ConstantNameAndTypeInfo extends ConstantInfo {

	int nameIndex;
	int descriptorIndex;
	
	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		nameIndex=ClassReader.read16(in);
		descriptorIndex=ClassReader.read16(in);
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "NameAndType #"+nameIndex+":#"+descriptorIndex;
	}
}
