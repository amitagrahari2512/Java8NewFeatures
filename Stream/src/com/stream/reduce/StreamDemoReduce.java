package com.stream.reduce;

import java.util.ArrayList;
import java.util.Optional;

/*
 	Optional<T> reduce(BinaryOperator<T> accumulator)
 	
	T reduce(T identityVal, BinaryOperator<T> accumulator)
	
 */

public class StreamDemoReduce {
	public static void main(String[] args) {
		// Create a list of Integer values.
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(7);
		myList.add(18);
		myList.add(10);
		myList.add(24);
		myList.add(17);
		myList.add(5);
		// Two ways to obtain the integer product of the elements
		// in myList by use of reduce().
		Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);
		if (productObj.isPresent())
			System.out.println("Product as Optional: " + productObj.get());
		
		int product = myList.stream().reduce(1, (a, b) -> a * b);
		System.out.println("Product as int: " + product);
		
		/*
		 Pay special attention to the lambda expression. If b is even, then a * b is returned. 
		 Otherwise, a is returned. This works because a holds the current result 
		 and b holds the next element,as explained earlier.
		 */
		
		//Even Product
		int evenProduct = myList.stream().reduce(1, (a,b) -> {
			if(b%2 == 0) 
				return a*b; 
			else 
				return a;
			});
		System.out.println("Even Product as int: " + evenProduct);
	}
}