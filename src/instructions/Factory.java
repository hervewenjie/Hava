package instructions;

import instructions.comparisons.*;
import instructions.constants.*;
import instructions.constrol.GOTO;
import instructions.conversions.*;
import instructions.loads.*;
import instructions.math.*;
import instructions.references.GETSTATIC;
import instructions.references.GET_FIELD;
import instructions.references.INVOKE_SPECIAL;
import instructions.references.INVOKE_STATIC;
import instructions.references.INVOKE_VIRTUAL;
import instructions.references.NEW;
import instructions.references.PUTSTATIC;
import instructions.references.PUT_FIELD;
import instructions.stack.*;
import instructions.stores.*;

public class Factory {
	public static Instruction nop=new NOP();
	//public static Instruction aconst_null=new AC();
	public static Instruction iconst_m1=new ICONST_M1();
	public static Instruction iconst_0=new ICONST_0();
	public static Instruction iconst_1=new ICONST_1();
	public static Instruction iconst_2=new ICONST_2();
	public static Instruction iconst_3=new ICONST_3();
	public static Instruction iconst_4=new ICONST_4();
	public static Instruction iconst_5=new ICONST_5();
	public static Instruction lconst_0=new LCONST_0();
	public static Instruction lconst_1=new LCONST_1();
	public static Instruction fconst_0=new FCONST_0();
	public static Instruction fconst_1=new FCONST_1();
	public static Instruction dconst_0=new DCONST_0();
	public static Instruction dconst_1=new DCONST_1();
	public static Instruction iload_0=new ILOAD_0();
	public static Instruction iload_1=new ILOAD_1();
	public static Instruction iload_2=new ILOAD_2();
	public static Instruction iload_3=new ILOAD_3();
	public static Instruction lload_0=new LLOAD_0();
	public static Instruction lload_1=new LLOAD_1();
	public static Instruction lload_2=new LLOAD_2();
	public static Instruction lload_3=new LLOAD_3();
	public static Instruction fload_0=new FLOAD_0();
	public static Instruction fload_1=new FLOAD_1();
	public static Instruction fload_2=new FLOAD_2();
	public static Instruction fload_3=new FLOAD_3();
	public static Instruction dload_0=new DLOAD_0();
	public static Instruction dload_1=new DLOAD_1();
	public static Instruction dload_2=new DLOAD_2();
	public static Instruction dload_3=new DLOAD_3();
	public static Instruction aload_0=new ALOAD_0();
	public static Instruction aload_1=new ALOAD_1();
	public static Instruction aload_2=new ALOAD_2();
	public static Instruction aload_3=new ALOAD_3();
	
