package prep_2026.que_ans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue {

	public static void main(String[] args) {
		int capacity = 10;
		BlockingQueue b = new BlockingQueue(capacity);
		new Thread(() -> {
			for(int i = 0 ; i < 100 ; i++) {
				try {
					b.put(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(() -> {
				try {
					while(true) {
						System.out.println("Take Obj " + b.take());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}).start();
	}
}

class BlockingQueue {
	
	List<Integer> queue = new ArrayList<>();
	ReentrantLock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();
	int capacity;
	
	public BlockingQueue(int capacity) {
		this.capacity = capacity;
	}
	
	void put(int item) throws InterruptedException {
		try {
			lock.lock();
			while(queue.size() == capacity) {
				notFull.await();
			}
			queue.add(item);
			notEmpty.signal();
		}
		finally {
			lock.unlock();
		}
	}
	
    int take() throws InterruptedException {
    	try {
    		lock.lock();
        	while(queue.isEmpty()) {
        		notEmpty.await();
        	}
        	int val = queue.remove(0);
        	notFull.signal();
        	return val;
    	}
    	finally {
    		lock.unlock();
    	}
    	
    }
}
