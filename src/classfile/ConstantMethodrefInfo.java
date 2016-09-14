package classfile;

import java.io.InputStream;

public class ConstantMethodrefInfo extends ConstantMemberrefInfo {

	public ConstantMethodrefInfo(ConstantPool cp) {
		// TODO Auto-generated constructor stub
		super(cp);
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "MethodRef #"+classIndex+"."+"#"+nameAndTypeIndex;
	}
	
	@Override
	public void readInfo(InputStream in, ConstantPool cp) {
		// TODO Auto-generated method stub
		super.readInfo(in,cp);
	}

}
