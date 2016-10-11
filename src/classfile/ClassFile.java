package classfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import heap._Class;

/*
ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;
    cp_info        constant_pool[constant_pool_count-1];
    u2             access_flags;
    u2             this_class;
    u2             super_class;
    u2             interfaces_count;
    u2             interfaces[interfaces_count];
    u2             fields_count;
    field_info     fields[fields_count];
    u2             methods_count;
    method_info    methods[methods_count];
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
*/
public class ClassFile {
	InputStream in;
	
	int magic;
	int minor_version;
	int major_version;
	int constant_pool_count;
	public ConstantPool constantPool;
	public int access_flags;
	int this_class;
	int super_class;
	int interfaces_count;
	int[] interfaces;
	public MemberInfo[] fields;
	public MemberInfo[] methods;
	AttributeInfo[] attributes;
	
	public ClassFile(InputStream in) {
		// TODO Auto-generated constructor stub
		this.in=in;
	}
	
	public static ClassFile parse(InputStream in){
		ClassFile classFile=new ClassFile(in);
		classFile.read();
		return classFile;
	}

	void read(){
		readAndCheckMagic();
		readAndCheckVersions();
		constantPool=ConstantPool.readConstantPool(in);
		access_flags=ClassReader.read16(in);
		this_class=ClassReader.read16(in);
		super_class=ClassReader.read16(in);
		interfaces=ClassReader.read16s(in);
		fields=MemberInfo.readMembers(in, constantPool);
		methods=MemberInfo.readMembers(in, constantPool);
		// TODO attr
	}
	
	void readAndCheckMagic(){
		magic=ClassReader.read32(in);
		if(magic!=0xCAFEBABE){
			System.err.println("Bad Magic");
			System.exit(1);
		}
	}
	
	void readAndCheckVersions(){
		minor_version=ClassReader.read16(in);
		major_version=ClassReader.read16(in);
		switch (major_version) {
		case 45:
			return;
		case 46:
			if(minor_version==0){return;}
			break;
		case 47:
			if(minor_version==0){return;}
			break;
		case 48:
			if(minor_version==0){return;}
			break;
		case 49:
			if(minor_version==0){return;}
			break;
		case 50:
			if(minor_version==0){return;}
			break;
		case 51:
			if(minor_version==0){return;}
			break;
		case 52:
			if(minor_version==0){return;}
			break;
			
		}
		System.err.println("Bad Version");
		System.exit(1);
	}
	
	public String getClassName(){
		return constantPool.getClassName(this_class);
	}
	
	public String getSuperClassName(){
		if(super_class>0){
			return constantPool.getClassName(super_class);
		}
		return "";
	}
	
	public String[] getInterfaceNames(){
		String[] names=new String[interfaces.length];
		for(int i=0;i<names.length;i++){
			names[i]=constantPool.getClassName(interfaces[i]);
		}
		return names;
	}
	
	public static void main(String[] args){
		String path=System.getProperty("user.dir")+File.separator
				+"src"+File.separator+"test"+File.separator+"ClassFileTest.class";
		
		path="/Users/Herve/Desktop/rt/java/io/PrintStream.class";
		try {
			FileInputStream in=new FileInputStream(new File(path));
			
//			int b;
//			while( (b=in.read())!=-1){
//				System.out.printf("%x ",b);
//			}
			ClassFile cf=new ClassFile(in);
			cf.read();
			in.close();
			
			// Test _Class in package heap
//			System.out.println("===================");
//			_Class _c=new _Class(cf);
			
		} catch (Exception e) {e.printStackTrace();}
		
	}
}
