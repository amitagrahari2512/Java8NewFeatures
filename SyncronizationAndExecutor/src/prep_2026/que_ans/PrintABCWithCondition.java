package prep_2026.que_ans;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABCWithCondition {
	
	static ReentrantLock lock = new ReentrantLock();
	static Condition aCon = lock.newCondition();
	static Condition bCon = lock.newCondition();
	static Condition cCon = lock.newCondition();

	public static void main(String[] args) {
		new Thread(new PrinterABCCondition("A", 0, aCon, bCon, lock)).start();
		new Thread(new PrinterABCCondition("B", 1, bCon, cCon, lock)).start();
		new Thread(new PrinterABCCondition("C", 2, cCon, aCon, lock)).start();
	}
}

class PrinterABCCondition implements Runnable {
	private static int state = 0;  //0=A, 1=B, 2=C
	private static final int TIMES = 10;
	String val;
	int myState;
	Condition myCon;
	Condition nextCon;
	ReentrantLock lock;
	
	public PrinterABCCondition(String val,int myState, Condition myCon, Condition nextCon, ReentrantLock lock) {
		super();
		this.val = val;
		this.myState = myState;
		this.myCon = myCon;
		this.nextCon = nextCon;
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			lock.lock();
			for(int i = 0 ; i < TIMES ; i++) {
				while(state != myState) {
					myCon.await();
				}
				System.out.print(val);
				state = (state + 1) % 3;
				nextCon.signal();
			}
		}
		catch(Exception e) {
			Thread.currentThread().interrupt();
		}
	}
}