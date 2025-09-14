package divideAndMod;

//Mod always depends on Numerator.
//Divide depends on both Numerator and Denominator.
//Output of this program:
/*negativeNumerator Divide:-3 , Mod:-1
negativeDenominator Divide:-3 , Mod:1
negativeNumeratAndDenominator- Divide:3 , Mod:-1*/
public class DivideAndMod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		negativeNumerator();
		negativeDenominator();
		negativeNumeratorDenominator();
	}
	
	public static void negativeNumerator()
	{
		int a = -10;
		int b = 3;
		int divide = a/b;
		int mod = a%b;
		System.out.println("negativeNumerator Divide:"+divide+" , Mod:"+ mod );
	}
	
	public static void negativeDenominator()
	{
		int a = 10;
		int b = -3;
		int divide = a/b;
		int mod = a%b;
		System.out.println("negativeDenominator Divide:"+divide+" , Mod:"+ mod );
	}
	

	public static void negativeNumeratorDenominator()
	{
		int a = -10;
		int b = -3;
		int divide = a/b;
		int mod = a%b;
		System.out.println("negativeNumeratorDenominator- Divide:"+divide+" , Mod:"+ mod );
	}

}
