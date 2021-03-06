package heap;

import classfile.ConstantInfo;

public class ConstantPool {
	_Class _class;
	Object[] constants;
	
	public static ConstantPool newConstantPool(_Class _class,classfile.ConstantPool cfcp){
		ConstantPool cp=new ConstantPool();
		cp._class=_class;
		int cpCount=cfcp.getPoolSize();
		
		// 常量池中用Object储存
		cp.constants=new Object[cpCount];
		for(int i=1;i<cpCount;i++){
			ConstantInfo cpInfo=cfcp.infos[i];
			if(cpInfo instanceof classfile.ConstantIntegerInfo){
				//System.out.println("#"+i+" Integer");
				cp.constants[i]= ((classfile.ConstantIntegerInfo)cpInfo).val;
			}
			if(cpInfo instanceof classfile.ConstantLongInfo){
				//System.out.println("#"+i+" Long");
				cp.constants[i]= ((classfile.ConstantLongInfo)cpInfo).val;
				i++;
			}
			if(cpInfo instanceof classfile.ConstantFloatInfo){
				//System.out.println("#"+i+" Float");
				cp.constants[i]= ((classfile.ConstantFloatInfo)cpInfo).val;
			}
			if(cpInfo instanceof classfile.ConstantDoubleInfo){
				//System.out.println("#"+i+" Double");
				cp.constants[i]= ((classfile.ConstantDoubleInfo)cpInfo).val;
				i++;
			}
			if(cpInfo instanceof classfile.ConstantStringInfo){
				//System.out.println("#"+i+" String");
				cp.constants[i]= ((classfile.ConstantStringInfo)cpInfo).getString();
			}
			if(cpInfo instanceof classfile.ConstantUtf8Info){
				//System.out.println("#"+i+" Utf8");
				cp.constants[i]= ((classfile.ConstantUtf8Info)cpInfo).val;
			}
			if(cpInfo instanceof classfile.ConstantClassInfo){
				//System.out.println("#"+i+" ClassRef");
				cp.constants[i]=new CP_ClassRef(cp, (classfile.ConstantClassInfo)cpInfo);
			}
			if(cpInfo instanceof classfile.ConstantFieldrefInfo){
				//System.out.println("#"+i+" FieldRef");
				cp.constants[i]=new CP_FieldRef(cp, (classfile.ConstantFieldrefInfo)cpInfo);
			}
			if(cpInfo instanceof classfile.ConstantMethodrefInfo){
				//System.out.println("#"+i+" MethodRef");
				cp.constants[i]=new CP_MethodRef(cp, (classfile.ConstantMethodrefInfo)cpInfo);
			}
			if(cpInfo instanceof classfile.ConstantInterfaceMethodrefInfo){
			}
			// TODO other constantinfo type
		}
		return cp;
	}
	
	public Object getConstant(int index){
		Object o=constants[index];
		if(o!=null){return o;}
		System.err.println("No constants at index "+index);
		return null;
	}
}
