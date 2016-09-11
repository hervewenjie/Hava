package classpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

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
					in.read(b);
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
			String path="C:\\Program Files\\Java\\jdk1.8.0_77\\jre\\lib\\rt.jar";
			ZipFile zipFile=new ZipFile(path);
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while(entries.hasMoreElements()){
		        ZipEntry entry = entries.nextElement();
		        System.out.println(entry.getName());
		        if (entry.getName().equals("java/lang/Object.class")) {
					System.out.println("Found");
					InputStream in=zipFile.getInputStream(entry);
					byte[] b=new byte[(int)entry.getSize()];
					in.read(b);
					//for(int i=0;i<b.length;i++){System.out.println(b[i]);}
				}
		    }
			zipFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
