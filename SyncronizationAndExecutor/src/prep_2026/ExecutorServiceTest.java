package prep_2026;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
	public static void main(String[] args) {
		ExecutorService s = Executors.newFixedThreadPool(2);
		s.submit(()-> System.out.println("Executor Service Test"));
		s.submit(()-> System.out.println("Executor Service Test"));
	}
}	
