package com.example.demo.allOf;

import java.util.concurrent.CompletableFuture;

public class AffOfDemoIfAnythingFails {

	public static void main(String[] args) {
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "User");
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
			throw new RuntimeException("Order Service failed");
		});
		CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "Payment");
		
		CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
		
		try {
			all.join();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		System.out.println(f1.join());
		System.out.println(f2.join());
		System.out.println(f3.join());

	}

}
