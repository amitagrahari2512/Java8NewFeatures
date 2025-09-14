package com.example.demo.exception.exceptionally;

import java.util.concurrent.CompletableFuture;

public class ExceptionallyChainedDemo {
	
	public void exceptionallyDemo(int a) {
		CompletableFuture.supplyAsync(() -> {
			if(a<=10) {
				return a;
			}
			else {
				throw new RuntimeException("No is greater than 10");
			}
		}).exceptionally((ex) -> {
				System.out.println("Error : " + ex.getMessage());
				return 0;
		}).thenAccept(result -> {
            System.out.println("Chained Result: " + result);
        });
		
	}

	public static void main(String[] args) {
		ExceptionallyChainedDemo exDemo = new ExceptionallyChainedDemo();
		exDemo.exceptionallyDemo(5);
		exDemo.exceptionallyDemo(15);
	}

}
