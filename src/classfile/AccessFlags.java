package classfile;

public class AccessFlags {
	public static final int ACC_PUBLIC = 0x0001;
	public static final int ACC_PRIVATE = 0x0002;
	public static final int ACC_PROTECTED = 0x0004;
	public static final int ACC_STATIC = 0x0008;
	public static final int ACC_FINAL = 0x0010;
	public static final int ACC_VOLATILE = 0x0040;
	public static final int ACC_TRANSIENT = 0x0080;
	public static final int ACC_SYNTHETIC = 0x1000;
	public static final int ACC_ENUM = 0x4000;
	
	public static String flagsToString(int flags){
		String desc="";
		int tmp;
		// 第一个4位
		tmp=flags&0x000F;
		if(tmp==1){
			desc+="public ";
		} else if (tmp==2) {
			desc+="private ";
		} else if (tmp==4) {
			desc+="protected ";
		} else if (tmp==8) {
			desc+="static ";
		} else if (tmp==9) {
			desc+="public static ";
		}
		
		// 第二个4位
		tmp=(flags>>4)&0x000F;
		if(tmp==1){
			desc+="final ";
		} else if (tmp==4) {
			desc+="volatile ";
		} else if (tmp==8) {
			desc+="transient ";
		}
		return desc;
	}
}
