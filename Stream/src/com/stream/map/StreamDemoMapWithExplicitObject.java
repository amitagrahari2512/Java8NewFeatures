package com.stream.map;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
 * 
 * <R> Stream<R> map(Function<? super T, ? extends R> mapFunc)
 * 
Here is an example that uses map( ) to create a new stream that contains only selected
fields from the original stream. In this case, the original stream contains objects of type
NamePhoneEmail, which contains names, phone numbers, and e-mail addresses. The
program then maps only the names and phone numbers to a new stream of NamePhone
objects. The e-mail addresses are discarded.
	
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

public class StreamDemoMapWithExplicitObject {
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
		
		System.out.println("List of names and phone numbers: ");
		nameAndPhone.forEach( (a) -> {
			System.out.println(a.name + " " + a.phonenum);
		});
		System.out.println();
		
		/*
			Because you can pipeline more than one intermediate operation together, you can
			easily create very powerful actions. For example, the following statement uses filter( ) and
			then map( ) to produce a new stream that contains only the name and phone number of
			the elements with the name "James":
		*/
		
		Stream<NamePhone> nameAndPhoneOnlyJames = myList.stream().filter((a) -> a.name.equals("James")).
						map((a) -> new NamePhone(a.name,a.phonenum));
		
		System.out.println("******* James PhoneNumbers ***********");
		nameAndPhoneOnlyJames.forEach( (a) -> {
			System.out.println(a.name + " " + a.phonenum);
		});
	}
}
