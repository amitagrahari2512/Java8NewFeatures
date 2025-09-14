package com.lambda.constructor_reference_with_generics_return_type;

//A simple, non-generic class.
public class MyClass2 {
	String str;

	// A constructor that takes an argument.
	MyClass2(String s) {
		str = s;
	}

	// The default constructor. This
	// constructor is NOT used by this program.
	MyClass2() {
		str = "";
	}

	// ...
	String getVal() {
		return str;
	};
}