package heap;

public class CP_SymRef {
	ConstantPool cp;
	String className;
	_Class _class;
	
	public _Class resolvedClass(){
		if(_class==null){
			resolveClassRef();
		}
		return _class;
	}
	
	public _Class get_Class(){
		return _class;
	}
	
	public void resolveClassRef(){
		_Class d=cp._class;
		
		_Class c=d.loader.loadClass(className);
//		if(!c.isAccessibleTo(d)){
//			System.err.println("java.lang.IllegalAccessError");
//			System.exit(1);
//		}
		_class=c;
	}
}
