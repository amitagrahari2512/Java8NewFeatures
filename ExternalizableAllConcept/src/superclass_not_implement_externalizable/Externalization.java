package superclass_not_implement_externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Externalization {
	public static void main(String args[]) {

		// create a Car object 
		Car car = new Car("Mitsubishi", 2009 , "registration", "mileinge");
		
		//serialize the car
		try {
		    FileOutputStream fo = new FileOutputStream("tmp");
		    ObjectOutputStream so = new ObjectOutputStream(fo);
		    so.writeObject(car);
		    so.flush();
		    System.out.println("Externalization done");
		} catch (Exception e) {
		    System.out.println(e);
		}
		
	}
		
}
