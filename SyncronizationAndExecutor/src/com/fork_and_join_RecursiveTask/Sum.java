package com.fork_and_join_RecursiveTask;

/**
 * 
The two preceding examples are based on RecursiveAction, which means that they
concurrently execute tasks that do not return results. To create a task that returns a result,
use RecursiveTask. In general, solutions are designed in the same manner as just shown.
The key difference is that the compute( ) method returns a result. Thus, you must aggregate
the results, so that when the first invocation finishes, it returns the overall result. Another
difference is that you will typically start a subtask by calling fork( ) and join( ) explicitly
(rather than implicitly by calling invokeAll( ), for example).
The following program demonstrates RecursiveTask. It creates a task called Sum that
returns the summation of the values in an array of double. In this example, the array
consists of 5,000 elements. However, every other value is negative. Thus, the first values
in the array are 0, –1, 2, –3, 4, and so on. (So that this example will work with both JDK 7
and JDK 8, it creates its own pool. You might try changing it to use the common pool as an
exercise.)
*/
// A simple example that uses RecursiveTask<V>.
import java.util.concurrent.*;

// A RecursiveTask that computes the summation of an array of doubles.
public class Sum extends RecursiveTask<Double> {
	// The sequential threshold value.
	final int seqThresHold = 500;
	// Array to be accessed.
	double[] data;
	// Determines what part of data to process.
	int start, end;

	Sum(double[] vals, int s, int e) {
		data = vals;
		start = s;
		end = e;
	}

	// Find the summation of an array of doubles.
	protected Double compute() {
		double sum = 0;
		// If number of elements is below the sequential threshold,
		// then process sequentially.
		if ((end - start) < seqThresHold) {
			// Sum the elements.
			for (int i = start; i < end; i++)
				sum += data[i];
		} else {
			// Otherwise, continue to break the data into smaller pieces.
			// Find the midpoint.
			int middle = (start + end) / 2;
			// Invoke new tasks, using the subdivided data.
			Sum subTaskA = new Sum(data, start, middle);
			Sum subTaskB = new Sum(data, middle, end);
			
			/*
			 	There are a couple of interesting items in this program. First, notice that the two
				subtasks are executed by calling fork( ), as shown here:
				
				subTaskA.fork();
				subTaskB.fork();
				
				In this case, fork( ) is used because it starts a task but does not wait for it to finish. (Thus,
				it asynchronously runs the task.) The result of each task is obtained by calling join( ), as
				shown here:
				
				sum = subTaskA.join() + subTaskB.join();
				
				This statement waits until each task ends. It then adds the results of each and assigns the
				total to sum. Thus, the summation of each subtask is added to the running total. Finally,
				compute( ) ends by returning sum, which will be the final total when the first invocation
				returns. 
				
			 */
			// Start each subtask by forking.
			subTaskA.fork();
			subTaskB.fork();
			// Wait for the subtasks to return, and aggregate the results.
			sum = subTaskA.join() + subTaskB.join();
			
			/* Other Alternative
			 * There are other ways to approach the handling of the asynchronous execution of the
				subtasks. For example, the following sequence uses fork( ) to start subTaskA and uses
				invoke( ) to start and wait for subTaskB:
				subTaskA.fork();
				sum = subTaskB.invoke() + subTaskA.join();
			 * 
			 */
			
			//subTaskA.fork();
			//sum = subTaskB.invoke() + subTaskA.join();
			
			/*
			 *  Another alternative is to have subTaskB call compute( ) directly, as shown here:
				subTaskA.fork();
				sum = subTaskB.compute() + subTaskA.join();
			 */
			
			//subTaskA.fork();
			//sum = subTaskB.compute() + subTaskA.join();
			
		}
		// Return the final sum.
		return sum;
	}
}
