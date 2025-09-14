package com.lambda.constructor_reference;

public class ConstructorRefDemoForZeroParameter {
	public static void main(String args[]) {
		// Create a reference to the MyClass constructor.
		// Because func() in MyFunc takes an argument, new
		// refers to the parameterized constructor in MyClass,
		// not the default constructor.
		MyFuncZeroParameter myClassCons = MyClass::new;
		// Create an instance of MyClass via that constructor reference.
		MyClass mc = myClassCons.func();
		// Use the instance of MyClass just created.
		System.out.println("val in mc is " + mc.getVal());
	}
}
