package classfile;

import java.io.InputStream;

/*
Code_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 max_stack;
    u2 max_locals;
    u4 code_length;
    u1 code[code_length];
    u2 exception_table_length;
    {   u2 start_pc;
        u2 end_pc;
        u2 handler_pc;
        u2 catch_type;
    } exception_table[exception_table_length];
    u2 attributes_count;
    attribute_info attributes[attributes_count];
}
*/
public class CodeAttribute extends AttributeInfo {
	
    ConstantPool cp;
	int maxStack;
	int maxLocals;  
	byte[] code;
	ExceptionTableEntry[] exceptionTable;
	AttributeInfo[] attributes;
	
	public CodeAttribute(ConstantPool cp) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
	}

	@Override
	void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		maxStack=ClassReader.read16(in);
		maxLocals=ClassReader.read16(in);
		int codeLen=ClassReader.read32(in);
		code=ClassReader.readBytes(in, codeLen);
		exceptionTable=ExceptionTableEntry.readExceptionTable(in);
		attributes=AttributeInfo.readAttributes(in, cp);
	}
}
