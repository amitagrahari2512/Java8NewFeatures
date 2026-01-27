package prep_2026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorTest {
	public static void main(String[] args) {
		Runnable task = () -> {
			for(int i = 0; i<3 ;i++) {
				System.out.println("Thread Name : = " + Thread.currentThread().getName() + " , i = " + i);
			}
		};
		
		ExecutorService service = Executors.newSingleThreadExecutor();
		for(int i = 0 ; i < 5 ; i++) {
			service.submit(task);
		}
		
		service.shutdown();
	}
}
