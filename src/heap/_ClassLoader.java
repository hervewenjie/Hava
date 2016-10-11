package heap;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.jar.Attributes.Name;

import classfile.ClassFile;
import classfile.ConstantPool;
import classpath.ClassPath;
import config.DEBUG;
import rtdata.Slot;

/*
class names:
    - primitive types: boolean, byte, int ...
    - primitive arrays: [Z, [B, [I ...
    - non-array classes: java/lang/Object ...
    - array classes: [Ljava/lang/Object; ...
*/
public class _ClassLoader {
	ClassPath cp;
	Map<String, _Class> classMap; // Loaded classes
	
	public _ClassLoader(ClassPath cp) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
		classMap=new HashMap<>();
	}
	
	public _Class loadClass(String name){
		if(classMap.containsKey(name)){
			return classMap.get(name);
		}
		System.out.println("loadClass "+name);
		return loadNonArrayClass(name);
	}
	
	public _Class loadNonArrayClass(String name){
		System.out.println("loadNonArrayClass name="+name);
		byte[] data=readClass(name);
		_Class c=defineClass(data);
		link(c);
		return c;
	}
	
	public byte[] readClass(String name){
		byte[] bs=cp.readClass(name);
		
		if(bs==null){
			System.err.println("Class Not Found "+name);
			System.exit(1);
		}
		return bs;
	}
	
	public _Class defineClass(byte[] data){
		
		// parse class return ClassFile object
		_Class _class=parseClass(data);
		
		_class.loader=this;
		resolveSuperClass(_class);
		resolveInterfaces(_class);
		classMap.put(_class.name, _class);
		return _class;
	}
	
	public _Class parseClass(byte[] data){
		ClassFile cf=ClassFile.parse(new ByteArrayInputStream(data));
		if(cf==null){
			System.err.println("Parse class error");
			System.exit(1);
		}
		return new _Class(cf);
	}
	
	private void resolveSuperClass(_Class _class){
		if(!_class.name.equals("java/lang/Object")){
			_class.superClass=_class.loader.loadClass(_class.superClassName);
		}
	}
	
	private void resolveInterfaces(_Class _class){
		if(_class.interfaces!=null){
			int interfaceCount=_class.interfaces.length;
			if(interfaceCount>0){
				_class.interfaces=new _Class[interfaceCount];
				for(int i=0;i<interfaceCount;i++){
					_class.interfaces[i]=loadClass(_class.interfaceNames[i]);
				}
			}
		}
		
	}
	
	private void link(_Class _class){
		verify(_class);
		prepare(_class);
	}
	
	private void verify(_Class _class){
		// TODO
	}
	
	private void prepare(_Class _class){
		calcInstanceFieldSlotIds(_class);
		calcStaticFieldSlotIds(_class);
		allocAndInitStaticVars(_class);
		if(DEBUG.CLASSINFO_DEBUG){
			System.out.println("---------");
			System.out.println("class name="+_class.name);
			System.out.println("instance fileds="+_class.instanceSlotCount);
			System.out.println("static fields="+_class.staticSlotCount);
		}
	}
	
	private void calcInstanceFieldSlotIds(_Class _class){
		int slotId=0;
		if(_class.superClass!=null){
			slotId=_class.superClass.instanceSlotCount;
		}
		for(_Field field:_class.fields){
			if(!field.isStatic()){
				field.slotId=slotId;
				slotId++;
				if(field.isLongOrDouble()){slotId++;}
			}
		}
		_class.instanceSlotCount=slotId;
	} 
	
	private void calcStaticFieldSlotIds(_Class _class){
		int slotId=0;
		for(_Field field:_class.fields){
			if(field.isStatic()){
				field.slotId=slotId;
				slotId++;
				if(field.isLongOrDouble()){slotId++;}
			}
		}
		_class.staticSlotCount=slotId;
	} 
	
	private void allocAndInitStaticVars(_Class _class){
		_class.staticVars=new Slot[_class.staticSlotCount];
		for(_Field field:_class.fields){
			if(field.isStatic() && field.isFinal()){
				initStaticFinalVar(_class, field);
			}
		}
	} 
	
	private void initStaticFinalVar(_Class _class,_Field field){
		Slot[] vars=_class.staticVars;
		heap.ConstantPool cp=_class.constantPool;
		int cpIndex=field.constValueIndex;
		int slotId=field.slotId;
		
		if(cpIndex>0){
			String desc=field.getDescriptor();
			if(desc.equals("Z")||desc.equals("B")||desc.equals("C")||desc.equals("S")||
					desc.equals("I")){
				vars[slotId].setNum((int)cp.getConstant(cpIndex));
			}
			if(desc.equals("J")){
				long val=(long)cp.getConstant(cpIndex);
				vars[slotId].setNum((int)val);
				vars[slotId+1].setNum((int) (val>>32) );
			}
			if(desc.equals("F")){
				float val=(float)cp.getConstant(cpIndex);
				vars[slotId].setNum((int)val);
			}
			if(desc.equals("D")){
				// TODO
			}
			if(desc.equals("Ljava/lang/String;")){
				// TODO
			}
		}
	}
	
	public void printLoadedClasses(){
		System.out.println("printLoadedClasses:");
		System.out.println("classMapsize="+classMap.size());
		for(String key:classMap.keySet()){
			System.out.println(key);
		}
	}
	
	public static void main(String[] args){
		String jreOption="/Library/Java/JavaVirtualMachines/jdk1.8.0_91.jdk/Contents/Home/jre";
		String cpOption="/Users/Herve/eclipse/java-neon2/Eclipse.app/Contents/MacOS/Hava/src/test";
		ClassPath cp=ClassPath.parse(jreOption, cpOption);
		_ClassLoader loader=new _ClassLoader(cp);
//		loader.loadClass("ClassFileTest");
//		System.out.println("=================");
//		loader.loadClass("ToLoad_1");
//		System.out.println("=================");
//		loader.loadClass("ToLoad_2");
		loader.loadClass("PrintStream");
		loader.printLoadedClasses();
	}
}
