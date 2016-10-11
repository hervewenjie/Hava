package rtdata;

import heap._Class;

public class _Object {
	_Class _class;
	Slot[] fields;

	public _Object(_Class _Class) {
		// TODO Auto-generated constructor stub
	}
	
	public Slot[] getFields(){return fields;}
	
	public String getClassName(){return _class.getName();}
	
	public _Class get_Class(){return _class;}
}
