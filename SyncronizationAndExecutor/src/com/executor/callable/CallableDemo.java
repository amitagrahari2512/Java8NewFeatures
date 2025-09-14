package com.executor.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 The following program illustrates Callable and Future by creating three tasks that
perform three different computations. The first returns the summation of a value, the
second computes the length of the hypotenuse of a right triangle given the length of its
sides, and the third computes the factorial of a value. All three computations occur
simultaneously.
 */

public class CallableDemo {
	public static void main(String args[]) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		Future<Integer> f;
		Future<Double> f2;
		Future<Integer> f3;
		
		System.out.println("Starting");
		
		f = es.submit(new Sum(10));
		f2 = es.submit(new Hypot(3, 4));
		f3 = es.submit(new Factorial(5));
		try {
			System.out.println("Sum Result : " + f.get());
			System.out.println("Hypot Result : " + f2.get());
			System.out.println("Factorial Result : " + f3.get());
		} catch (InterruptedException exc) {
			System.out.println(exc);
		} catch (ExecutionException exc) {
			System.out.println(exc);
		}
		es.shutdown();
		System.out.println("Done");
	}
}

// Following are three computational threads.
class Sum implements Callable<Integer> {
	int stop;

	Sum(int v) {
		stop = v;
	}

	public Integer call() {
		int sum = 0;
		for (int i = 1; i <= stop; i++) {
			sum += i;
		}
		return sum;
	}
}

class Hypot implements Callable<Double> {
	double side1, side2;

	Hypot(double s1, double s2) {
		side1 = s1;
		side2 = s2;
	}

	public Double call() {
		return Math.sqrt((side1 * side1) + (side2 * side2));
	}
}

class Factorial implements Callable<Integer> {
	int stop;

	Factorial(int v) {
		stop = v;
	}

	public Integer call() {
			int fact = 1;
			for(int i = 2; i <= stop; i++) {
			fact *= i;
			}
			return fact;
	}
}
