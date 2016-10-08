package heap;

import classfile.MemberInfo;

public class _Field extends ClassMember {
	int constValueIndex;
	int slotId;
	
	public static _Field[] newFields(_Class _class,MemberInfo[] infos){
		_Field[] fields=new _Field[infos.length];
		for(int i=0;i<fields.length;i++){
			fields[i]=new _Field();
			fields[i]._class=_class;
			fields[i].copyMemberInfo(infos[i]);
			fields[i].copyAttributes(infos[i]);
			
		}
		return fields;
	}
	
	public void copyAttributes(MemberInfo info){
		if(info.getConstantValueAttribute()!=null){
			constValueIndex=info.getConstantValueAttribute().getConstantValueIndex();
		}
	}
	
	public boolean isVolatile(){return 0 != (accessFlags&AccessFlags.ACC_VOLATILE);}
	
	public boolean isTransient(){return 0 != (accessFlags&AccessFlags.ACC_TRANSIENT);}
	
	public boolean isEnum(){return 0 != (accessFlags&AccessFlags.ACC_ENUM);}
	
	public int getConstValueIndex(){return constValueIndex;}
	
	public int getSlotId(){return slotId;}
	
	public boolean isLongOrDouble(){return descriptor=="J"||descriptor=="D";}
}
