package prep_2026;

import java.util.concurrent.CountDownLatch;

/*
 * 
Problem statement 

Before your Spring Boot / Java application starts accepting traffic: 

DB connection must be ready 

Kafka must be connected 

Cache (Redis/Ehcache) must be initialized 

Only when all services are UP, the app should start. 
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(3);
		new Thread(new ServiceInitialize("Database", latch)).start();
		new Thread(new ServiceInitialize("Kafka", latch)).start();
		new Thread(new ServiceInitialize("Cache", latch)).start();
		
		System.out.println("Main Thread Waiting for services ....");
		latch.await();//Blocks Here
		System.out.println("All services are up ....");
	}
}

class ServiceInitialize implements Runnable {
	
	private final String serviceName;
	private final CountDownLatch latch;
	
	public ServiceInitialize(String serviceName, CountDownLatch latch) {
		this.serviceName = serviceName;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			System.out.println(serviceName + " initialization started.");
			Thread.sleep(2000);
			System.out.println(serviceName + " initialization successfully.");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		finally {
			latch.countDown();
		}
	}
}
