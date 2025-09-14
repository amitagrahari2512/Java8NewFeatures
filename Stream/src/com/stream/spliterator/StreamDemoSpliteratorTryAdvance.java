package com.stream.spliterator;

/*

Spliterator offers an alternative to Iterator, especially when parallel processing is involved.
In general, Spliterator is more sophisticated than Iterator, and a discussion of Spliterator is
found in Chapter 18. However, it will be useful to review its key features here. Spliterator
defines several methods, but we only need to use three. The first is tryAdvance( ). It performs
an action on the next element and then advances the iterator. It is shown here:

		boolean tryAdvance(Consumer<? super T> action)

Here, action specifies the action that is executed on the next element in the iteration.
tryAdvance( ) returns true if there is a next element. It returns false if no elements remain.
As discussed earlier in this chapter, Consumer declares one method called accept( ) that
receives an element of type T as an argument and returns void.

Because tryAdvance( ) returns false when there are no more elements to process, it
makes the iteration loop construct very simple, for example:

		while(splitItr.tryAdvance( // perform action here );

As long as tryAdvance( ) returns true, the action is applied to the next element. When
tryAdvance( ) returns false, the iteration is complete. Notice how tryAdvance( ) consolidates
the purposes of hasNext( ) and next( ) provided by Iterator into a single method. This
improves the efficiency of the iteration process.

*/

import java.util.*;
import java.util.stream.*;

public class StreamDemoSpliteratorTryAdvance {
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
		// Obtain a Spliterator.
		Spliterator<String> splitItr = myStream.spliterator();
		
		//splitItr.forEachRemaining((n) -> System.out.println(n));
		
		// Iterate the elements of the stream.
		while(splitItr.tryAdvance((n) -> System.out.println(n)));
		
		System.out.println("After tryAdvance : ");
		/*
			In some cases, you might want to perform some action on each element collectively,
			rather than one at a time. To handle this type of situation, Spliterator provides the
			forEachRemaining( ) method, shown here:
			
				default void forEachRemaining(Consumer<? super T> action)
			
			This method applies action to each unprocessed element and then returns. For example,
			assuming the preceding program, the following displays the strings remaining in the stream:
		*/
		//Here no output for this line , because all element processed earlier with tryAdvance method.
		//If we use this method earlier to tryAdvance so it will show a value.
		splitItr.forEachRemaining((n) -> System.out.println(n));
		/*
			Notice how this method eliminates the need to provide a loop to cycle through the
			elements one at a time. This is another advantage of Spliterator.
		*/
	}
}
