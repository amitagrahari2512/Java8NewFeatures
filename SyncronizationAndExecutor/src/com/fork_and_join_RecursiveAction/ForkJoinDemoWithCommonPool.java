package com.fork_and_join_RecursiveAction;

import java.util.concurrent.ForkJoinPool;

/**
 * At this point, a simple example that demonstrates the Fork/Join Framework and
 * the divideand- conquer strategy will be helpful. Following is a program that
 * transforms the elements in an array of double into their square roots. It
 * does so via a subclass of RecursiveAction.Its not crate any pool,it run directly because SqrtTransform extends RecursiveAction.
 * And it furture extend ForkJoinTask , so simply it is a task.
 */
// Demonstrate parallel execution.
public class ForkJoinDemoWithCommonPool {
	public static void main(String args[]) {
		// Create a task pool.
		ForkJoinPool pool = ForkJoinPool.commonPool();
		double[] nums = new double[100000];
		// Give nums some values.
		for (int i = 0; i < nums.length; i++)
			nums[i] = (double) i;
		System.out.println("A portion of the original sequence:");
		for (int i = 0; i < 10; i++)
			System.out.print(nums[i] + " ");
		System.out.println("\n");
		SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
		// Start the main ForkJoinTask.
		pool.invoke(task);
		System.out.println("A portion of the transformed sequence" + " (to four decimal places):");
		for (int i = 0; i < 10; i++)
			System.out.format("%.4f ", nums[i]);
		System.out.println();
	}
}