package heap;

import classfile.MemberInfo;

public class ClassMember {
	int accessFlags;
	String name;
	String descriptor;
	_Class _class;
	
	public void copyMemberInfo(MemberInfo memberInfo){
		this.accessFlags=memberInfo.accessFlags;
		this.name=memberInfo.getName();
		this.descriptor=memberInfo.getDescriptor();
	}
	
	public boolean isPublic(){
		return 0 != (accessFlags&AccessFlags.ACC_PUBLIC);
	}
	
	public boolean isPrivate(){
		return 0 != (accessFlags&AccessFlags.ACC_PRIVATE);
	}
	
	public boolean isProtected(){
		return 0 != (accessFlags&AccessFlags.ACC_PROTECTED);
	}
	
	public boolean isStatic(){
		return 0 != (accessFlags&AccessFlags.ACC_STATIC);
	}
	
	public boolean isFinal(){
		return 0 != (accessFlags&AccessFlags.ACC_FINAL);
	}
	
	public boolean isSynthetic(){
		return 0 != (accessFlags&AccessFlags.ACC_SYNTHETIC);
	}
	
	public String getName(){return name;}
	
	public String getDescriptor(){return descriptor;}
	
	public _Class get_Class(){return _class;}
}
