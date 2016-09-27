package heap;

public class CP_MethodRef extends CP_MemberRef {
	_Method method;
	
	public CP_MethodRef(ConstantPool cp,classfile.ConstantMemberrefInfo refInfo) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
		copyMemberRefInfo(refInfo);
	}
	
	public _Method resolvedMethod(){
		if(method==null){
			resolveMethodRef();
		}
		return method;
	}
	
	public void resolveMethodRef(){
		
	}
}
