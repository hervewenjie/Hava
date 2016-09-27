package heap;

import classfile.CodeAttribute;
import classfile.MemberInfo;

public class _Method extends ClassMember {
	int maxStack;
	int maxLocals;
	byte[] code;
	
	public static _Method[] newMethods(_Class _class,MemberInfo[] infos){
		_Method[] methods=new _Method[infos.length];
		for(int i=0;i<methods.length;i++){
			methods[i]=new _Method();
			methods[i]._class=_class;
			methods[i].copyMemberInfo(infos[i]);
			methods[i].copyAttributes(infos[i]);
		}
		return methods;
	}
	
	public void copyAttributes(MemberInfo info){
		CodeAttribute codeAttribute=info.getCodeAttribute();
		if(codeAttribute!=null){
			maxStack=codeAttribute.maxStack;
			maxLocals=codeAttribute.maxLocals;
			code=codeAttribute.code;
		}
	}
}
