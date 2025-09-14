package child_serialize;

public class Father {
	 
	 int parent = 1;
	 public Father() {
	 System.out.println("Father Constructor");
	 parent = 3;
	 }
	 {
	 System.out.println("Initialization Block..");
	 parent = 2;
	 }
	}