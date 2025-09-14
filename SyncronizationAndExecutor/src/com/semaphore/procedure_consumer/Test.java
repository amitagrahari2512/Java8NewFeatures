package com.semaphore.procedure_consumer;

import java.util.concurrent.Semaphore;

public class Test {
public static void main(String[] args) throws InterruptedException {
	System.out.println("If we provide -ve semaphore");
	Semaphore s1 = new Semaphore(-2);
	System.out.println(s1.availablePermits());
	s1.release();
	System.out.println(s1.availablePermits());
	s1.release();
	System.out.println(s1.availablePermits());
	s1.release();
	System.out.println(s1.availablePermits());
	
	System.out.println("If we provide +ve semaphore");
	Semaphore s = new Semaphore(2);
	System.out.println(s.availablePermits());
	s.release();
	System.out.println(s.availablePermits());
	s.release();
	System.out.println(s.availablePermits());
	s.release();
	System.out.println(s.availablePermits());
}
}
