package prep_2026.que_ans;

import java.util.ArrayList;
import java.util.List;

public class ImplementSimpleThreadPool {

	public static void main(String[] args) {
		SimpleThreadPool simplePool = new SimpleThreadPool(5);
		for(int i = 0 ; i < 100 ; i++) {
			int requestedId = i;
			simplePool.submit(() -> System.out.println("Runnable" + requestedId));
		}
		simplePool.shutdown();
	}
}

class SimpleThreadPool {
	List<Runnable> list = new ArrayList<>();
	int poolSize;
	private volatile boolean isShutdown = false;
	
	public SimpleThreadPool(int poolSize) {
		this.poolSize = poolSize;
		for(int i = 0 ; i < poolSize; i++) {
			Thread thread = new Thread(new WorkerThread(), "Worker Thread " + i);
			thread.start();
		}
	}	
	public synchronized void submit(Runnable r) {
		if(isShutdown)
			throw new IllegalStateException("Thread pool is shutting down.");
		list.add(r);
		notify();
	}
	
	public synchronized Runnable get() {
		while(list.isEmpty()) {
			if(isShutdown)
			{
				return null; // signal worker to exit
			}
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		return list.remove(0);
	}
	
	public synchronized void shutdown() {
	    isShutdown = true;
	    notifyAll(); // wake all waiting workers
	}
	
	class WorkerThread implements Runnable{

		@Override
		public void run() {
			while(true) {
				Runnable task = get();
				
				if(task == null) {
					break; // shutdown + empty queue
				}
				
				try {
					System.out.print(Thread.currentThread().getName() + " run Task :: ");
					task.run();
				}
				catch(Exception e) {
					Thread.currentThread().interrupt();
				}
					
			}
		}
		
	}
}
