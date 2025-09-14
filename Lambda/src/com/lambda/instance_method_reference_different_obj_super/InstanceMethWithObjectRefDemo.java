package com.lambda.instance_method_reference_different_obj_super;



public class InstanceMethWithObjectRefDemo {
	// A method that returns the number of occurrences
	// of an object for which some criteria, as specified by
	// the MyFunc parameter, is true.
	static <T> int counter(T[] vals, MyFunc<T> f, T v) {
		int count = 0;
		for (int i = 0; i < vals.length; i++)
			if (f.func(vals[i], v))
				count++;
		return count;
	}
	
	public void getData(){
		int count;
		// Create an array of HighTemp objects.
		HighTemp[] weekDayHighs = { new HighTemp(89), new HighTemp(82), new HighTemp(90), new HighTemp(89),
				new HighTemp(89), new HighTemp(91), new HighTemp(84), new HighTemp(83) };
		// Use counter() with arrays of the class HighTemp.
		
		//SuperClass::methodName,superClass Object
		count = counter(weekDayHighs, Temp::sameTemp, new Temp(89));
		System.out.println(count + " days had a high of 89");
		
		//SuperClass::methodName,subClass Object
		count = counter(weekDayHighs, Temp::sameTemp, new HighTemp(89));
		System.out.println(count + " days had a high of 89");
		
		//SubClass::methodName,subClass Object
		count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(89));
		System.out.println(count + " days had a high of 89");
		
	}

	public static void main(String args[]) {
		InstanceMethWithObjectRefDemo n = new InstanceMethWithObjectRefDemo();
		n.getData();
	}
}