package classpath;

import java.io.File;

public abstract class Entry {
	abstract byte[] readClass(String classname);
	
	static Entry newEntry(String path){
		if(path.contains(File.separator)){
			return new CompositeEntry(path);
		}
		else if(path.endsWith("*")){
			
		}
		else if(path.endsWith(".jar") || path.endsWith(".JAR")
				|| path.endsWith(".zip") || path.endsWith(".ZIP")){
			return new ZipEntry_(path);
		}
		return new DirEntry(path);
	}
	public static void main(String[] args){
		System.out.println(File.separator);
	}
}
