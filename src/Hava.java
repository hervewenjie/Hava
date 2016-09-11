
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
		System.out.printf("classpath:%s class:%s xjre:%s",
				cmd.cpOption, cmd._class, cmd.XjreOption);
	}
	
}
