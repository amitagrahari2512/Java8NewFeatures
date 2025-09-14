package com.fork_and_join_RecursiveTask;

import java.util.concurrent.ForkJoinPool;

//Demonstrate parallel execution.
public class RecursiveTaskWithOutPool {
	public static void main(String args[]) {
		
		double[] nums = new double[5000];
		// Initialize nums with values that alternate between
		// positive and negative.
		for (int i = 0; i < nums.length; i++)
			nums[i] = (double) (((i % 2) == 0) ? i : -i);
		Sum task = new Sum(nums, 0, nums.length);
		// Start the ForkJoinTasks. Notice that, in this case,
		// invoke() returns a result.
		double summation = task.invoke();
		System.out.println("Summation " + summation);
	}
}
