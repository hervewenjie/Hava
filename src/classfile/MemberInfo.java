package classfile;

import java.io.InputStream;

import config.DEBUG;

/*
field_info {
    u2             access_flags;
    u2             name_index;
    u2             descriptor_index;
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
method_info {
    u2             access_flags;
    u2             name_index;
    u2             descriptor_index;
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
*/
public class MemberInfo {
	ConstantPool cp;
	public int accessFlags;
	public int nameIndex;
	public int descriptorIndex;
	public AttributeInfo[] attributes;
	
	static MemberInfo[] readMembers(InputStream in, ConstantPool cp){
		int n=ClassReader.read16(in);
		MemberInfo[] members=new MemberInfo[n];
		for(int i=0;i<n;i++){
			members[i]=readMember(in, cp);
			if(DEBUG.CLASSINFO_DEBUG) {members[i].memberToString();}
		}
		return members;
	}
	
	static MemberInfo readMember(InputStream in,ConstantPool cp){
		MemberInfo memberInfo=new MemberInfo();
		memberInfo.cp=cp;
		memberInfo.accessFlags=ClassReader.read16(in);
		memberInfo.nameIndex=ClassReader.read16(in);
		memberInfo.descriptorIndex=ClassReader.read16(in);
		if(DEBUG.CLASSINFO_DEBUG) {
			System.out.println("Method name index="+memberInfo.nameIndex);
			System.out.println("Method descriptorIndex index="+memberInfo.descriptorIndex);
		}
		memberInfo.attributes=AttributeInfo.readAttributes(in, cp);
		return memberInfo;
	}
	
	public String getName(){
		return cp.getUtf8(nameIndex);
	}
	
	public String getDescriptor(){
		return cp.getUtf8(descriptorIndex);
	}
	
	void memberToString(){
		String str="";
		str+=AccessFlags.flagsToString(accessFlags);
		str+=cp.getUtf8(nameIndex);
		for(AttributeInfo attr:attributes){
			str+="\n  "+attr.description();
		}
		str+="\n";
		System.out.println(str);
	}
	
	public CodeAttribute getCodeAttribute(){
		for(AttributeInfo attributeInfo:attributes){
			if(attributeInfo instanceof CodeAttribute){
				return (CodeAttribute)attributeInfo;
			}
		}
		return null;
	}
	
	public ConstantValueAttribute getConstantValueAttribute(){
		for(AttributeInfo attr:attributes){
			if(attr instanceof ConstantValueAttribute){
				return (ConstantValueAttribute) attr;
			}
		}
		return null;
	}
	
}
