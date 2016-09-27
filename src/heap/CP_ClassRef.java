package heap;

public class CP_ClassRef extends CP_SymRef {
	public CP_ClassRef(ConstantPool cp,classfile.ConstantClassInfo cfcci) {
		// TODO Auto-generated constructor stub
		this.cp=cp;
		this.className=cfcci.getName();
	}
}
