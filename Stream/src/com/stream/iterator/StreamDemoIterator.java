package com.stream.iterator;

/*

NOTE JDK 8 adds additional iterator types that handle the primitive streams: PrimitiveIterator,
PrimitiveIterator.OfDouble, PrimitiveIterator.OfLong, and PrimitiveIterator.OfInt. These iterators all
extend the Iterator interface and work in the same general way as those based directly on Iterator.
To obtain an iterator to a stream, call iterator( ) on the stream. The version used by Stream is shown here.

		Iterator<T> iterator( )
		
		
Here, T specifies the element type. (The primitive streams return iterators of the appropriate primitive type.)

The following program shows how to iterate through the elements of a stream. In this
case, the strings in an ArrayList are iterated, but the process is the same for any type of stream.

*/

import java.util.*;
import java.util.stream.*;

public class StreamDemoIterator {
	public static void main(String[] args) {
		// Create a list of Strings.
		ArrayList<String> myList = new ArrayList<>( );
		myList.add("Alpha");
		myList.add("Beta");
		myList.add("Gamma");
		myList.add("Delta");
		myList.add("Phi");
		myList.add("Omega");
		// Obtain a Stream to the array list.
		Stream<String> myStream = myList.stream();
		// Obtain an iterator to the stream.
		Iterator<String> itr = myStream.iterator();
		// Iterate the elements in the stream.
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}
