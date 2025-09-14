package com.example.demo.exception.handle;

import java.util.concurrent.CompletableFuture;

public class HandleDemo {
	public void handleDemo(int a) {
		CompletableFuture.supplyAsync(() -> {
			if(a<=10) {
				return a;
			}
			else {
				throw new RuntimeException("No is greater than 10");
			}
		}).handle((result, ex) -> {
			if(ex != null) {
				System.out.println("Error : " + ex.getMessage());
				return 0;
			}
			else {
				return result;
			}
				
		}).thenAccept(result -> {
            System.out.println("Result: " + result);
        });
		
	}

	public static void main(String[] args) {
		HandleDemo handle = new HandleDemo();
		handle.handleDemo(5);
		handle.handleDemo(15);
	}
}
