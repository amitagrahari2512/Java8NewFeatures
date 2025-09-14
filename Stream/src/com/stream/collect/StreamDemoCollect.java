package com.stream.collect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Stream;

/*

The version of collect( ) used by the previous example is quite convenient, and often
the one you want, but there is a second version that gives you more control over the
collection process. It is shown here:

	<R> R collect(Supplier<R> target, BiConsumer<R, ? super T> accumulator,BiConsumer <R, R> combiner)
	
Here, target specifies how the object that holds the result is created. For example, to use a
LinkedList as the result collection, you would specify its constructor. The accumulator
function adds an element to the result and combiner combines two partial results. Thus,
these functions work similarly to the way they do in reduce( ). For both, they must be
stateless and non-interfering. They must also be associative.

Note that the target parameter is of type Supplier. It is a functional interface declared in
java.util.function. It specifies only the get( ) method, which has no parameters and, in this
case, returns an object of type R. Thus, as it relates to collect( ), get( ) returns a reference to
a mutable storage object, such as a collection.

Note also that the types of accumulator and combiner are BiConsumer. This is a functional
interface defined in java.util.function. It specifies the abstract method accept( ) that is
shown here:

		void accept(T obj, U obj2)

This method performs some type of operation on obj and obj2. As it relates to accumulator,
obj specifies the target collection, and obj2 specifies the element to add to that collection. As
it relates to combiner, obj and obj2 specify two collections that will be combined.


::::Imp Point ::::
One last point: In the language of the stream API, the collect( ) method performs what
is called a mutable reduction. This is because the result of the reduction is a mutable (i.e.,
changeable) storage object, such as a collection
	
 */

class NamePhoneEmail {
	String name;
	String phonenum;
	String email;

	NamePhoneEmail(String n, String p, String e) {
		name = n;
		phonenum = p;
		email = e;
	}
}

class NamePhone {
	String name;
	String phonenum;

	NamePhone(String n, String p) {
		name = n;
		phonenum = p;
	}
}

public class StreamDemoCollect {
	public static void main(String[] args) {
		// A list of names, phone numbers, and e-mail addresses.
		ArrayList<NamePhoneEmail> myList = new ArrayList<>( );
		myList.add(new NamePhoneEmail("Larry", "555-5555","Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444","James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Mary", "555-3333","Mary@HerbSchildt.com"));
		
		System.out.println("Original values in myList: ");
		
		myList.stream().forEach( (a) -> {
			System.out.println(a.name + " " + a.phonenum + " " + a.email);
		});
		System.out.println();
		// Map just the names and phone numbers to a new stream.
		Stream<NamePhone> nameAndPhone = myList.stream().map(
			(a) -> new NamePhone(a.name,a.phonenum)
		);
		
		/*Using the version of collect( ) just described, you could use a LinkedList as the target in
		the preceding program, as shown here:
		*/
		LinkedList<NamePhone> npList = nameAndPhone.collect(
				() -> new LinkedList<>(),
				(list, element) -> list.add(element),
				(listA,listB ) -> listA.addAll(listB));
		
		/*
		    Notice that the first argument to collect( ) is a lambda expression that returns a new
			LinkedList. The second argument uses the standard collection method add( ) to add an
			element to the list. The third element uses addAll( ) to combine two linked lists. As a point
			of interest, you can use any method defined by LinkedList to add an element to the list. For
			example, you could use addFirst( ) to add elements to the start of the list, as shown here:
			
			(list, element) -> list.addFirst(element)
		 */
		
		System.out.println("Names and phone numbers in a LinkedList:");
		
		for(NamePhone e : npList)
			System.out.println(e.name + ": " + e.phonenum);
		
		System.out.println();
		
		//Again get Stream
		nameAndPhone = myList.stream().map(
				(a) -> new NamePhone(a.name,a.phonenum)
			);
		
		
		/*
		As you may have guessed, it is not always necessary to specify a lambda expression for
		the arguments to collect( ). Often, method and/or constructor references will suffice. For
		example, again assuming the preceding program, this statement creates a HashSet that
		contains all of the elements in the nameAndPhone stream:
		*/
		HashSet<NamePhone> npSet = nameAndPhone.collect(
				HashSet::new,
				HashSet::add,
				HashSet::addAll);
		
		/*
		Notice that the first argument specifies the HashSet constructor reference. The second and
		third specify method references to HashSet’s add( ) and addAll( ) methods.
		*/
		
		System.out.println("Names and phone numbers in a HashSet:");
		
		for(NamePhone e : npSet)
			System.out.println(e.name + ": " + e.phonenum);
		
		System.out.println();
	}
}
