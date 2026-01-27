package prep_2026.que_ans;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueueWithTimeOut {

	public static void main(String[] args) {
		int capacity = 1;
		BlockingQueueWithTimeout b = new BlockingQueueWithTimeout(capacity);
		
		new Thread(() -> {
			for(int i = 0 ; i < 100 ; i++) {
				try {
					boolean success = b.put(i, 5 , TimeUnit.SECONDS);
					System.out.println("Put Success : " + success);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	
		
		new Thread(() -> {
				try {
					while(true) {
						System.out.println("Take Obj " + b.take(1 , TimeUnit.SECONDS));
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}).start();
	}
}

class BlockingQueueWithTimeout {
	
	List<Integer> queue = new ArrayList<>();
	ReentrantLock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();
	int capacity;
	
	public BlockingQueueWithTimeout(int capacity) {
		this.capacity = capacity;
	}
	
	boolean put(int item, long time, TimeUnit timeUnit) throws InterruptedException {
		long nano = timeUnit.toNanos(time);
		try {
			lock.lock();
			while(queue.size() == capacity) {
				if(nano <= 0 ) {
					return false; // timeout expired
				}
				notFull.awaitNanos(nano);
			}
			queue.add(item);
			notEmpty.signal();
			return true;
		}
		finally {
			lock.unlock();
		}
	}
	
    Integer take(long time, TimeUnit timeUnit) throws InterruptedException {
    	long nano = timeUnit.toNanos(time);
    	try {
    		lock.lock();
        	while(queue.isEmpty()) {
        		if(nano <= 0) {
        			return null; // timeout expired
        		}
        		notEmpty.awaitNanos(nano);
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
