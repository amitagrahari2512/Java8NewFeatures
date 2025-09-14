package com.lambda.constructor_reference_with_generics;

public class ConstructorRefDemo {
	public static void main(String args[]) {
		// Create a reference to the MyClass<T> constructor.
		MyFunc<Integer> myClassCons = MyClass<Integer>::new;
		// Create an instance of MyClass<T> via that constructor reference.
		MyClass<Integer> mc = myClassCons.func(100);
		// Use the instance of MyClass<T> just created.
		System.out.println("Int val in mc is " + mc.getVal( ));
		
		// Create a reference to the MyClass<T> constructor.
		MyFunc<String> myClassConsString = MyClass<String>::new;
		// Create an instance of MyClass<T> via that constructor reference.
		MyClass<String> mcString = myClassConsString.func("Amit");
		// Use the instance of MyClass<T> just created.
		System.out.println("String val in mc is " + mcString.getVal( ));
	}
}
