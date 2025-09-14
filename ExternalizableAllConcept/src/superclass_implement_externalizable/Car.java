package superclass_implement_externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car extends Automobile implements Externalizable{
	
	private static final long serialVersionUID = 1L; 
	String name;
	int year;

/*
 * mandatory public no-arg constructor
 */
public Car() {
		//super();
		System.out.println("Default Car constructor");
	}

	Car(String n, int y , String r ,String m) {
		super(r,m);
		name = n;
		year = y;
		
	}

	/**
	 * Mandatory writeExernal method.
	 */
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		//SuperClass writeExternal() method call;
		//super.writeExternal(out);
		
		out.writeObject(name);
		out.writeInt(year);
		super.writeExternal(out);
	}

	/**
	 * Mandatory readExternal method.
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		//SubClass readExternal() method call;
		//super.readExternal(in);
		
		name = (String) in.readObject();
		year = in.readInt();
		super.readExternal(in);
	}

	/**
	 * Prints out the fields. used for testing!
	 */
	@Override
	public String toString() {
		return("Reg No: " + regNo + "\n" + "Mileage: " + mileage + "\n" +
			       "Name: " + name + "\n" + "Year: " + year );
	}

}
