package prep_2026;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenteredLock_ProducerConsumer {

	public static void main(String[] args){
		ProducerConsumer pc = new ProducerConsumer();
		new Thread(() -> {
			for(int i = 0 ; i < 10 ;i++) {
				pc.producer(i);
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				pc.consumer();
			}
		}).start();
	}
}

class ProducerConsumer {

	ReentrantLock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();

	List<Integer> list = new ArrayList<>();
	public static final int capacity = 5;

	public void producer(int item) {
			lock.lock();
			try {
				while (list.size() == capacity) {
					notFull.await(); // release lock
				}
				System.out.println("Produce : " + item);
				list.add(item);
				notEmpty.signal(); // Wake up Consumer
			} 
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}		
	}

	public void consumer(){
			lock.lock();
			try {
				while (list.size() == 0) {
					notEmpty.await();// release lock
				}
				int consumeValue = list.remove(0);
				System.out.println("Consume : " + consumeValue);
				notFull.signal();// Wake up Producer
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
	}
}
