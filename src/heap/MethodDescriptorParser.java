package heap;

public class MethodDescriptorParser {
	String raw;
	int offset;
	MethodDescriptor parsed;
	
	public static MethodDescriptor parseMethodDescriptor(String descriptor){
		MethodDescriptorParser parser=new MethodDescriptorParser();
		return parser.parse(descriptor);
	}
	
	public MethodDescriptor parse(String descriptor){
		raw=descriptor;
		parsed=new MethodDescriptor();
		startParams();
		parseParamTypes();
		endParams();
		parseReturnType();
		finish();
		return parsed;
	}
	
	public void startParams(){
		if(readUint8()!='('){
			System.err.println("BAD descriptor");
			System.exit(1);
		}
	}
	
	public void endParams(){
		if(readUint8()!=')'){
			System.err.println("BAD descriptor");
			System.exit(1);
		}
	}
	
	public void finish(){
		if(offset!=raw.length()){
			System.err.println("BAD descriptor");
			System.exit(1);
		}
	}
	
	public int readUint8(){
		char c=raw.charAt(offset);
		offset++;
		return (int)c;
	}
	
	public void unreadUint8(){offset--;}
	
	public void parseParamTypes(){
		String t;
		while(true){
			t=parseFieldType();
			if(t!=""){
				parsed.addParameterType(t);
			} else {
				break;
			}
		}
	}
	
	public void parseReturnType(){
		if(readUint8() == 'V'){
			parsed.returnType="V";
			return;
		}
		unreadUint8();
		String t=parseFieldType();
		if(!t.equals("")){
			parsed.returnType=t;
			return;
		}
	}
	
	public String parseFieldType(){
		switch (readUint8()) {
		case 'B':
			return "B";
		case 'C':
			return "C";
		case 'D':
			return "D";
		case 'F':
			return "F";
		case 'I':
			return "I";
		case 'J':
			return "J";
		case 'S':
			return "S";
		case 'Z':
			return "Z";
		case 'L':
			return parseObjectType();
		case '[':
			return parseArrayType();
		default:
			unreadUint8();
			return "";
		}
	}
	
	public String parseObjectType(){
		String unread=raw.substring(offset);
		int semicolonIndex=unread.indexOf(';');
		if(semicolonIndex==-1){
			System.err.println("BAD descriptor");
		} else {
			int objStart=offset-1;
			int objEnd=offset+semicolonIndex+1;
			offset=objEnd;
			String descriptor=raw.substring(objStart);
			return descriptor;
		}
		return "";
	}
	
	public String parseArrayType(){
		int arrStart=offset-1;
		parseFieldType();
		int arrEnd=offset;
		String descriptor=raw.substring(arrStart, arrEnd);
		return descriptor;
	}
	
}
