package final_serialize;

import java.io.Serializable;

public class Employee1 implements Serializable{
	private static final long serialVersionUID = 1L;
	
		public static final String education = "MCA";
		public transient static final String education1 = "MCA1";
		public String lastName;
		public final  String companyName = "TATA";
		public transient  String address;
		public final transient String companyCEO = "Jayshree";
	
}
