package classpath;

import java.io.File;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipEntry_ extends Entry {

	public String absPath;
	
	public ZipEntry_(String path) {
		absPath=new File(path).getAbsolutePath();
	}
	
	@Override
	byte[] readClass(String classname) {
		classname = classname.replace('\\', '/');
		try {
			ZipFile zipFile=new ZipFile(absPath);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while(entries.hasMoreElements()){
		        ZipEntry entry = entries.nextElement();
		        if (entry.getName().equals(classname)) {
					InputStream in=zipFile.getInputStream(entry);
					byte[] b=new byte[(int)entry.getSize()];
					// 这个方法貌似有问题, 文件大了之后后半部分读到都是0
					//in.read(b);
					for(int i=0;i<b.length;i++){
						byte onebyte=(byte)in.read();
						b[i]=onebyte;
					}
					return b;
				}
		    }
			zipFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		try {
			String path="/Library/Java/JavaVirtualMachines/jdk1.8.0_91.jdk/Contents/Home/jre/lib/rt.jar";
			ZipFile zipFile=new ZipFile(path);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while(entries.hasMoreElements()){
		        ZipEntry entry = entries.nextElement();
		        //System.out.println(entry.getName());
		        if (entry.getName().equals("java/io/PrintStream.class")) {
					System.out.println("Found");
					InputStream in=zipFile.getInputStream(entry);
					byte[] b=new byte[(int)entry.getSize()];
					//in.read(b);
					for(int i=0;i<b.length;i++){
						byte onebyte=(byte)in.read();
						b[i]=onebyte;
					}
					for(int i=0;i<b.length;i++){
						System.out.printf("%x ",b[i]);
					}
					System.out.println();
				}
		    }
			zipFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
