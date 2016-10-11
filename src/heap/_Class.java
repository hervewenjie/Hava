package heap;

import classfile.ClassFile;
import rtdata.Slot;
import rtdata._Object;

public class _Class {

	int accessFlags;
	String name;
	String superClassName;
	String[] interfaceNames;
	ConstantPool constantPool;
	_Field[] fields;
	_Method[] methods;
	_Class superClass;
	_Class[] interfaces;
	int instanceSlotCount;
	int staticSlotCount;
	Slot[] staticVars;
	boolean initStarted;
	
	static _ClassLoader loader;
	
	public _Class(ClassFile cf) {
		// TODO Auto-generated constructor stub
		System.out.println("init class "+cf.getClassName());
		accessFlags=cf.access_flags;
		name=cf.getClassName();
		superClassName=cf.getSuperClassName();
		interfaceNames=cf.getInterfaceNames();
		constantPool=ConstantPool.newConstantPool(this, cf.constantPool);
		fields=_Field.newFields(this, cf.fields);
		methods=_Method.newMethods(this, cf.methods);
	}
	
	public boolean isPublic(){return 0!=(accessFlags&AccessFlags.ACC_PUBLIC);}
	
	public boolean isFinal(){return 0!=(accessFlags&AccessFlags.ACC_FINAL);}
	
	public boolean isSuper(){return 0!=(accessFlags&AccessFlags.ACC_SUPER);}
	
	public boolean isInterface(){return 0!=(accessFlags&AccessFlags.ACC_INTERFACE);}
	
	public boolean isAbstract(){return 0!=(accessFlags&AccessFlags.ACC_ABSTRACT);}
	
	public boolean isSynthetic(){return 0!=(accessFlags&AccessFlags.ACC_SYNTHETIC);}
	
	public boolean isAnnotation(){return 0!=(accessFlags&AccessFlags.ACC_ANNOTATION);}
	
	public boolean isEnum(){return 0!=(accessFlags&AccessFlags.ACC_ENUM);}
	
	public ConstantPool getConstantPool(){return constantPool;}
	
	public Slot[] getStaticVars(){return staticVars;}
	
	public boolean isAccessibleTo(){return true;}
	
	public String getPackageName(){return "";}
	
	public _Method getMainMethod(){
		return getStaticMethod("main", "([Ljava/lang/String;)V");
	}
	
	public _Method getStaticMethod(String name,String descriptor){
		for(_Method method:methods){
			if(method.isStatic()&&method.name.equals(name)&&
					method.descriptor.equals(descriptor)){
				return method;
			}
		}
		return null;
	}
	
	public void setClassLoader(_ClassLoader loader){
		this.loader=loader;
	}
	
	public _Object newObject(){
		return new _Object(this);
	}
	
	public String getName(){return name;}
	
	public void startInit(){initStarted=true;}
	
	public boolean initStarted(){return initStarted;}
	
	public _Method getClinitMethod(){
		return getStaticMethod("<clinit>", "()V");
	}
	
	public _Class getSuperClass(){return superClass;}

}
