package prep_2026;

import java.util.concurrent.CyclicBarrier;

/*
 * 
 * 
Scenario 

Imagine an online exam platform: 

Exam has 3 sections: 

Aptitude 

Coding 

English 

Each section is evaluated by a different service / thread 

Final result must be generated only after ALL sections are evaluated 

This is a perfect CyclicBarrier use case. 
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new ResultAggregator());
		new Thread(new SelectionEvaluator("Aptitude", barrier)).start();
		new Thread(new SelectionEvaluator("English", barrier)).start();
		new Thread(new SelectionEvaluator("Math", barrier)).start();
	}
}

class ResultAggregator implements Runnable {

	@Override
	public void run() {
		System.out.println("All sections evaluated. Generating final result...");
	}
}

class SelectionEvaluator implements Runnable {

	private final String sectionName;
	private final CyclicBarrier barrier;
	
	public SelectionEvaluator(String sectionName, CyclicBarrier barrier) {
		this.sectionName = sectionName;
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(sectionName + " evaluation started");
			Thread.sleep((int)(Math.random() * 3000));//simulate Work
			System.out.println(sectionName + " evaluation completed");
			
			barrier.await(); //Wait for others
			
			System.out.println(sectionName + " proceeding after barrier");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
