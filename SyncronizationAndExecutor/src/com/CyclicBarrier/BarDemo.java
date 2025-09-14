package com.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarDemo {
	public static void main(String args[]) {
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
		System.out.println("Starting");
		new MyThread(cb, "A");
		new MyThread(cb, "B");
		new MyThread(cb, "C");
	}
}

// A thread of execution that uses a CyclicBarrier.
class MyThread implements Runnable {
	CyclicBarrier cbar;
	String name;

	MyThread(CyclicBarrier c, String n) {
		cbar = c;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println(name);
		try {
			int awaitData = cbar.await();
			System.out.println("Await Data : " + awaitData);
		} catch (BrokenBarrierException exc) {
			System.out.println(exc);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
	}
}

// An object of this class is called when the
// CyclicBarrier ends.
class BarAction implements Runnable {
	public void run() {
		System.out.println("Barrier Reached!");
	}
}
