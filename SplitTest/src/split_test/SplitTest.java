package split_test;

public class SplitTest {
	public static void main(String[] args) {
		String name = ":A:BC:D:E:::";
		//String[] nameArr = name.split(":", 0);
		
		System.out.println("**************** with  +ve value = only those +ve value substring display *********");
		String[] nameArr = name.split(":",3);
		int i = 0;
		for(String n : nameArr)
		{
			System.out.println(i + n);
			i++;
		}
		
		System.out.println("**************** with  -ve value = All value display *********");
		nameArr = name.split(":",-1);
		i = 0;
		for(String n : nameArr)
		{
			System.out.println(i + n);
			i++;
		}
		
		System.out.println("**************** with  0 = REmove trailing empty *********");
		nameArr = name.split(":",0);
		i = 0;
		for(String n : nameArr)
		{
			System.out.println(i + n);
			i++;
		}
	}
}
