import java.io.ByteArrayInputStream;
import java.io.File;

import classfile.ClassFile;
import classfile.MemberInfo;
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
		ClassFile classFile=loadClass(className, classPath);
		MemberInfo mainMethod=getMainMethod(classFile);
		if(mainMethod!=null){
			System.out.println("Main found");
			Interpreter interpreter=new Interpreter();
			interpreter.interpret(mainMethod);
		} else {
			System.err.printf("Main method not found in class %s\n",cmd._class);
		}
		
	}
	
	public static ClassFile loadClass(String className,ClassPath path){
		byte[] classData=path.readClass(className);
		ClassFile classFile=ClassFile.parse(new ByteArrayInputStream(classData));
		return classFile;
	}
	
	public static MemberInfo getMainMethod(ClassFile classFile){
		for(MemberInfo info:classFile.methods){
			if(info.getName().equals("main") &&
					info.getDescriptor().equals("([Ljava/lang/String;)V")){
				return info;
			}
		}
		return null;
	}
	
}
