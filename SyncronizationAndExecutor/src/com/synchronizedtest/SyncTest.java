package com.synchronizedtest;

import java.time.LocalDateTime;

public class SyncTest {
	
	
	public static void main(String[] args) {
		SyncThread t1 = new SyncThread();
		SyncThread t2 = new SyncThread();
		SyncThread t3 = new SyncThread();
		Thread th1 = new Thread(t1);
		//Thread th2 = new Thread(t1);
		//Thread th3 = new Thread(t1);
		th1.start();
		//th2.start();
		//th3.start();
		
	}
	
	
	
}

class SyncThread implements Runnable {

	@Override
	public void run() {
		MethodDefine m = new MethodDefine();
		m.methodSyncTestViaThis();
		m.methodSyncTestViaThis();
		m.methodSyncTestViaClass();
	}
	
	
}

class MethodDefine {
	public void methodSyncTestViaThis() {
		System.out.println("methodSyncTestViaThis : " +this.toString());
		synchronized (this) {
			System.out.println("synchronized block called by : "+ this.toString() + " time" + LocalDateTime.now());
			
			 try { 
				 Thread.sleep(5000); 
				 } 
			 catch (InterruptedException e) { 
				 e.printStackTrace();
			 }
			 
		}
	}
	
	public void methodSyncTestViaClass() {
		System.out.println("methodSyncTestViaClass" + this.toString());
		synchronized (MethodDefine.class) {
			System.out.println("synchronized block called by : "+ this.toString() + " time" + LocalDateTime.now());
			
			 try { 
				 Thread.sleep(5000); 
				 } 
			 catch (InterruptedException e) { 
				 e.printStackTrace();
			 }
			 
		}
	}
}


