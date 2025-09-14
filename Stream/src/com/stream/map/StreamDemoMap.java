package com.stream.map;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
 	<R> Stream<R> map(Function<? super T, ? extends R> mapFunc)
	
 */

public class StreamDemoMap {
	public static void main(String[] args) {
		// Create a list of Double values.
		ArrayList<Double> myList = new ArrayList<>();
		myList.add(4.0);
		myList.add(9.0);
		myList.add(16.0);
		myList.add(25.0);
		myList.add(36.0);
		myList.add(49.0);
		
		/*
		 	The following is a simple example of map( ). It provides a variation on the previous
			example program. As before, the program computes the product of the square roots of the
			values in an ArrayList. In this version, however, the square roots of the elements are first
			mapped to a new stream. Then, reduce( ) is employed to compute the product.
		 */
		
		// Map the square root of the elements in myList to a new stream.
		Stream<Double> sqrtRootStrm = myList.stream().map((a) -> Math.sqrt(a));
		
		// Find the product of the square roots.
		double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a,b) -> a*b);
		System.out.println("Product of square roots is " + productOfSqrRoots);
	}
}
