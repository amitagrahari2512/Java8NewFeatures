package com.stream.map;

import java.util.ArrayList;
import java.util.stream.IntStream;

/*

	<R> Stream<R> map(Function<? super T, ? extends R> mapFunc)

	In addition to the version just described, three other versions of map( ) are provided.
	They return a primitive stream, as shown here:
	
			IntStream mapToInt(ToIntFunction<? super T> mapFunc)
			LongStream mapToLong(ToLongFunction<? super T> mapFunc)
			DoubleStream mapToDouble(ToDoubleFunction<? super T> mapFunc)
			
	Each mapFunc must implement the abstract method defined by the specified interface,
	returning a value of the indicated type. For example, ToDoubleFunction specifies the
	applyAsDouble(T val ) method, which must return the value of its parameter as a double.
	Here is an example that uses a primitive stream. It first creates an ArrayList of Double
	values. It then uses stream( ) followed by mapToInt( ) to create an IntStream that contains
	the ceiling of each value.
	
 */

/*
 
	Before leaving the topic of mapping, it is necessary to point out that the stream API
	also provides methods that support flat maps. These are flatMap( ), flatMapToInt( ),
	flatMapToLong( ), and flatMapToDouble( ). The flat map methods are designed to handle
	situations in which each element in the original stream is mapped to more than one
	element in the resulting stream.

 */

public class StreamDemoMapWithPrimitiveObject {
	public static void main(String[] args) {
		// A list of double values.
		ArrayList<Double> myList = new ArrayList<>();
		myList.add(1.1);
		myList.add(3.6);
		myList.add(9.2);
		myList.add(4.7);
		myList.add(12.1);
		myList.add(5.0);

		System.out.print("Original values in myList: ");
		myList.stream().forEach((a) -> {
			System.out.print(a + " ");
		});
		System.out.println();
		// Map the ceiling of the elements in myList to an IntStream.
		IntStream cStrm = myList.stream().mapToInt((a) -> (int) Math.ceil(a));
		System.out.print("The ceilings of the values in myList: ");
		cStrm.forEach((a) -> {
			System.out.print(a + " ");
		});
		
		System.out.println();
		
		IntStream fStrm = myList.stream().mapToInt((a) -> (int) Math.floor(a));
		System.out.print("The Floor of the values in myList: ");
		fStrm.forEach((a) -> {
			System.out.print(a + " ");
		});
	}
}
