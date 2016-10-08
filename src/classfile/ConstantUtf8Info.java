package classfile;

import java.io.InputStream;

/*
CONSTANT_Utf8_info {
    u1 tag;
    u2 length;
    u1 bytes[length];
}
*/
public class ConstantUtf8Info extends ConstantInfo {
	public String val;

	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		int len=ClassReader.read16(in);
		byte[] bytes=ClassReader.readBytes(in, len);
		StringBuilder builder=new StringBuilder();
		for(int i=0;i<len;i++){
			builder.append( (char)bytes[i]);
		}
		val=builder.toString();
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Utf8 "+val;
	}
}
