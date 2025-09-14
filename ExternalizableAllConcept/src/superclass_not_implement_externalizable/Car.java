package superclass_not_implement_externalizable;

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
		/* 
		 * Since the superclass does not implement the Serializable interface
		 * we explicitly do the saving.
		 */
		out.writeObject(regNo);
		out.writeObject(mileage);
		
		out.writeObject(name);
		out.writeInt(year);
	}

	/**
	 * Mandatory readExternal method.
	 */
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		/* 
		 * Since the superclass does not implement the Serializable interface
		 * we explicitly do the restoring
		 */
		regNo = (String) in.readObject();
		mileage = (String) in.readObject();
		
		name = (String) in.readObject();
		year = in.readInt();
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
