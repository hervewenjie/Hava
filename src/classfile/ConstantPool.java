package classfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ConstantPool {
	ConstantInfo[] infos;
	public static ConstantPool readConstantPool(InputStream in){
		ConstantPool constantPool=new ConstantPool();
		int cpcount=ClassReader.read16(in);
		constantPool.infos=new ConstantInfo[cpcount];
		// The constant_pool table is indexed from 1 to constant_pool_count - 1
		for(int i=1;i<cpcount;i++){
			constantPool.infos[i]=ConstantInfo.readConstantInfo(in, constantPool);
			// Double, Long take two slots
			
		}
		return null;
	}
	
	public String getUtf8(int index){
		return ((ConstantUtf8Info)infos[index]).val;
	}
	
	public static void main(String[] args){
		String path=System.getProperty("user.dir")+File.separator
				+"src"+File.separator+"test"+File.separator+"ClassFileTest.class";
		try {
			FileInputStream in=new FileInputStream(new File(path));
			int b;
			//in.skip(8);
			while( (b=in.read())!=-1){
				System.out.printf("%x ",b);
			}
			in.close();
		} catch (Exception e) {e.printStackTrace();}
		
	}
}
