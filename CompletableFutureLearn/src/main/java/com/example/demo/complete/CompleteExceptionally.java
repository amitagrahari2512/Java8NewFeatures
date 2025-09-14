package com.example.demo.complete;

import java.util.concurrent.CompletableFuture;

public class CompleteExceptionally {
	
	public void completeExceptionallyTest() {
		CompletableFuture<String> future = new CompletableFuture<>();
		
		new Thread(() -> {
			try {
				Thread.sleep(3000);
				throw new RuntimeException("Process taken Time ");
			}
			catch(Exception e) {
				future.completeExceptionally(e);
			}
		}).start();
		
		try {
			System.out.println(future.join());
		}
		catch(Exception e) {
			System.out.println("Error Caught :: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		CompleteExceptionally ce = new CompleteExceptionally();
		ce.completeExceptionallyTest();
	}

}
