package com.stream.parallelStream.reduce;

import java.util.ArrayList;
import java.util.Optional;

/*
	For Parallel Stream 
 	<U> U reduce(U identityVal, BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)
	
 */

public class StreamDemoParallelReduce {
	public static void main(String[] args) {
		// Create a list of Double values.
		ArrayList<Double> myList = new ArrayList<>();
		myList.add(4.0);
		myList.add(9.0);
		myList.add(16.0);
		myList.add(25.0);
		myList.add(36.0);
		myList.add(49.0);
		
		double parallelProduct = myList.parallelStream().reduce(1.0, (a,b) -> a*b,
				(a,b) -> a*b);
		
		System.out.println("ParallelProduct : " + parallelProduct);
		
		double productOfSqrRoots = myList.parallelStream().reduce(
				1.0,
				(a,b) ->{ System.out.println("First : " + a + "::" + b ); return a * Math.sqrt(b); },
				(a,b) -> { System.out.println("Second  : " + a + "::" + b ); return a * b; }
				);
		System.out.println("Product of square roots: " + productOfSqrRoots);
		
		/*
			In general, a stream can be switched between parallel and sequential on an as-needed basis.
			There is one other aspect of a stream to keep in mind when using parallel execution:
			the order of the elements. Streams can be either ordered or unordered. In general, if the
			data source is ordered, then the stream will also be ordered. However, when using a parallel
			stream, a performance boost can sometimes be obtained by allowing a stream to be
			unordered. When a parallel stream is unordered, each partition of the stream can be operated
			on independently, without having to coordinate with the others. In cases in which the order
			of the operations does not matter, it is possible to specify unordered behavior by calling the
			unordered( ) method, shown here:
			
				S unordered( )
				
			One other point: the forEach( ) method may not preserve the ordering of a parallel stream.
			If you want to perform an operation on each element in a parallel stream while preserving
			the order, consider using forEachOrdered( ). It is used just like forEach( ).
		 */
		
		double productOfSqrRootsUnOrdered = myList.parallelStream().unordered().reduce(
				1.0,
				(a,b) ->{ System.out.println("First : " + a + "::" + b ); return a * Math.sqrt(b); },
				(a,b) -> { System.out.println("Second  : " + a + "::" + b ); return a * b; }
				);
		System.out.println("Product of square roots: " + productOfSqrRootsUnOrdered);
		
		
		/*
		 For example, if you tried to obtain the
		 product of the square roots of the elements by using the following statement, an error would result:
		 
		 In this version of reduce( ), the accumulator and the combiner function are one and the
		 same. This results in an error because when two partial results are combined, their square
		 roots are multiplied together rather than the partial results,
		 */
		double productOfSqrRootsWrong = myList.parallelStream().reduce(
				1.0,
				(a,b) ->{ System.out.println("First : " + a + "::" + b ); return a * Math.sqrt(b); });
		System.out.println("productOfSqrRootsWrong : " + productOfSqrRootsWrong);
		
		
		/*
		   You can switch a parallel stream to sequential by calling the sequential( ) method, which
		   is specified by BaseStream. It is shown here:
		   S sequential( )
		 */
		double productOfSqrRootsSequential = myList.parallelStream().sequential().reduce(
				1.0,
				(a,b) ->{ System.out.println("First : " + a + "::" + b ); return a * Math.sqrt(b); },
				(a,b) -> { System.out.println("Second  : " + a + "::" + b ); return a * b; }
				);
		System.out.println("productOfSqrRootsSequential : " + productOfSqrRootsSequential);
		
		
	}
}
