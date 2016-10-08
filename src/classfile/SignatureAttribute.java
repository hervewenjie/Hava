package classfile;

import java.io.InputStream;

/*
Signature_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 signature_index;
}
*/
public class SignatureAttribute extends AttributeInfo {
	ConstantPool cp;
	int signature_index;
	
	public SignatureAttribute(ConstantPool cp) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
	}
	
	@Override
	void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		signature_index=ClassReader.read16(in);
	}
}
