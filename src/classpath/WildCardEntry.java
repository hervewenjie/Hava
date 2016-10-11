package classpath;

import java.io.File;
import java.util.ArrayList;

public class WildCardEntry extends Entry {

	ArrayList<Entry> compositeEntry=new ArrayList<>();
	
	public WildCardEntry(String jreLibPath) {
		String baseDir=jreLibPath.substring(0, jreLibPath.indexOf('*'));
		File file=new File(baseDir);
		File[] files=file.listFiles();
		for(File f:files){
			if(f.getName().endsWith(".jar")||f.getName().endsWith(".JAR")){
				compositeEntry.add(new ZipEntry_(f.getAbsolutePath()));
			}
		}
	}
	
	@Override
	byte[] readClass(String classname) {
		for(Entry e:compositeEntry){
			byte[] b=e.readClass(classname);
			if(b!=null&&b.length>1){
				return b;
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		WildCardEntry wildCardEntry=new WildCardEntry("/Users/Herve/Desktop/rt/java/io/*");
		byte[] b=wildCardEntry.readClass("PrintStream.class");
		System.out.println(b.length);
	}

}
