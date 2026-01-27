package prep_2026;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
 * Problem: Sum of an array using Fork–Join
 */

public class ForkJoinPool_RecursiveTask_Test {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		ForkJoinPool pool = new ForkJoinPool();
		int result = pool.invoke(new SumTask(arr, 0, arr.length));
		System.out.println("Sum Result : " + result);
	}
}

class SumTask extends RecursiveTask<Integer> {
	
	private static final int THRESHOLD = 5;
	private int[] arr;
	private int start;
	private int end;
	
	public SumTask(int[] arr, int start, int end) {
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		
		if(end - start <= THRESHOLD) {
			int sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
		}
		
		int mid = (start + end)/2;
		
		SumTask left = new SumTask(arr, start , mid);
		SumTask right = new SumTask(arr, start , mid);
		
		left.fork(); //First Fork Left Task
		int rightResult = right.compute(); // Main Thread compute right side data
		int leftResult = left.join(); // Fork Task  compute and provide result.
		
		return leftResult + rightResult;
	}
}
