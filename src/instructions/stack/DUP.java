package instructions.stack;

import instructions.NoOperandsInstruction;
import rtdata.Frame;
import rtdata.Slot;
import rtdata._Object;

public class DUP extends NoOperandsInstruction {
	@Override
	public void execute(Frame frame) {
		// TODO Auto-generated method stub
		Slot slot=frame.operandStack.popSlot();
		Slot slot1=new Slot();
		slot1.setNum(slot.getNum());
		slot1.setRef(slot.getRef());
		Slot slot2=new Slot();
		slot2.setNum(slot.getNum());
		slot2.setRef(slot.getRef());
		frame.operandStack.pushSlot(slot1);
		frame.operandStack.pushSlot(slot2);
	}
}
