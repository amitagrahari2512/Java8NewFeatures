package superclass_not_implement_externalizable;

public class Automobile  {
    
    /*
     * Instead of making thse members private and adding setter
     * and getter methods, I am just giving default access specifier.
     * You can make them private members and add setters and getters.
     */
    public String regNo;
    public String mileage;
    
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
}
