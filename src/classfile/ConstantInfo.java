package classfile;

import java.io.InputStream;

/*
cp_info {
    u1 tag;
    u1 info[];
}
*/
public class ConstantInfo {
	
	public static final int CONSTANT_Class              = 7;
	public static final int CONSTANT_Fieldref           = 9;
    public static final int CONSTANT_Methodref          = 10;
	public static final int CONSTANT_InterfaceMethodref = 11;
	public static final int CONSTANT_String             = 8;
	public static final int CONSTANT_Integer            = 3;
    public static final int CONSTANT_Float              = 4;
    public static final int CONSTANT_Long               = 5;
    public static final int CONSTANT_Double             = 6;
    public static final int CONSTANT_NameAndType        = 12;
    public static final int CONSTANT_Utf8               = 1;
    public static final int CONSTANT_MethodHandle       = 15;
    public static final int CONSTANT_MethodType         = 16;
    public static final int CONSTANT_InvokeDynamic      = 18;
    
	public static ConstantInfo readConstantInfo(InputStream in,ConstantPool cp){
		int tag=ClassReader.read8(in);
		switch (tag) {
		case CONSTANT_Class:
			return new ConstantClassInfo(cp);
		case CONSTANT_Fieldref:
			break;
		case CONSTANT_Methodref:
			break;
		case CONSTANT_InterfaceMethodref:
			break;
		case CONSTANT_String:
			return new ConstantStringInfo(cp);
		case CONSTANT_Integer:
			return new ConstantIntegerInfo();
		case CONSTANT_Float:
			return new ConstantFloatInfo();
		case CONSTANT_Long:
			return new ConstantLongInfo();
		case CONSTANT_Double:
			return new ConstantDoubleInfo();
		case CONSTANT_NameAndType:
			break;
		case CONSTANT_Utf8:
			return new ConstantUtf8Info();
		case CONSTANT_MethodHandle:
			break;
		case CONSTANT_MethodType:
			break;
		case CONSTANT_InvokeDynamic:
			break;

		default:
			break;
		}
		return null;
	}
	
	public void readInfo(InputStream in){}
}
