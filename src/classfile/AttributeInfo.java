package classfile;

import java.io.InputStream;

/*
attribute_info {
    u2 attribute_name_index;
    u4 attribute_length;
    u1 info[attribute_length];
}
*/
public class AttributeInfo {

	public static AttributeInfo[] readAttributes(InputStream in,ConstantPool cp){
		int n=ClassReader.read16(in);
		AttributeInfo[] attributes=new AttributeInfo[n];
		for(int i=0;i<n;i++){
			attributes[i]=readAttribute(in,cp);
			attributes[i].description();
		}
		return attributes;
	}
	
	static AttributeInfo readAttribute(InputStream in,ConstantPool cp){
		int attrNameIndex=ClassReader.read16(in);
		String attrName=cp.getUtf8(attrNameIndex);
		int attrLen=ClassReader.read32(in);
		AttributeInfo attrInfo=newAttributeInfo(attrName,attrLen,cp);
		attrInfo.readInfo(in);
		return attrInfo;
	}
	
	static AttributeInfo newAttributeInfo(String attrName,int attrLen,ConstantPool cp){
		switch (attrName) {
		case "Code":
			return new CodeAttribute(cp);
		case "ConstantValue":
			return new ConstantValueAttribute(cp);
		case "Deprecated":
			return new DeprecatedAttribute();
		case "Exceptions":
			return new ExceptionsAttribute();
		case "LineNumberTable":
			return new LineNumberTableAttribute();
		case "LocalVariableTable":
			return new LocalVariableTableAttribute();
		case "SourceFile":
			return new SourceFileAttribute();
		case "Synthetic":
			return new SyntheticAttribute();
		default:
			break;
		}
		return null;
	}
	
	void readInfo(InputStream in){}
	
	String description(){return "";}
}
