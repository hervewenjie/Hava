package heap;

public class CP_FieldRef extends CP_MemberRef {
	_Field field;
	
	public CP_FieldRef(ConstantPool cp,classfile.ConstantFieldrefInfo fieldRef) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
		copyMemberRefInfo(fieldRef);
	}
	
	public _Field resolvedField(){
		if(this.field==null){
			resolveFieldRef();
		}
		return this.field;
	}
	
	public void resolveFieldRef(){
		_Class d=cp._class;
		_Class c=resolvedClass();
		System.out.println("class="+c.getName());
		System.out.println("name="+name);
		System.out.println("descriptor="+descriptor);
		_Field field=lookupField(c, name, descriptor);
		
		if(field==null){
			System.err.println("java.lang.NoSuchFieldError");
			System.exit(1);
		}
//		if(!field.isAccessibleTo(d)){
//			System.err.println("java.lang.IllegalAccessError");
//			System.exit(1);
//		}
		this.field=field;
	}
	
	public _Field lookupField(_Class c,String name,String descriptor){
		
		for(_Field field:c.fields){
			if(field.name.equals(name)&&field.descriptor.equals(descriptor)){
				return field;
			}
		}
		for(_Class _interface:c.interfaces){
			_Field field=lookupField(_interface, name, descriptor);
			if(field!=null){return field;}
		}
		
		if(c.superClass!=null){
			return lookupField(_class.superClass, name, descriptor);
		}
		
		return null;
	}
}
