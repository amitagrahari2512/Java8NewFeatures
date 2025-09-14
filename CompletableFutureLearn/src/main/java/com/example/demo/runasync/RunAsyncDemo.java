package com.example.demo.runasync;

import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.demo.dto.Employee;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RunAsyncDemo {
	
	public Void saveEmployee(File jsonFile) throws InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper();
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
			try {
				List<Employee> list = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {});
				System.out.println("Thread : " + Thread.currentThread().getName());
				System.out.println(list.size());
				//list.stream().forEach(System.out::println);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		});
		return runAsyncFuture.get();
	}
	
	public Void saveEmployeeWithCustomExecutor(File jsonFile) throws InterruptedException, ExecutionException {
		ObjectMapper mapper = new ObjectMapper();
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
			try {
				List<Employee> list = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {});
				System.out.println("Thread : " + Thread.currentThread().getName());
				System.out.println(list.size());
				//list.stream().forEach(System.out::println);
			}  catch (Exception e) {
				e.printStackTrace();
			}
		}, executor);
		return runAsyncFuture.get();
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		RunAsyncDemo runAsyncDemo = new RunAsyncDemo();
		runAsyncDemo.saveEmployee(new File("employees.json"));
		runAsyncDemo.saveEmployeeWithCustomExecutor(new File("employees.json"));
	}

}
