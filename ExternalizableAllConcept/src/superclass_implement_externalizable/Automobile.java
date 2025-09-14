package superclass_implement_externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Automobile implements Externalizable{
    
    /*
     * Instead of making thse members private and adding setter
     * and getter methods, I am just giving default access specifier.
     * You can make them private members and add setters and getters.
     */
	private static final long serialVersionUID = 1L; 
    public String regNo;
    public String mileage;
    public String newVar;
    
    /* 
     * A public no-arg constructor 
     */
    public Automobile() {
    	System.out.println("Default Automobile constructor");
    }

    public Automobile(String rn, String m) {
	regNo = rn;
	mileage = m;
    }

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(regNo);
		out.writeObject(mileage);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		regNo = (String)in.readObject();
		mileage = (String)in.readObject();
	}
}
