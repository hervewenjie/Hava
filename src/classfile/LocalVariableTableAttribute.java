package classfile;

import java.io.InputStream;

/*
LocalVariableTable_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 local_variable_table_length;
    {   u2 start_pc;
        u2 length;
        u2 name_index;
        u2 descriptor_index;
        u2 index;
    } local_variable_table[local_variable_table_length];
}
*/
public class LocalVariableTableAttribute  extends AttributeInfo {
	@Override
	void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		int localVariableTableLength=ClassReader.read16(in);
		LocalVariableTableEntry[] table=new LocalVariableTableEntry[localVariableTableLength];
		for(int i=0;i<localVariableTableLength;i++){
			table[i]=new LocalVariableTableEntry(in);
		}
	}
}

class LocalVariableTableEntry {
	int startPc;
	int length;
	int nameIndex;
	int descriptorIndex;
	int index;
	
	public LocalVariableTableEntry(InputStream in) {
		// TODO Auto-generated constructor stub
		startPc=ClassReader.read16(in);
		length=ClassReader.read16(in);
		nameIndex=ClassReader.read16(in);
		descriptorIndex=ClassReader.read16(in);
		index=ClassReader.read16(in);
	}
}
