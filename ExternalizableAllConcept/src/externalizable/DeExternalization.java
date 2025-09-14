package externalizable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeExternalization {
	
	public static void main(String[] args) {
	// de-serialize the Car
		Car newCar = null;
			try {
			    FileInputStream fi = new FileInputStream("tmp");
			    ObjectInputStream si = new ObjectInputStream(fi);  	    
			    newCar = (Car) si.readObject();
			}
			catch (Exception e) {
			    System.out.println(e);
			    System.exit(1);
			}

			/* 
			 * Print out the original and new car information
			 */
			System.out.println("The new car is ");
		        System.out.println(newCar);
		    }
}
