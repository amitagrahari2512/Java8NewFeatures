package pak;

import java.util.logging.Level;
import java.util.logging.Logger;

public class String {
	public String(){
		System.out.println("User Defined");
	}
	
	public static void main(java.lang.String[] args) {
		try {          
            //printing ClassLoader of this class
            System.out.println("ClassLoaderTest.getClass().getClassLoader() : "
                                 + java.lang.String.class.getClassLoader());

          
            //trying to explicitly load this class again using Extension class loader
            Class.forName("test.String", true 
                            ,  String.class.getClassLoader().getParent());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(String.class.getName()).log(Level.SEVERE, null, ex);
        }

	}
}
