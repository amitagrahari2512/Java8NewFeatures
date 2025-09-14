package com.example.demo.thencombine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenCombineDemo {
	
	public void simpleCombinationThenCombine() {
		CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(() -> "First Future");
		CompletableFuture<String> secondFuture = CompletableFuture.supplyAsync(() -> "Second Future");
		
		CompletableFuture<String> combineFuture = firstFuture.thenCombine(secondFuture, (f,s) -> f + "," + s);
		System.out.println(combineFuture.join());
		
	}
	public void numericCombinationThenCombine() {
		CompletableFuture<Integer> firstFuture = CompletableFuture.supplyAsync(() -> 1);
		CompletableFuture<Integer> secondFuture = CompletableFuture.supplyAsync(() -> 2);
		
		CompletableFuture<Integer> combineFuture = firstFuture.thenCombine(secondFuture, (f,s) -> f + s);
		System.out.println(combineFuture.join());
		
	}
	
	public void numericCombinationThenCombineAsync() {
		CompletableFuture<Integer> firstFuture = CompletableFuture.supplyAsync(() -> 1);
		CompletableFuture<Integer> secondFuture = CompletableFuture.supplyAsync(() -> 2);
		
		CompletableFuture<Integer> combineFuture = firstFuture.thenCombineAsync(secondFuture, (f,s) -> {
			System.out.println("Thread : "+ Thread.currentThread().getName());
			return f + s;
			});
		System.out.println(combineFuture.join());
		
	}
	
	public void numericCombinationThenCombineAsyncExecutor() {
		ExecutorService exe = Executors.newFixedThreadPool(5);
		CompletableFuture<Integer> firstFuture = CompletableFuture.supplyAsync(() -> 1);
		CompletableFuture<Integer> secondFuture = CompletableFuture.supplyAsync(() -> 2);
		
		CompletableFuture<Integer> combineFuture = firstFuture.thenCombineAsync(secondFuture, (f,s) -> {
			System.out.println("Thread : "+ Thread.currentThread().getName());
			return f + s;
			}, exe);
		System.out.println(combineFuture.join());
		
	}
	
	public static void main(String[] args) {
		ThenCombineDemo then = new ThenCombineDemo();
		then.simpleCombinationThenCombine();
		then.numericCombinationThenCombine();
		then.numericCombinationThenCombineAsync();
		then.numericCombinationThenCombineAsyncExecutor();
	}
}
