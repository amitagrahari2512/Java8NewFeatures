package prep_2026;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		return 10;
	}
}

public class CallableTest {
	public static void main(String[] args) {
		CallableThread c = new CallableThread();
		
		FutureTask<Integer> f = new FutureTask<>(c);
		
		Thread t = new Thread(f);
		
		t.start();
		
		try {
			Integer i = f.get();
			System.out.println(i);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}


