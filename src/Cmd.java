/*
 * Args must be in the following order:
 * MyApp arg1 arg2 -cp foo/bar 
 */
public class Cmd {
	boolean helpFlag;
	boolean versionFlag;
	String cpOption;
	String XjreOption;
	String _class;
	String[] args;
	
	public static Cmd parseCmd(String[] args){
		Cmd cmd=new Cmd();
		for(int i=0;i<args.length;i++){
			switch (args[i]) {
			case "-help":
				cmd.helpFlag=true;
				break;
			case "-version":
				cmd.versionFlag=true;
				break;
			case "-cp":
				cmd.cpOption=args[++i];
				break;
			case "-classpath":
				cmd.cpOption=args[++i];
				break;
			case "-Xjre":
				cmd.XjreOption=args[++i];
				break;
			default:
				break;
			}
		}
		cmd._class=args[0];
		return cmd;
	}
	
	public static void printUsage(Cmd cmd){
		System.out.println("Print usage");
	}
}
