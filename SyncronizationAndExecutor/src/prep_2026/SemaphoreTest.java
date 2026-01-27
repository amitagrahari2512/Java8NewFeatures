package prep_2026;

import java.util.concurrent.Semaphore;

/*
 * 
 * 
 * Real-time example: Limiting concurrent access to a resource (DB / API / Printer)
Scenario

Imagine:

Your Java application has 100 threads

But your database connection pool allows only 5 connections

If more than 5 threads hit DB at the same time - performance issue / failure

Semaphore helps you limit concurrent access.
 */

public class SemaphoreTest {
	public static void main(String[] args) {
		DatabaseService service = new DatabaseService();
		for(int i = 0; i < 8 ;i++) {
			new Thread(service::accessDatabse, "Thread- " + i).start();
		}
	}
}

class DatabaseService {
	private final Semaphore semaphore = new Semaphore(5);
	
	public void accessDatabse() {
		try {
			semaphore.acquire(); //Take Permit(Wait if none available)
			System.out.println(Thread.currentThread().getName() + " accquired DB connection");
			
			//Simulate Db connection
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		finally {
			semaphore.release(); //release permits
			System.out.println(Thread.currentThread().getName() + " released DB connection");
		}
	}
}
