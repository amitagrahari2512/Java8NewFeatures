package com.executor.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 The following program illustrates Callable and Future by creating three tasks that
perform three different computations. The first returns the summation of a value, the
second computes the length of the hypotenuse of a right triangle given the length of its
sides, and the third computes the factorial of a value. All three computations occur
simultaneously.
 */

public class CallableDemoUsingTimeUnit {
	public static void main(String args[]) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		Future<Integer> f;
		Future<Double> f2;
		Future<Integer> f3;
		
		System.out.println("Starting");
		
		f = es.submit(new Sum(10));
		f2 = es.submit(new Hypot(3, 4));
		f3 = es.submit(new Factorial(20));
		try {
			System.out.println("Sum Result : " + f.get(1 , TimeUnit.NANOSECONDS));
			System.out.println("Hypot Result : " + f2.get(1 , TimeUnit.NANOSECONDS));
			System.out.println("Factorial Result : " + f3.get(1 , TimeUnit.NANOSECONDS));
		} catch (InterruptedException exc) {
			System.out.println(exc);
		} catch (ExecutionException exc) {
			System.out.println(exc);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdown();
		System.out.println("Done");
	}
}
