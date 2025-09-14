package use_serial_version_id;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializable {
	public static void main(String[] args) {
	    Employee emp = new Employee();
	    emp.firstName = "Vivekanand";
	    emp.lastName = "Gautam";
	    try {
	      FileOutputStream fileOut = new FileOutputStream("./employee.txt");
	      ObjectOutputStream out = new ObjectOutputStream(fileOut);
	      out.writeObject(emp);
	      out.close();
	      fileOut.close();
	      System.out.printf("Serialized data is saved in ./employee.txt file");
	    } catch (IOException i) {
	      i.printStackTrace();
	    }
	  }
}
