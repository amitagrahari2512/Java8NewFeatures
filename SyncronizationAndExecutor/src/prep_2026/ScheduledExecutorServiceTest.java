package prep_2026;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {
	public static void main(String[] args) {
		ScheduledExecutorServiceTest s = new ScheduledExecutorServiceTest();
		s.scheduleAtFixedRate();
		s.scheduleWithFixedDelay();
	}
	
	
	public void scheduleAtFixedRate() {
		ScheduledExecutorService schedule = Executors.newScheduledThreadPool(2);
		schedule.scheduleAtFixedRate(
				() -> System.out.println(
						"Thread Name " + Thread.currentThread().getName() + " Schedule Task - scheduleAtFixedRate"),
				0, 5, TimeUnit.SECONDS);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		schedule.shutdown();
	}
	
	public void scheduleWithFixedDelay() {
		ScheduledExecutorService schedule = Executors.newScheduledThreadPool(2);
		schedule.scheduleWithFixedDelay(
				() -> System.out.println(
						"Thread Name " + Thread.currentThread().getName() + " Schedule Task - scheduleWithFixedDelay"),
				0, 5, TimeUnit.SECONDS);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		schedule.shutdown();
	}
}
