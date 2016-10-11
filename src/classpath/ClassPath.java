package classpath;

import java.io.File;
import java.util.Map;

public class ClassPath {
	Entry bootClasspath;
	Entry extClasspath;
	Entry userClasspath;
	
	public static ClassPath parse(String jreOption, String cpOption){
		
		ClassPath classPath=new ClassPath();
		classPath.parseBootAndExtClasspath(jreOption);
		classPath.parseUserClassPath(cpOption);
		return classPath;
	}
	
	void parseBootAndExtClasspath(String jreOption){
		String jreDir=getJreDir(jreOption);
		try {
			// jre/lib/*
			String jreLibPath = jreDir+File.separator+"lib"+File.separator+"*";
			this.bootClasspath = new WildCardEntry(jreLibPath);

			// jre/lib/ext/*
			String jreExtPath = jreDir+File.separator+"lib"+File.separator+"ext"+File.separator+"*";
			this.extClasspath = new WildCardEntry(jreExtPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	String getJreDir(String jreOption){
		if(jreOption!=null&&!jreOption.equals("")){
			return jreOption;
		}
		// ��ǰĿ¼Ѱ��./jre
		if(exits("jre")){
			return System.getProperty("user.dir")+File.separator+"jre";
		}
		// ϵͳ��������Ѱ��jre
		Map<String, String> m = System.getenv();
		if(m.get("JAVA_HOME")!=null){
			return m.get("JAVA_HOME")+File.separator+"jre";
		}
		return "";
	}
	
	boolean exits(String path){
		File file=new File(System.getProperty("user.dir")+File.separator+path);
		if(file.exists()){return true;}
		return false;
	}
	
	void parseUserClassPath(String path){
		if(path==null || path.equals("")){
			path=System.getProperty("user.dir");
		}
		this.userClasspath=Entry.newEntry(path);
	}
	// boot->ext->user
	public byte[] readClass(String className){
		System.err.println("classpath readclass="+className);
		className=className+".class";
		
		byte[] b=bootClasspath.readClass(className);
		
		if(b!=null&&b.length>0){
			return b;
		}
		
		b=extClasspath.readClass(className);
		if(b!=null&&b.length>0){
			return b;
		}
		
		b=userClasspath.readClass(className);
		if(b!=null&&b.length>0){
			return b;
		}
		return null;
	}
	
	public static void main(String[] args){
		 ClassPath classPath=ClassPath.parse("", "");
		 System.out.println(classPath.bootClasspath.toString());
		 byte[] b=classPath.readClass("java/lang/String");
        
		 for (int i = 0; i < b.length; i++) {
			System.out.print(b);
		}
	}
	
}
