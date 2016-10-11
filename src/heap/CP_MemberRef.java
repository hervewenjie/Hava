package heap;

public class CP_MemberRef extends CP_SymRef {
	String name;
	String descriptor;
	
	public void copyMemberRefInfo(classfile.ConstantMemberrefInfo refIno){
		className=refIno.className();
		name=refIno.nameAndDescriptorName();
		descriptor=refIno.nameAndDescriptorDescriptor();
	}
	
	public String getName(){return name;}
	
	public String getDescriptor(){return descriptor;}
}
