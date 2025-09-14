package static_serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializaitonClass1 {
	public static void main(String[] args) {
	    Employee1 emp = new Employee1();
	    //emp.firstName = "Vivekanand";
	    emp.lastName = "Gautam";
	    emp.companyName = "JBT";
	    //Below part needs to be removed in case address field is made final
	    emp.address = "MUM";
	    emp.companyCEO = "ME CEO";
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
