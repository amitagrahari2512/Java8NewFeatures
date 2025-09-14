package com.example.demo.applyToEither;

import java.util.concurrent.CompletableFuture;

public class ApplyToEitherTest {
	
	public void applyToEitherTest() {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Future 1";
		});
		
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Future 2";
		});
		
		CompletableFuture<String> futureApplyToEither = future1.applyToEither(future2, s -> s);
		System.out.println(futureApplyToEither.join());
	}
	
	public static void main(String[] args) {
		ApplyToEitherTest a = new ApplyToEitherTest();
		a.applyToEitherTest();
	}
}
