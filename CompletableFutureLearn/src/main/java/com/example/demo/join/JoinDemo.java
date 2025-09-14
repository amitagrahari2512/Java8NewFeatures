package com.example.demo.join;

import java.util.concurrent.CompletableFuture;

public class JoinDemo {

	public void joinDemoExample() {
		CompletableFuture<String> f = CompletableFuture.supplyAsync(() -> "Join Example");
		System.out.println(f.join());
	}
	
	public void joinDemoExampleHavingError() {
		CompletableFuture<String> f = CompletableFuture.supplyAsync(() ->  { 
			throw new RuntimeException("Error"); 
		});
		
		try {
			f.join();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		JoinDemo j = new JoinDemo();
		j.joinDemoExample();
		j.joinDemoExampleHavingError();
		
	}
}
