package classfile;

import java.io.InputStream;

/*
CONSTANT_Fieldref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}
CONSTANT_Methodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}
CONSTANT_InterfaceMethodref_info {
    u1 tag;
    u2 class_index;
    u2 name_and_type_index;
}
*/
public class ConstantMemberrefInfo extends ConstantInfo {
	ConstantPool cp;
	int classIndex;
	int nameAndTypeIndex;
	
	public ConstantMemberrefInfo(ConstantPool cp) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
	}
	
	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		classIndex=ClassReader.read16(in);
		nameAndTypeIndex=ClassReader.read16(in);
	}
	
	public String className(){
		return cp.getClassName(classIndex);
	}
	
	public String nameAndDescriptor() {
		return cp.getNameAndType(nameAndTypeIndex);
	}
}
