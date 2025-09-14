package com.example.demo.supplyasync;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.demo.database.EmployeeDatabase;
import com.example.demo.dto.Employee;

public class SupplyAsyncDemo {
	
	public List<Employee> getEmployees() throws InterruptedException, ExecutionException {
		
		CompletableFuture<List<Employee>> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread Executed By: " + Thread.currentThread().getName());
			return EmployeeDatabase.fetchEmployees();
		});
		
		return supplyAsyncFuture.get();
	}
	
	public List<Employee> getEmployeesWithCustomExecutor() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		CompletableFuture<List<Employee>> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread Executed by: " + Thread.currentThread().getName());
			return EmployeeDatabase.fetchEmployees();
		}, executor);
		
		return supplyAsyncFuture.get();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SupplyAsyncDemo supplyAsyncDemo = new SupplyAsyncDemo();
		List<Employee> list = supplyAsyncDemo.getEmployees();
		System.out.println(list.size());
		List<Employee> listEmp = supplyAsyncDemo.getEmployeesWithCustomExecutor();
		System.out.println(listEmp.size());
		
	}

}
