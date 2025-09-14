package com.example.demo.anyOf;

import java.util.concurrent.CompletableFuture;

public class AnyOfDemoWithMultipleObj {
	
	public void anyOfWithMultipleObj() {
		CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Fast result";
		});
		
		CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 1000;
		});
		
		CompletableFuture<Object> fast = CompletableFuture.anyOf(f1, f2);
		Object returnVal = fast.join();
		
		if(returnVal instanceof Integer) {
			System.out.println("Integer Obj :: " + returnVal);
		}
		else if (returnVal instanceof String) {
			System.out.println("String Obj :: " + returnVal);
		}
		
	}
	
	public static void main(String[] args) {
		AnyOfDemoWithMultipleObj any = new AnyOfDemoWithMultipleObj();
		any.anyOfWithMultipleObj();
	}
	
}
