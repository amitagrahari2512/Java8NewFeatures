package com.example.demo.exception.exceptionally;

import java.util.concurrent.CompletableFuture;

public class ExceptionallyDemo {
	
	public void exceptionallyDemo(int a) {
		CompletableFuture<Integer> f= CompletableFuture.supplyAsync(() -> {
			if(a<=10) {
				return a;
			}
			else {
				throw new RuntimeException("No is greater than 10");
			}
		}).exceptionally((ex) -> {
				System.out.println("Error : " + ex.getMessage());
				return 0;
		});
		
		System.out.println(f.join());
		
	}

	public static void main(String[] args) {
		ExceptionallyDemo exDemo = new ExceptionallyDemo();
		exDemo.exceptionallyDemo(5);
		exDemo.exceptionallyDemo(15);
	}

}
