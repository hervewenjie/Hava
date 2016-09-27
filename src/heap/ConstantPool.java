package heap;

import classfile.ConstantInfo;

public class ConstantPool {
	_Class _class;
	Object[] constants;
	
	public static ConstantPool newConstantPool(_Class _class,classfile.ConstantPool cfcp){
		ConstantPool cp=new ConstantPool();
		int cpCount=cfcp.getPoolSize();
		Object[] constants=new Constant[cpCount];
		for(int i=0;i<cpCount;i++){
			ConstantInfo cpInfo=cfcp.infos[i];
			if(cpInfo instanceof classfile.ConstantIntegerInfo){
				constants[i]= ((classfile.ConstantIntegerInfo)cpInfo).val;
			}
			if(cpInfo instanceof classfile.ConstantLongInfo){
				constants[i]= ((classfile.ConstantLongInfo)cpInfo).val;
				i++;
			}
			if(cpInfo instanceof classfile.ConstantFloatInfo){
				constants[i]= ((classfile.ConstantFloatInfo)cpInfo).val;
			}
			if(cpInfo instanceof classfile.ConstantDoubleInfo){
				constants[i]= ((classfile.ConstantDoubleInfo)cpInfo).val;
				i++;
			}
			if(cpInfo instanceof classfile.ConstantStringInfo){
				constants[i]= ((classfile.ConstantStringInfo)cpInfo).getString();
			}
			if(cpInfo instanceof classfile.ConstantClassInfo){
				constants[i]=new CP_ClassRef(cp, (classfile.ConstantClassInfo)cpInfo);
			}
			if(cpInfo instanceof classfile.ConstantFieldrefInfo){
				constants[i]=new CP_FieldRef(cp, (classfile.ConstantFieldrefInfo)cpInfo);
			}
			if(cpInfo instanceof classfile.ConstantMethodrefInfo){
				constants[i]=new CP_MethodRef(cp, (classfile.ConstantMethodrefInfo)cpInfo);
			}
			if(cpInfo instanceof classfile.ConstantInterfaceMethodrefInfo){
			}
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
