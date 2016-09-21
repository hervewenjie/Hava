package classfile;

import java.io.InputStream;

public class ClassReader {
	public static int read8(InputStream in){
        int b=0;
        try {
            b=in.read();
        } catch (Exception e) {}
        return b;
    }

    public static int read16(InputStream in){
        int b=0;
        try {
            int b1=in.read();
            int b2=in.read();
            b = (b1<<8) + b2;
        } catch (Exception e) {}
        return b;
    }
    
    public static int[] read16s(InputStream in){
        int n=read16(in);
        int[] s=new int[n];
        for(int i=0;i<n;i++){
        		s[i]=read16(in);
        }
        return s;
    }

    public static int read32(InputStream in){
        int b=0;
        try {
            int b1=in.read();
            int b2=in.read();
            int b3=in.read();
            int b4=in.read();
            b = (b1<<24) + (b2<<16) + (b3<<8) + b4;
        } catch (Exception e) {}
        return b;
    }
    
    public static long read64(InputStream in){
        long b=0;
        try {
            int b1=in.read();
            int b2=in.read();
            int b3=in.read();
            int b4=in.read();
            int b5=in.read();
            int b6=in.read();
            int b7=in.read();
            int b8=in.read();
            b = (b1<<56) + (b2<<48) + (b3<<40) + (b4<<32) + (b5<<24)
            		+ (b6<<16) + (b7<<8) + b8;
        } catch (Exception e) {}
        return b;
    }

    public static String readString(InputStream in, int len){
        StringBuilder builder=new StringBuilder();
        try {
            for (int i=0;i<len;i++) {
                int b=in.read();
                char c= (char) b;
                builder.append(c);
            }
        } catch (Exception e) {}
        return builder.toString();
    }
    
    public static byte[] readBytes(InputStream in,int n){
    	byte[] bytes=new byte[n];
    	try {
    		for(int i=0;i<n;i++){
        		bytes[i]=(byte)in.read();
        	}
		} catch (Exception e) {}
    	return bytes;
    }

    // high<<8 + low to signed short as jump address
    public static int toSignedShort(int high, int low){
        int n=(high<<8)+low;
        int sum=0;
        for (int i=0;i<15;i++){
            int bit=(n>>i)&0x0001;
            sum+=Math.pow(2,i) * bit;
        }
        sum = sum-(int)Math.pow(2,15);
        return sum;
    }

    public static void main(String[] args){
        int high=0xff;
        int low=0xf3;
        System.out.println(toSignedShort(high,low));
    }
}
