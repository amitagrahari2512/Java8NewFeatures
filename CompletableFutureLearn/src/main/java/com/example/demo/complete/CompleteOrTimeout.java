package com.example.demo.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompleteOrTimeout {
	
	public void completeOrTimeOut() {
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
			try {
				Thread.sleep(5000);
			}
			catch(Exception e) {
				
			}
			return "Too Late";
		});
		
		future.orTimeout( 2, TimeUnit.SECONDS);
		
		try {
			System.out.println(future.join());
		}
		catch(Exception e) {
			System.out.println("TimeOut : " + e.getMessage());
		}
		
		
	}
	
	public static void main(String[] args) {
		CompleteOrTimeout cot = new CompleteOrTimeout();
		cot.completeOrTimeOut();
	}
}
