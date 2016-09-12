package classfile;

import java.io.InputStream;

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
	ConstantPool constantPool;
	int access_flags;
	int this_class;
	int super_class;
	int interfaces_count;
	int[] interfaces;
	MemberInfo[] fields;
	MemberInfo[] methods;
	AttributeInfo[] attributes;
	
	public ClassFile(InputStream in) {
		// TODO Auto-generated constructor stub
		this.in=in;
	}
	
	ClassFile parse(InputStream in){
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
	
	
}
