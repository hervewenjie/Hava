package classfile;

import java.io.InputStream;

public class ConstantValueAttribute extends AttributeInfo {
	int constantValueIndex;
	ConstantPool cp;
	
	public ConstantValueAttribute(ConstantPool cp) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
	}
	
	@Override
	void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		constantValueIndex=ClassReader.read16(in);
	}
	
	@Override
	String description() {
		// TODO Auto-generated method stub
		String str="ConstantValue: ";
		if(cp.infos[constantValueIndex] instanceof ConstantIntegerInfo){
			str+="int "+cp.getInteger(constantValueIndex);
		}
		if(cp.infos[constantValueIndex] instanceof ConstantLongInfo){
			str+="long "+cp.getLong(constantValueIndex);
		}
		if(cp.infos[constantValueIndex] instanceof ConstantFloatInfo){
			str+="float "+cp.getFloat(constantValueIndex);
		}
		if(cp.infos[constantValueIndex] instanceof ConstantDoubleInfo){
			str+="double "+cp.getDouble(constantValueIndex);
		}
		return str;
	}
	
	public int getConstantValueIndex(){return constantValueIndex;}
}
