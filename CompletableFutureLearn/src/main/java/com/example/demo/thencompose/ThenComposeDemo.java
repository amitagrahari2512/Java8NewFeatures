package com.example.demo.thencompose;

import java.util.concurrent.CompletableFuture;

public class ThenComposeDemo {
	//Because that returns nested Future
	public void whyThenApplynotUsed() {
		CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> "Amit");
		CompletableFuture<CompletableFuture<String>> nested = userFuture.thenApply(
				userName -> CompletableFuture.supplyAsync(() -> "Hello " + userName)
		);
		
		System.out.println("whyThenApplynotUsed : " + nested.join().join());
	}
	
	//This flattern the future
	public void thenComposeDemo() {
		CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(() -> "Amit");
		CompletableFuture<String> flatternFuture = userFuture.thenCompose(
				userName -> CompletableFuture.supplyAsync(() -> "Hello " + userName)
		);
		
		System.out.println("thenComposeDemo : " + flatternFuture.join());
	}
	
	public static void main(String[] args) {
		ThenComposeDemo thenCompose = new ThenComposeDemo();
		thenCompose.whyThenApplynotUsed();
		thenCompose.thenComposeDemo();
	}
}
