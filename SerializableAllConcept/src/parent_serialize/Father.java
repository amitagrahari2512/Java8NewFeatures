package parent_serialize;

import java.io.Serializable;

public class Father implements Serializable{
	 
	 int parent = 1;
	 public Father() {
		 System.out.println("Father Constructor...");
		 parent = 3;
		 }
		 {
		 parent = 2;
		 System.out.println("Instance Block....");
		 }
}
