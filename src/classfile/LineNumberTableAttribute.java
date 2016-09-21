package classfile;

import java.io.InputStream;

/*
LineNumberTable_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
    u2 line_number_table_length;
    {   u2 start_pc;
        u2 line_number;
    } line_number_table[line_number_table_length];
}
*/
public class LineNumberTableAttribute extends AttributeInfo {
	LineNumberTableEntry[] lineNumberTable;
	
	@Override
	void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		int lineNumberTableLength=ClassReader.read16(in);
		lineNumberTable=new LineNumberTableEntry[lineNumberTableLength];
		for(int i=0;i<lineNumberTableLength;i++){
			lineNumberTable[i]=new LineNumberTableEntry(in);
		}
	}
}

class LineNumberTableEntry {
	int startPc;
	int lineNumber;
	
	public LineNumberTableEntry(InputStream in) {
		// TODO Auto-generated constructor stub
		startPc=ClassReader.read16(in);
		lineNumber=ClassReader.read16(in);
	}
}
