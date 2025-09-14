package static_serialize;

import java.io.Serializable;

public class Employee1 implements Serializable{
	private static final long serialVersionUID = 1L;
	
		public String lastName;
		//static String companyName = "TATA";
		static String companyName ;
		  transient String address = "DEL";
		 //static transient String companyCEO = "Jayshree";
		  static transient String companyCEO ;
		  
		  static{
			  companyName = "TATA";
			  companyCEO = "Jayshree";
		  }
}
