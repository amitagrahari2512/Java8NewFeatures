package com.example.demo.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompleteOnTimeout {
	
	public void completeOnTimeOut() {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
			try {
				Thread.sleep(5000);
			}
			catch(Exception e) {
				
			}
			return "Finished";
		});
		
		future.completeOnTimeout("default value", 2, TimeUnit.SECONDS);
		
		System.out.println(future.join());
		
	}
	
	public static void main(String[] args) {
		CompleteOnTimeout cot = new CompleteOnTimeout();
		cot.completeOnTimeOut();
	}
}
