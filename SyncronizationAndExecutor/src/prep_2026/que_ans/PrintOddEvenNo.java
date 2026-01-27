package prep_2026.que_ans;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenNo {

	public static void main(String[] args) {
		OddEven e = new OddEven(20);
		new Thread(e::even).start();
		new Thread(e::odd).start();
	}
}

class OddEven {
	
	public int start = 1;
	ReentrantLock lock = new ReentrantLock();
	Condition oddCon = lock.newCondition();
	Condition evenCon = lock.newCondition();
	int max;
	
	public OddEven(int max) {
		this.max = max;
	}
	
	public void even() {
		lock.lock();
		try {
			while(start <= max) {
				while(start % 2 != 0) {
					evenCon.await();
				}
				if(start <= max) {
					System.out.println("Even :" + start);
					start++;
					oddCon.signal();
				}
			}
		}
		catch (Exception e) {
			Thread.currentThread().interrupt();
		}
		finally {
			lock.unlock();
		}
	}
	
	public void odd() {
		lock.lock();
		try {
			while (start <= max) {
				while (start % 2 == 0) {
					oddCon.await();
				}
				if (start <= max) {
					System.out.println("Odd :" + start);
					start++;
					evenCon.signal();
				}
			}
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		} finally {
			lock.unlock();
		}
	}
}
