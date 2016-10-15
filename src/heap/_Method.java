package heap;

import classfile.CodeAttribute;
import classfile.MemberInfo;

public class _Method extends ClassMember {
	public int maxStack;
	public int maxLocals;
	public byte[] code;
	int argSlotCount;
	
	public static _Method[] newMethods(_Class _class,MemberInfo[] infos){
		_Method[] methods=new _Method[infos.length];
		for(int i=0;i<methods.length;i++){
			methods[i]=new _Method();
			methods[i]._class=_class;
			methods[i].copyMemberInfo(infos[i]);
			methods[i].copyAttributes(infos[i]);
			methods[i].calArgSlotCount();
		}
		return methods;
	}
	
	public static _Method copyMethod(_Method ori){
		_Method m=new _Method();
		
		return m;
	}
	
	public void copyAttributes(MemberInfo info){
		CodeAttribute codeAttribute=info.getCodeAttribute();
		if(codeAttribute!=null){
			maxStack=codeAttribute.maxStack;
			maxLocals=codeAttribute.maxLocals;
			code=codeAttribute.code;
		}
	}
	
	public void calArgSlotCount(){
		MethodDescriptor parsedDescriptor=MethodDescriptorParser.parseMethodDescriptor(descriptor);
		for(String s:parsedDescriptor.parameterTypes){
			
			argSlotCount++;
			if(s.equals("J")||s.equals("D")){argSlotCount++;}
		}
		if(!isStatic()){
			argSlotCount++;
		}
	}
	
	public int getArgSlotCount(){return argSlotCount;}
	
	public boolean isNative(){
		return 0 != (accessFlags&AccessFlags.ACC_NATIVE);
	}
}
