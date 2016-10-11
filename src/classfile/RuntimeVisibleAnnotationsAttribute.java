package classfile;

import java.io.InputStream;

//RuntimeVisibleAnnotations_attribute {
//    u2 attribute_name_index;
//    u4 attribute_length;
//    u2 num_annotations;
//    annotation annotations[num_annotations];
//  }
public class RuntimeVisibleAnnotationsAttribute extends AttributeInfo {
	int num_annotations;
	Annotation[] annotations;
	
	@Override
	void readInfo(InputStream in) {
		// TODO Auto-generated method stub
		num_annotations=ClassReader.read16(in);
		annotations=new Annotation[num_annotations];
		for(int i=0;i<num_annotations;i++){
			annotations[i]=new Annotation(in);
		}
	}
	
	public RuntimeVisibleAnnotationsAttribute() {
		// TODO Auto-generated constructor stub
		
	}
}

class Annotation {
	int type_index;
	int num_element_value_pairs;
	element_value_pairs[] pairs;
	public Annotation(InputStream in) {
		// TODO Auto-generated constructor stub
		type_index=ClassReader.read16(in);
		num_element_value_pairs=ClassReader.read16(in);
		pairs=new element_value_pairs[num_element_value_pairs];
		for(int i=0;i<num_element_value_pairs;i++){
			pairs[i]=new element_value_pairs();
		}
	}
}

class element_value_pairs {
	int element_name_index;
	element_value value;
}

class element_value {
	int tag;
	
}

class enum_const_value {
	int type_name_index;
	int const_name_index;
	public enum_const_value(InputStream in) {
		// TODO Auto-generated constructor stub
		type_name_index=ClassReader.read16(in);
		const_name_index=ClassReader.read16(in);
	}
}