import java.io.File;

import classpath.ClassPath;

public class Hava {
	public static void main(String[] args){
		Cmd cmd=Cmd.parseCmd(args);
		
		if (cmd.versionFlag) {
			System.out.println("Version 0.0.1");
		} else if (cmd.helpFlag || cmd._class.equals("")) {
			Cmd.printUsage(cmd);
		} else {
			startJvm(cmd);
		}
	}
	
	public static void startJvm(Cmd cmd){
		System.out.println("Starting Jvm");
		ClassPath classPath=ClassPath.parse(cmd.XjreOption,cmd.cpOption);
		String className=cmd._class.replace('.', File.separatorChar);
		byte[] b=classPath.readClass(className);
		System.out.println(b.length);
		for(int i=0;i<b.length;i++){
			System.out.printf("%x ",b[i]);
			System.out.println();
		}
	}
	
}
