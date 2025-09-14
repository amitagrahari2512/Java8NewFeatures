package com.example.demo.thenapply_thenAccept_thenRun;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import com.example.demo.database.EmployeeDatabase;
import com.example.demo.dto.Employee;

/**
 * This is a small project which we create for learning CompletableFuture.
 * Check details on file CompleatableFuture_EmployeeReminder_Design.jpg.
 * 
 */
public class EmployeeReminderService {
	
	public CompletableFuture<Void> sendReminderToEmployee() {
		CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Fetch Employee : " + Thread.currentThread().getName());
			return EmployeeDatabase.fetchEmployees();
		}).thenApply((employees) -> {
			System.out.println("Filter new joiner Employee : " + Thread.currentThread().getName());
			return employees.stream()
					.filter(e -> "TRUE".equals(e.getNewJoiner()))
					.collect(Collectors.toList());
		}).thenApply((employees) -> {
			System.out.println("Filter Training Not Completed Employee : " + Thread.currentThread().getName());
			return employees.stream()
					.filter(e -> "TRUE".equals(e.getLearningPending()))
					.collect(Collectors.toList());
		}).thenApply((employees) -> {
			System.out.println("Get Email List: " + Thread.currentThread().getName());
			return employees.stream().map(Employee::getEmail).collect(Collectors.toList());
		}).thenAccept((emails) -> {
			System.out.println("Send Email : " + Thread.currentThread().getName());
			emails.forEach(EmployeeReminderService :: sendEmail);
		});
		
		return voidCompletableFuture;
	}
	
	public static void sendEmail(String emailId) {
		System.out.println("Send Learning Reminder email to " + emailId);
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		EmployeeReminderService service = new EmployeeReminderService();
		//service.sendReminderToEmployee().get();
		service.sendReminderToEmployee().join();
	}
}
