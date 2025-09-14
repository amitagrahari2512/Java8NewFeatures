package com.lambda.instance_method_reference_different_obj_super;

//A class that stores the temperature high for a day.
public class HighTemp extends Temp{
	private int hTemp;

	public HighTemp(int ht) {
		super(ht);
		hTemp = ht;
	}

	// Return true if the invoking HighTemp object has the same
	// temperature as ht2.
	boolean sameTemp(HighTemp ht2) {
		System.out.println("High Temp class sameTemp()");
		return hTemp == ht2.hTemp;
	}

	// Return true if the invoking HighTemp object has a temperature
	// that is less than ht2.
	boolean lessThanTemp(HighTemp ht2) {
		System.out.println("High Temp class lessThanTemp()");
		return hTemp < ht2.hTemp;
	}
}
