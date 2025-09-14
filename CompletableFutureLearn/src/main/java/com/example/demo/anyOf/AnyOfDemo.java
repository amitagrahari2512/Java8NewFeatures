package com.example.demo.anyOf;

import java.util.concurrent.CompletableFuture;

public class AnyOfDemo {
	
	public void anyOf() {
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Fast result";
		});
		
		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Slow result";
		});
		
		CompletableFuture<Object> fast = CompletableFuture.anyOf(f1, f2);
		System.out.println(fast.join());
		
	}
	
	public static void main(String[] args) {
		AnyOfDemo any = new AnyOfDemo();
		any.anyOf();
	}

}
