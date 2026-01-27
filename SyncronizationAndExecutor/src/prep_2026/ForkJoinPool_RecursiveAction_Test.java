package prep_2026;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// Multiply each element of a large array by 2.
public class ForkJoinPool_RecursiveAction_Test {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(new MultiplyTask(arr, 0, arr.length));
		System.out.println(Arrays.toString(arr));
	}
}

class MultiplyTask extends RecursiveAction {
	
	private static final int THRESHOLD = 5;
	int[] arr;
	int start;
	int end;
	
	public MultiplyTask(int[] arr, int start, int end) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		if(end - start <= THRESHOLD) {
			for(int i = start ;i < end; i++) {
				arr[i] = 2 * arr[i];
			}
		}
		else {
			int mid = (end - start)/2;
			MultiplyTask left = new MultiplyTask(arr, start, mid);
			MultiplyTask right = new MultiplyTask(arr, mid, end);
			left.fork(); //First Fork Left Task
			right.compute(); // Main Thread compute right side data
			left.join(); // Fork Task  compute.
		}
	}
}