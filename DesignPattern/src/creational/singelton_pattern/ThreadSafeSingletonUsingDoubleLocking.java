package creational.singelton_pattern;

public class ThreadSafeSingletonUsingDoubleLocking {
	
	private static ThreadSafeSingletonUsingDoubleLocking instance;
    
    private ThreadSafeSingletonUsingDoubleLocking(){}
    

	public static ThreadSafeSingletonUsingDoubleLocking getInstanceUsingDoubleLocking(){
	    if(instance == null){
	        synchronized (ThreadSafeSingletonUsingDoubleLocking.class) {
	            if(instance == null){
	                instance = new ThreadSafeSingletonUsingDoubleLocking();
	            }
	        }
	    }
	    return instance;
	}
}
