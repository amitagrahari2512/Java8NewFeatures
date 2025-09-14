package com.stream.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 The one we will use first is shown here:
 
		<R, A> R collect(Collector<? super T, A, R> collectorFunc)
		
Here, R specifies the type of the result, and T specifies the element type of the invoking
stream. The internal accumulated type is specified by A. The collectorFunc specifies how the
collection process works. The collect( ) method is a terminal operation.
The Collector interface is declared in java.util.stream, as shown here:

		interface Collector<T, A, R>
		
T, A, and R have the same meanings as just described. Collector specifies several methods,
but for the purposes of this chapter, we won’t need to implement them. Instead, we will use
two of the predefined collectors that are provided by the Collectors class, which is packaged
in java.util.stream.

The Collectors class defines a number of static collector methods that you can use as-is.
The two we will use are toList( ) and toSet( ), shown here:

		static <T> Collector<T, ?, List<T>> toList( )
		static <T> Collector<T, ?, Set<T>> toSet( )
		
The toList( ) method returns a collector that can be used to collect elements into a List. The
toSet( ) method returns a collector that can be used to collect elements into a Set
	
 */

public class StreamDemoCollectToListToSet {
	public static void main(String[] args) {
		// A list of names, phone numbers, and e-mail addresses.
		ArrayList<NamePhoneEmail> myList = new ArrayList<>( );
		myList.add(new NamePhoneEmail("Larry", "555-5555","Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444","James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Mary", "555-3333","Mary@HerbSchildt.com"));
		
		// Map just the names and phone numbers to a new stream.
		Stream<NamePhone> nameAndPhone = myList.stream().map(
		(a) -> new NamePhone(a.name,a.phonenum)
		);
		// Use collect to create a List of the names and phone numbers.
		List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());
		
		System.out.println("Names and phone numbers in a List:");
		
		for(NamePhone e : npList)
			System.out.println(e.name + ": " + e.phonenum);
		
		System.out.println();
		
		// Obtain another mapping of the names and phone numbers.
		nameAndPhone = myList.stream().map(
		(a) -> new NamePhone(a.name,a.phonenum)
		);
		// Now, create a Set by use of collect().
		Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());
		
		System.out.println("\nNames and phone numbers in a Set:");
		for(NamePhone e : npSet)
			System.out.println(e.name + ": " + e.phonenum);
	}
}
