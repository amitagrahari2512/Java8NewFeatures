package com.CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class BarDemoMultipleThread {
	public static void main(String args[]) {
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
		System.out.println("Starting");
		new MyThread(cb, "A");
		new MyThread(cb, "B");
		new MyThread(cb, "C");
		new MyThread(cb, "X");
		new MyThread(cb, "Y");
		new MyThread(cb, "Z");
	}
}