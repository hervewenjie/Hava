package heap;

import java.util.ArrayList;

public class MethodDescriptor {
	ArrayList<String> parameterTypes;
	String returnType;
	
	public MethodDescriptor() {
		// TODO Auto-generated constructor stub
		parameterTypes=new ArrayList<>();
	}
	
	public void addParameterType(String t){
		parameterTypes.add(t);
	}
}
