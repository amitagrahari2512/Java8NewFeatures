package com.stream;

/*Before going any further, let’s work through an example that uses streams. The following
program creates an ArrayList called myList that holds a collection of integers (which are
automatically boxed into the Integer reference type). Next, it obtains a stream that uses
myList as a source. It then demonstrates various stream operations.
*/

// Demonstrate several stream operations.
import java.util.*;
import java.util.stream.*;

public class StreamDemo {
	public static void main(String[] args) {
		// Create a list of Integer values.
		ArrayList<Integer> myList = new ArrayList<>();
		myList.add(7);
		myList.add(18);
		myList.add(10);
		myList.add(24);
		myList.add(17);
		myList.add(5);
		System.out.println("Original list: " + myList);
		// Obtain a Stream to the array list.
		Stream<Integer> myStream = myList.stream();

		// Obtain the minimum and maximum value by use of min(),
		// max(), isPresent(), and get().
		Optional<Integer> minVal = myStream.min(Integer::compare);
		if (minVal.isPresent())
			System.out.println("Minimum value: " + minVal.get());

		// Must obtain a new stream because previous call to min()
		// is a terminal operation that consumed the stream.
		myStream = myList.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare);
		if (maxVal.isPresent())
			System.out.println("Maximum value: " + maxVal.get());

		// Sort the stream by use of sorted().
		Stream<Integer> sortedStream = myList.stream().sorted();
		// Display the sorted stream by use of forEach().
		System.out.print("Sorted stream: ");
		sortedStream.forEach((n) -> System.out.print(n + " "));
		System.out.println();

		// Display only the odd values by use of filter().
		Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
		System.out.print("Odd values: ");
		oddVals.forEach((n) -> System.out.print(n + " "));
		System.out.println();

		// Display only the odd values that are greater than 5. Notice that
		// two filter operations are pipelined.
		oddVals = myList.stream().filter((n) -> (n % 2) == 1).filter((n) -> n > 5);
		System.out.print("Odd values greater than 5: ");
		oddVals.forEach((n) -> System.out.print(n + " "));
		System.out.println();
	}
}
/*1

  Let’s look closely at each stream operation. After creating an ArrayList, the program
  obtains a stream for the list by calling stream( ), as shown here:
		Stream<Integer> myStream = myList.stream();
  As explained, the Collection interface now defines the stream( ) method, which obtains a
  stream from the invoking collection. Because Collection is implemented by every collection
  class, stream( ) can be used to obtain stream for any type of collection, including the
  ArrayList used here. In this case, a reference to the stream is assigned to myStream.
  
*/

/*2
 
	Next, the program obtains the minimum value in the stream (which is, of course, also
	the minimum value in the data source) and displays it, as shown here:
	
		Optional<Integer> minVal = myStream.min(Integer::compare);
		if(minVal.isPresent()) System.out.println("Minimum value: " + minVal.get());
		
	Recall from Table 29-2 that min( ) is declared like this:
	
		Optional<T> min(Comparator<? super T> comp)

	First, notice that the type of min( )’s parameter is a Comparator. This comparator is used to
	compare two elements in the stream. In the example, min( ) is passed a method reference
	to Integer’s compare( ) method, which is used to implement a Comparator capable of
	comparing two Integers. Next, notice that the return type of min( ) is Optional. The Optional
	class is described in Chapter 19, but briefly, here is how it works. Optional is a generic class
	packaged in java.util and declared like this:
	
		class Optional<T>
		
	Here, T specifies the element type. An Optional instance can either contain a value of type
	T or be empty. You can use isPresent( ) to determine if a value is present. Assuming that a
	value is available, it can be obtained by calling get( ). In this example, the object returned
	will hold the minimum value of the stream as an Integer object.
	One other point about the preceding line: min( ) is a terminal operation that consumes
	the stream. Thus, myStream cannot be used again after min( ) executes.
	The next lines obtain and display the maximum value in the stream:
	
		myStream = myList.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare);
		if(maxVal.isPresent()) System.out.println("Maximum value: " + maxVal.get());

	First, myStream is once again assigned the stream returned by myList.stream( ). As just
	explained, this is necessary because the previous call to min( ) consumed the previous
	stream. Thus, a new one is needed. Next, the max( ) method is called to obtain the
	maximum value. Like min( ), max( ) returns an Optional object. Its value is obtained by
	calling get( ).
	
*/ 

/*3
	
	The program then obtains a sorted stream through the use of this line:
	
		Stream<Integer> sortedStream = myList.stream().sorted();
		
	Here, the sorted( ) method is called on the stream returned by myList.stream( ). Because
	sorted( ) is an intermediate operation, its result is a new stream, and this is the stream assigned
	to sortedStream. The contents of the sorted stream are displayed by use of forEach( ):
	
		sortedStream.forEach((n) -> System.out.print(n + " "));
		
*/

/*4

	Here, the forEach( ) method executes an operation on each element in the stream. In this
	case, it simply calls System.out.print( ) for each element in sortedStream. This is accomplished
	by use of a lambda expression. The forEach( ) method has this general form:
	
		void forEach(Consumer<? super T> action)
		
	Consumer is a generic functional interface declared in java.util.function. Its abstract
	method is accept( ), shown here:
	
		void accept(T objRef)
		
	The lambda expression in the call to forEach( ) provides the implementation of accept( ).
	The forEach( ) method is a terminal operation. Thus, after it completes, the stream has
	been consumed.
	
	If you use again this stream you will get exception either stream is closed or already used.
*/

/*5

	Next, a sorted stream is filtered by filter( ) so that it contains only odd values:
	
		Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
	
	The filter( ) method filters a stream based on a predicate. It returns a new stream that
	contains only those elements that satisfy the predicate. It is shown here:
	
		Stream<T> filter(Predicate<? super T> pred)

	Predicate is a generic functional interface defined in java.util.function. Its abstract method
	is test( ), which is shown here:
	
		boolean test(T objRef)
		
	It returns true if the object referred to by objRef satisfies the predicate, and false otherwise.
	The lambda expression passed to filter( ) implements this method. Because filter( ) is an
	intermediate operation, it returns a new stream that contains filtered values, which, in this
	case, are the odd numbers. These elements are then displayed via forEach( ) as before.
	
	Because filter( ), or any other intermediate operation, returns a new stream, it is possible
	to filter a filtered stream a second time. This is demonstrated by the following line, which
	produces a stream that contains only those odd values greater than 5:
	
		oddVals = myList.stream().filter((n) -> (n % 2) == 1)
								 .filter((n) -> n > 5);
								 
	Notice that lambda expressions are passed to both filters.
	
*/
