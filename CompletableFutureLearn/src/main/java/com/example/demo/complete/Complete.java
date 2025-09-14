package com.example.demo.complete;

import java.util.concurrent.CompletableFuture;

public class Complete {
	
	public void complete() {
		CompletableFuture<String> future = new CompletableFuture<>();
		
		new Thread(() -> {
			try {
				Thread.sleep(3000);
				future.complete("Task done");
			}
			catch(Exception e) {
				future.complete("Task done");
			}
		}).start();
		
		System.out.println(future.join());
	}
	
	public static void main(String[] args) {
		Complete c = new Complete();
		c.complete();
	}

}
