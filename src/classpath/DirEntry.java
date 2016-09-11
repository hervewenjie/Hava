package classpath;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DirEntry extends Entry {
	
	String absDir;

	public DirEntry(String path) {
		absDir=new File(path).getAbsolutePath();
	}
	
	@Override
	byte[] readClass(String classname) {
		String filename=absDir+File.separator+classname;
		File file=new File(filename);
		long len=file.length();
		byte[] b=new byte[(int)len];
		try {
			FileInputStream in=new FileInputStream(file);
			in.read(b);
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}	

}
