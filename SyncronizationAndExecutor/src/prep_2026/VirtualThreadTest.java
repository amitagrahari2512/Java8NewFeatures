package prep_2026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreadTest {
	public static void main(String[] args) throws InterruptedException {
		DbCall db = new DbCall();
		ApiCall api = new ApiCall();
		try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
			for(int i = 0 ; i < 1000 ;i++) {
				int requestedId = i;
				executor.submit(() -> { 
					db.DbCall(requestedId);
					api.ApiCall(requestedId);
				});
			}
			executor.shutdown();
			executor.awaitTermination(1, TimeUnit.HOURS);
		}
	}
}

class DbCall {
	
	public void DbCall(int i) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DB Call " + i);
	}
}

class ApiCall {
	
	public void ApiCall(int i) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("API Call " + i );
	}
}