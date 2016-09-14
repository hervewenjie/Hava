package classfile;

public class ConstantFieldrefInfo extends ConstantMemberrefInfo {

	public ConstantFieldrefInfo(ConstantPool cp) {
		super(cp);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "FieldRef #"+classIndex+"."+"#"+nameAndTypeIndex;
	}
	
}
