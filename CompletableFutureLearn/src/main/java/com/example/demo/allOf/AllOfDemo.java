package com.example.demo.allOf;

import java.util.concurrent.CompletableFuture;

public class AllOfDemo {
	
	public void allOf() {
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "User");
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Order");
		CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "Payment");
		
		CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
		
		all.join();
		
		System.out.println(f1.join());
		System.out.println(f2.join());
		System.out.println(f3.join());
		
		
	}
	
	public static void main(String[] args) {
		AllOfDemo all = new AllOfDemo();
		all.allOf();
	}
}
