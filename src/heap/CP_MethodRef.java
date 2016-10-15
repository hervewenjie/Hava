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
		_Class d=cp._class;
		_Class c=resolvedClass();
		
		_Method method=lookupMethod(c, name, descriptor);
		
		if(method==null){System.err.println("java.lang.NoSuchMethodError");System.exit(1);}
		// TODO verify accessible
		
		this.method=method;
	}
	
	public _Method lookupMethod(_Class _class,String name,String descriptor){
		_Method method=Method_Lookup.LookupMethodInClass(_class, name, descriptor);		
		if(method==null){method=Method_Lookup.LookupMethodInInterface(_class, name, descriptor);}
		return method;
	}
}
