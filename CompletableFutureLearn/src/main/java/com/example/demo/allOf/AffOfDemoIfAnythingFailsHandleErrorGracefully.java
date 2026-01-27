package com.example.demo.allOf;

import java.util.concurrent.CompletableFuture;

public class AffOfDemoIfAnythingFailsHandleErrorGracefully {

	public static void main(String[] args) {
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "User").exceptionally(ex -> {
			return "User Service Failed";
		});

		CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
			if ("OrderService".length() == 5)
				return "OrderService";

			throw new RuntimeException("Order Service failed");
		}).exceptionally(ex -> {
			return ex.getMessage();
		});

		CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "Payment").exceptionally(ex -> {
			return "Payment Service Failed";
		});

		CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);

		all.join();

		System.out.println(f1.join());
		System.out.println(f2.join());
		System.out.println(f3.join());
	}

}
