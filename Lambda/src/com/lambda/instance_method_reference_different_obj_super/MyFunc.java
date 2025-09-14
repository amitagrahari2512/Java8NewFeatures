package com.lambda.instance_method_reference_different_obj_super;

/**
 * 
 ClassName::instanceMethodName'
 
Here, the name of the class is used instead of a specific object, even though an instance
method is specified. With this form, the first parameter of the functional interface matches
the invoking object and the second parameter matches the parameter specified by the
method. Here is an example. It defines a method called counter( ) that counts the number
of objects in an array that satisfy the condition defined by the func( ) method of the MyFunc
functional interface. In this case, it counts instances of the HighTemp class.

One other point: you can refer to the superclass version of a method by use of super, as
shown here:
super::name
The name of the method is specified by name.

 */
//Use an instance method reference with different objects.
//A functional interface that takes two reference arguments
//and returns a boolean result.
interface MyFunc<T> {
boolean func(T v1, T v2);
}