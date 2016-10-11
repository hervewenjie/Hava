package instructions.base;

import heap._Class;
import heap._Method;
import rtdata.Frame;
import rtdata._Thread;

public class ClassInitLogic {
	public static void initClass(_Thread thread,_Class _class){
		_class.startInit();
		scheduleClinit(thread, _class);
		initSuperClass(thread, _class);
	}
	public static void scheduleClinit(_Thread thread,_Class _class){
		_Method clinit=_class.getClinitMethod();
		if(clinit!=null){
			Frame newFrame=thread.newFrame(clinit);
			thread.pushFrame(newFrame);
		}
	}
	
	public static void initSuperClass(_Thread thread,_Class _class){
		if(!_class.isInterface()){
			_Class superClass=_class.getSuperClass();
			if(superClass!=null && !superClass.initStarted()){
				initClass(thread, superClass);
			}
		}
	}
}
