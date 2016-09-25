package classfile;

import java.io.InputStream;

/*
 * StackMapTable_attribute {
    u2              attribute_name_index;
    u4              attribute_length;
    u2              number_of_entries;
    stack_map_frame entries[number_of_entries];
}
 */
public class StackMapTableAttribute extends AttributeInfo {
	int attribute_name_index;;
	int attribute_length;
	int number_of_entries;
	StackMapFrame[] entries;
	
	@Override
	void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		attribute_name_index=ClassReader.read16(in);
		attribute_length=ClassReader.read32(in);
		number_of_entries=ClassReader.read16(in);
		entries=new StackMapFrame[number_of_entries];
		for(int i=0;i<number_of_entries;i++){
			entries[i]=StackMapFrame.newStackMapFrame(in);
		}
	}
}

/*
 * union stack_map_frame {
    same_frame;
    same_locals_1_stack_item_frame;
    same_locals_1_stack_item_frame_extended;
    chop_frame;
    same_frame_extended;
    append_frame;
    full_frame;
}
 */
class StackMapFrame {
	
	public static StackMapFrame newStackMapFrame(InputStream in){
		int frame_type=ClassReader.read8(in);
		if(frame_type>=248&&frame_type<=250){
			// chop frame
			return new ChopFrame(in, frame_type);
		} else if (frame_type>=252&&frame_type<=254) {
			return new AppendFrame(in, frame_type);
		}
		
		return null;
	}
}

//chop_frame {
//    u1 frame_type = CHOP; /* 248-250 */
//    u2 offset_delta;
//}
class ChopFrame extends StackMapFrame {
	int frame_type;
	int offset_delta;
	public ChopFrame(InputStream in,int frame_type) {
		// TODO Auto-generated constructor stub
		this.frame_type=frame_type;
		offset_delta=ClassReader.read16(in);
	}
}

//append_frame {
//    u1 frame_type = APPEND; /* 252-254 */
//    u2 offset_delta;
//    verification_type_info locals[frame_type - 251];
//}
class AppendFrame extends StackMapFrame {
	int frame_type;
	int offset_delta;
	VerificationTypeInfo[] locals;
	
	public AppendFrame(InputStream in,int frame_type) {
		// TODO Auto-generated constructor stub
		this.frame_type=frame_type;
		offset_delta=ClassReader.read16(in);
		locals=new VerificationTypeInfo[frame_type-251];
		for(int i=0;i<locals.length;i++){
			locals[i]=new VerificationTypeInfo(in);
		}
	}
}

class VerificationTypeInfo {
	public VerificationTypeInfo(InputStream in) {
		// TODO Auto-generated constructor stub
		int tag=ClassReader.read8(in);
		if(tag>=0&&tag<=6){
			
		}else if (tag>=7&&tag<=8) {
			ClassReader.read16(in);
		}
	}
}
