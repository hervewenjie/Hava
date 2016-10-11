package test;

import java.io.File;
import java.io.FileInputStream;

public class FileReadTest {
	public static void main(String[] args){
		try {
			File file=new File("/Users/Herve/Desktop/rt/java/io/PrintStream.class");
			FileInputStream in=new FileInputStream(file);
			int n;
			while( (n=in.read()) != -1){
				System.out.printf("%x ",n);
			}
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
