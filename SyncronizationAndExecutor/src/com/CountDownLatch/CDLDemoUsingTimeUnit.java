package com.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CDLDemoUsingTimeUnit {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(100);
		System.out.println("Starting");
		new MyThread(cdl);
		try {
			boolean timeUnitBool = cdl.await(1 , TimeUnit.NANOSECONDS);
			System.out.println(timeUnitBool);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		System.out.println("Done");
	}
}