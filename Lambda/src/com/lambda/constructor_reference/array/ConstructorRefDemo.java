package com.lambda.constructor_reference.array;

public class ConstructorRefDemo {
	public static void main(String args[]) {
		MyArrayCreator<MyClass[]> mcArrayCons = MyClass[]::new;
		
		/**
		    Here, the call to func(2) causes a two-element array to be created. In general, a functional
			interface must contain a method that takes a single int parameter if it is to be used to refer
			to an array constructor.
		 */
		MyClass[] a = mcArrayCons.func(2);
		a[0] = new MyClass(1);
		a[1] = new MyClass(2);
		
		System.out.println("a[0] val " + a[0].getVal());
		System.out.println("a[1] val " + a[1].getVal());
		
	}
}
