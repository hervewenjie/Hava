package classfile;

import java.io.InputStream;

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
	int accessFlags;
	int nameIndex;
	int descriptorIndex;
	AttributeInfo[] attributes;
	
	static MemberInfo[] readMembers(InputStream in, ConstantPool cp){
		int n=ClassReader.read16(in);
		MemberInfo[] members=new MemberInfo[n];
		for(int i=0;i<n;i++){
			members[i]=readMember(in, cp);
			System.out.println(members[i].memberToString());
		}
		return members;
	}
	
	static MemberInfo readMember(InputStream in,ConstantPool cp){
		MemberInfo memberInfo=new MemberInfo();
		memberInfo.cp=cp;
		memberInfo.accessFlags=ClassReader.read16(in);
		memberInfo.nameIndex=ClassReader.read16(in);
		memberInfo.descriptorIndex=ClassReader.read16(in);
		memberInfo.attributes=AttributeInfo.readAttributes(in, cp);
		return memberInfo;
	}
	
	public String getName(){
		return cp.getUtf8(nameIndex);
	}
	
	public String getDescriptor(){
		return cp.getUtf8(descriptorIndex);
	}
	
	String memberToString(){
		String str="";
		str+=AccessFlags.flagsToString(accessFlags);
		str+=cp.getUtf8(nameIndex);
		for(AttributeInfo attr:attributes){
			str+="\n  "+attr.description();
		}
		str+="\n";
		return str;
	}
	
	public CodeAttribute getCodeAttribute(){
		for(AttributeInfo attributeInfo:attributes){
			if(attributeInfo instanceof CodeAttribute){
				return (CodeAttribute)attributeInfo;
			}
		}
		return null;
	}
}
