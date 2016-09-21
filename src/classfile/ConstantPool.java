package classfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ConstantPool {
	ConstantInfo[] infos;
	public static ConstantPool readConstantPool(InputStream in){
		ConstantPool constantPool=new ConstantPool();
		int cpcount=ClassReader.read16(in);
		constantPool.infos=new ConstantInfo[cpcount];
		// The constant_pool table is indexed from 1 to constant_pool_count - 1
		for(int i=1;i<cpcount;i++){
			constantPool.infos[i]=ConstantInfo.newConstantInfo(in, constantPool);
			constantPool.infos[i].readInfo(in, constantPool);
			System.out.println("#"+i+" = "+constantPool.infos[i].description());
			// Double, Long take two slots
			if(constantPool.infos[i] instanceof ConstantLongInfo ||
					constantPool.infos[i] instanceof ConstantDoubleInfo){
				i++;
			}
		}
		return constantPool;
	}
	
	public String getUtf8(int index){
		return ((ConstantUtf8Info)infos[index]).val;
	}
	
	public String getClassName(int index){
		ConstantClassInfo classInfo=(ConstantClassInfo)infos[index];
		return getUtf8(classInfo.nameIndex);
	}
	
	public String getNameAndType(int index){
		ConstantNameAndTypeInfo nameAndTypeInfo=(ConstantNameAndTypeInfo)infos[index];
		return getUtf8(nameAndTypeInfo.nameIndex);
	}
	
	public int getInteger(int index){
		ConstantIntegerInfo integerInfo=(ConstantIntegerInfo)infos[index];
		return integerInfo.val;
	}
	
	public long getLong(int index){
		ConstantLongInfo longInfo=(ConstantLongInfo)infos[index];
		return longInfo.val;
	}
	
	public float getFloat(int index){
		ConstantFloatInfo floatInfo=(ConstantFloatInfo)infos[index];
		return floatInfo.val;
	}
	
	public double getDouble(int index){
		ConstantDoubleInfo doubleInfo=(ConstantDoubleInfo)infos[index];
		return doubleInfo.val;
	}
	
	public static void main(String[] args){
		String path=System.getProperty("user.dir")+File.separator
				+"src"+File.separator+"test"+File.separator+"ClassFileTest.class";
		try {
			FileInputStream in=new FileInputStream(new File(path));
			in.skip(8);
//			int b;
//			while( (b=in.read())!=-1){
//				System.out.printf("%x ",b);
//			}
			ConstantPool cp=ConstantPool.readConstantPool(in);
			MemberInfo.readMembers(in, cp);
			MemberInfo.readMembers(in, cp);
			in.close();
		} catch (Exception e) {e.printStackTrace();}
		
	}
}
