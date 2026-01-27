package prep_2026.que_ans;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class PrintABCWithCyclicBarrier {
	
	static Semaphore aSem = new Semaphore(1);
	static Semaphore bSem = new Semaphore(0);
	static Semaphore cSem = new Semaphore(0);
	static CyclicBarrier barrier = new CyclicBarrier(3);
	
	public static void main(String[] args) {
		new Thread(new PrintABCBarrier("A", aSem, bSem, barrier)).start();
		new Thread(new PrintABCBarrier("B", bSem, cSem, barrier)).start();
		new Thread(new PrintABCBarrier("C", cSem, aSem, barrier)).start();
	}
}

class PrintABCBarrier implements Runnable {
	private static final int TIMES = 10;
	String val;
	Semaphore curr;
	Semaphore next;
	CyclicBarrier barrier;
	
	public PrintABCBarrier(String val, Semaphore curr, Semaphore next, CyclicBarrier barrier) {
		this.val = val;
		this.curr = curr;
		this.next = next;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			for(int i = 0 ; i < TIMES; i++) {
				curr.acquire();
				System.out.print(val);
				next.release();
				barrier.await();
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
}