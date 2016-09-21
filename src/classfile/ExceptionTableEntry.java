package classfile;

import java.io.InputStream;

public class ExceptionTableEntry {

	int startPc;
	int endPc;
	int handlerPc;
	int catchType;
	
	public ExceptionTableEntry(InputStream in) {
		// TODO Auto-generated constructor stub
		startPc=ClassReader.read16(in);
		endPc=ClassReader.read16(in);
		handlerPc=ClassReader.read16(in);
		catchType=ClassReader.read16(in);
	}
	
	static ExceptionTableEntry[] readExceptionTable(InputStream in){
		int exceptionTableLength=ClassReader.read16(in);
		ExceptionTableEntry[] exceptionTable=new ExceptionTableEntry[exceptionTableLength];
		for(int i=0;i<exceptionTableLength;i++){
			exceptionTable[i]=new ExceptionTableEntry(in);
		}
		return exceptionTable;
	}
}
