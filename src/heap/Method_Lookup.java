package heap;

public class Method_Lookup {
	public static _Method LookupMethodInClass(_Class _class,String name,String descriptor){
		
		for(_Class c=_class;c!=null;c=c.superClass){
			for(_Method m:c.methods){
				if(m.getName().equals(name)&&m.getDescriptor().equals(descriptor)){
					return m;
				}
			}
		}
		return null;
	}
	
	public static _Method LookupMethodInInterface(_Class _class,String name,String descriptor){
		return null;
	}
}
