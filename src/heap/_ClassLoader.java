package heap;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes.Name;

import classfile.ClassFile;
import classfile.ConstantPool;
import classpath.ClassPath;
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
		return loadNonArrayClass(name);
	}
	
	public _Class loadNonArrayClass(String name){
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
		int interfaceCount=_class.interfaces.length;
		if(interfaceCount>0){
			_class.interfaces=new _Class[interfaceCount];
			for(int i=0;i<interfaceCount;i++){
				_class.interfaces[i]=loadClass(_class.interfaceNames[i]);
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
	
	
}
