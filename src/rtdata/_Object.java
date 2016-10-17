package rtdata;

import heap._Class;

public class _Object {
	_Class _class;
	Slot[] fields;
	
	public _Object() {
		// TODO Auto-generated constructor stub
	}

	public _Object(_Class _class) {
		// TODO Auto-generated constructor stub
		this._class=_class;
		fields=new Slot[_class.getInstanceSlotCount()];
		for(int i=0;i<fields.length;i++){fields[i]=new Slot();}
	}
	
	public Slot[] getFields(){return fields;}
	
	public String getClassName(){return _class.getName();}
	
	public _Class get_Class(){return _class;}
}
