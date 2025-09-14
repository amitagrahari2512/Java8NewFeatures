package method_use_in_srialize;

import java.io.Serializable;

public class Employee implements Serializable{
	 	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		public String firstName;
	 	public String lastName;
	 	public String address;
	 	
	 	
	 	public String methodCall()
	 	{
	 		return firstName;
	 	}
}