	public static Instruction newInstruction(int opcode){
		switch (opcode) {
		case 0x00:
			return new NOP();
		case 0x01:
			//return new NOP();
		case 0x02:
			return new ICONST_M1();
		case 0x03:
			return new ICONST_0();
		case 0x04:
			return new ICONST_1();
		case 0x05:
			return new ICONST_2();
		case 0x06:
			return new ICONST_3();
		case 0x07:
			return new ICONST_4();
		case 0x08:
			return new ICONST_5();
		case 0x09:
			return new LCONST_0();
		case 0x0a:
			return new LCONST_1();
		case 0x0b:
			return new FCONST_0();
		case 0x0c:
			return new FCONST_1();
		case 0x0d:
			return new FCONST_2();
		case 0x0e:
			return new DCONST_0();
		case 0x0f:
			return new DCONST_1();
		case 0x10:
			return new BIPUSH();
		case 0x11:
			return new SIPUSH();
		case 0x15:
			return new ILOAD();
		case 0x16:
			return new LLOAD();
		case 0x17:
			return new FLOAD();
		case 0x18:
			return new DLOAD();
		case 0x19:
			return new ALOAD();
		case 0x1a:
			return new ILOAD_0();
		case 0x1b:
			return new ILOAD_1();
		case 0x1c:
			return new ILOAD_2();
		case 0x1d:
			return new ILOAD_3();
		case 0x1e:
			return new LLOAD_0();
		case 0x1f:
			return new LLOAD_1();
		case 0x20:
			return new LLOAD_2();
		case 0x21:
			return new LLOAD_3();
		case 0x22:
			return new FLOAD_0();
		case 0x23:
			return new FLOAD_1();
		case 0x24:
			return new FLOAD_2();
		case 0x25:
			return new FLOAD_3();
		case 0x26:
			return new DLOAD_0();
		case 0x27:
			return new DLOAD_1();
		case 0x28:
			return new DLOAD_2();
		case 0x29:
			return new DLOAD_3();
		case 0x2a:
			return new ALOAD_0();
		case 0x2b:
			return new ALOAD_1();
		case 0x2c:
			return new ALOAD_2();
		case 0x2d:
			return new ALOAD_3();
		case 0x36:
			return new ISTORE();
		case 0x37:
			return new LSTORE();
		case 0x38:
			return new FSTORE();
		case 0x39:
			return new ISTORE();
		case 0x3a:
			return new ASTORE();
		case 0x3b:
			return new ISTORE_0();
		case 0x3c:
			return new ISTORE_1();
		case 0x3d:
			return new ISTORE_2();
		case 0x3e:
			return new ISTORE_3();
		case 0x3f:
			return new LSTORE_0();
		case 0x40:
			return new LSTORE_1();
		case 0x41:
			return new LSTORE_2();
		case 0x42:
			return new LSTORE_3();
		case 0x43:
			return new FSTORE_0();
		case 0x44:
			return new FSTORE_1();
		case 0x45:
			return new FSTORE_2();
		case 0x46:
			return new FSTORE_3();
		case 0x47:
			return new DSTORE_0();
		case 0x48:
			return new DSTORE_1();
		case 0x49:
			return new DSTORE_2();
		case 0x4a:
			return new DSTORE_3();
		case 0x4b:
			return new ASTORE_0();
		case 0x4c:
			return new ASTORE_1();
		case 0x4d:
			return new ASTORE_2();
		case 0x4e:
			return new ASTORE_3();
		case 0x57:
			return new POP();
		case 0x58:
			return new POP2();
		case 0x59:
			return new DUP();
		case 0x5a:
			return new DUP_X1();
		case 0x5b:
			return new DUP_X2();
		case 0x5c:
			return new DUP2();
		case 0x5d:
			return new DUP2_X1();
		case 0x5e:
			return new DUP2_X2();
		case 0x5f:
			return new SWAP();
		case 0x60:
			return new IADD();
		case 0x61:
			return new LADD();
		case 0x62:
			return new FADD();
		case 0x63:
			return new DADD();
		case 0x64:
			return new ISUB();
		case 0x65:
			return new LSUB();
		case 0x66:
			return new FSUB();
		case 0x67:
			return new DSUB();
		case 0x68:
			return new IMUL();
		case 0x69:
			return new LMUL();
		case 0x6a:
			return new FMUL();
		case 0x6b:
			return new DMUL();
		case 0x6c:
			return new IDIV();
		case 0x6d:
			return new IDIV();
		case 0x6e:
			return new FDIV();
		case 0x6f:
			return new DDIV();
		case 0x70:
			return new IREM();
		case 0x71:
			return new LREM();
		case 0x72:
			return new FREM();
		case 0x73:
			return new DREM();
		case 0x74:
			return new INEG();
		case 0x75:
			return new LNEG();
		case 0x76:
			return new FNEG();
		case 0x77:
			return new DNEG();
		case 0x78:
			return new ISHL();
		case 0x79:
			return new LSHL();
		case 0x7a:
			return new ISHL();
		case 0x7b:
			return new LSHR();
		case 0x7c:
			return new IUSHR();
		case 0x7d:
			return new LUSHR();
		case 0x7e:
			return new IAND();
		case 0x7f:
			return new LAND();
		case 0x80:
			return new IOR();
		case 0x81:
			return new LOR();
		case 0x82:
			return new IXOR();
		case 0x83:
			return new LXOR();
		case 0x84:
			return new IINC();
		case 0x85:
			return new I2L();
		case 0x86:
			return new I2F();
		case 0x87:
			return new I2D();
		case 0x88:
			return new IXOR();
		case 0x89:
			return new L2F();
		case 0x8a:
			return new L2D();
		case 0x8b:
			return new F2I();
		case 0x8c:
			return new F2L();
		case 0x8d:
			return new F2D();
		case 0x8e:
			return new D2I();
		case 0x8f:
			return new D2L();
		case 0x90:
			return new D2F();
		case 0x91:
			return new I2B();
		case 0x92:
			return new I2C();
		case 0x93:
			return new I2S();
		case 0x94:
			return new LCMP();
		case 0x95:
			return new FCMPL();
		case 0x96:
			return new FCMPG();
		case 0x97:
			return new DCMPL();
		case 0x98:
			return new DCMPG();
		case 0x99:
			return new IFEQ();
		case 0x9a:
			return new IFNE();
		case 0x9b:
			return new IFLT();
		case 0x9c:
			return new IFGE();
		case 0x9d:
			return new IFGT();
		case 0x9e:
			return new IFLE();
		case 0x9f:
			return new IF_ICMPEQ();
		case 0xa0:
			return new IF_ICMPNE();
		case 0xa1:
			return new IF_ICMPLT();
		case 0xa2:
			return new IF_ICMPGE();
		case 0xa3:
			return new IF_ICMPGT();
		case 0xa4:
			return new IF_ICMPLE();
		case 0xa5:
			return new IF_ACMPEQ();
		case 0xa6:
			return new IF_ACMPNE();
		case 0xa7:
			return new GOTO();
		case 0xbb:
			return new NEW();
		case 0xb3:
			return new PUTSTATIC();
		case 0xb2:
			return new GETSTATIC();
		case 0xb5:
			return new PUT_FIELD();
		case 0xb4:
			return new GET_FIELD();
		case 0xb7:
			return new INVOKE_SPECIAL();
		case 0xb8:
			return new INVOKE_STATIC();
		case 0xb6:
			return new INVOKE_VIRTUAL();
			
		default:
			System.err.println("OPCODE ERR");
			System.exit(1);
			return null;
		}
	}
}
