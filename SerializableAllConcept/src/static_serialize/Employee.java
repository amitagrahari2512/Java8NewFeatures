package static_serialize;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
		public String lastName;
		  static  String companyName;
		  transient  String address;
		  static transient String companyCEO;
}
