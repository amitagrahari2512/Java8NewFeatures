package final_serialize;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	
		public static final String education ;
		public transient static final String education1 ;
		public String lastName;
		public final  String companyName;
		public transient  String address;
		public final transient String companyCEO ;
		  
		static{
			education = "MCA";
			education1 = "MCA1";
		}
		  public Employee(String companyName , String companyCEO)
		  {
			  this.companyName = companyName;
			  this.companyCEO = companyCEO;
		  }
}
