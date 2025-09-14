package com.lambda.constructor_reference_with_generics;

//MyFunc is a functional interface whose method returns
//a MyClass reference.
public interface MyFunc<T> {
	MyClass<T> func(T n);
}
