package com.example.demo.exception.whencomplete;

import java.util.concurrent.CompletableFuture;

public class WhenCompleteDemo {
	public void whenComplete(int a) {
		CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> {
			if(a<=10) {
				return a;
			}
			else {
				throw new RuntimeException("No is greater than 10");
			}
		}).whenComplete((result, ex) -> {
			if(ex != null) {
				System.out.println("Error : " + ex.getMessage());
			}
			else {
				System.out.println("No is : "+ result);
			}
		});
		
		f.join();
	}
	
	public static void main(String[] args) {
		WhenCompleteDemo when = new WhenCompleteDemo();
		when.whenComplete(5);
		when.whenComplete(15);
	}
}
