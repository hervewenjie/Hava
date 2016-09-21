package classfile;

import java.io.InputStream;

/*
Exceptions_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 number_of_exceptions;
    u2 exception_index_table[number_of_exceptions];
}
*/
public class ExceptionsAttribute extends AttributeInfo {
	int[] exceptionIndexTable;
	
	@Override
	void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		exceptionIndexTable=ClassReader.read16s(in);
	}
}
