package classfile;

import java.io.InputStream;

public class ConstantPool {
	ConstantInfo[] infos;
	public static ConstantPool readConstantPool(InputStream in){
		ConstantPool constantPool=new ConstantPool();
		int cpcount=ClassReader.read16(in);
		constantPool.infos=new ConstantInfo[cpcount];
		// The constant_pool table is indexed from 1 to constant_pool_count - 1
		for(int i=1;i<cpcount;i++){
			constantPool.infos[i]=ConstantInfo.readConstantInfo(in, null);
			// Double, Long take two slots
			
		}
		return null;
	}
}
