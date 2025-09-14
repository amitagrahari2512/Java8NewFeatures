package creational.singelton_pattern;


//he drawback is that the enum type is somewhat inflexible; 
//for example, it does not allow lazy initialization.
public enum EnumSingleton {

	    INSTANCE;
	    
	    public static void doSomething(){
	        //do something
	    }
}
