package wrap;

public class ByteTest {
	public static void main(String[] args) {
		byte val = 10;
		Byte i = new Byte(val);
		Byte j = new Byte(val);
		
		System.out.println("i == j : " + (i==j) );
		System.out.println("i.equals(j) : " + (i.equals(j)) );
		
		System.out.println("********************************************");
		
		Byte k = 10;
		Byte l = new Byte(val);
		
		System.out.println("k == l : " + (k==l) );
		System.out.println("k.equals(l) : " + (k.equals(l)) );
		
		System.out.println("********************************************");
		
		Byte m = 10;
		Byte n = 10;
		
		System.out.println("m == n : " + (m==n) );
		System.out.println("m.equals(n) : " + (m.equals(n)) );
		
		System.out.println("********************************************");
		
		Byte o = 127;
		Byte p = 127;
		
		System.out.println("o == p : " + (o==p) );
		System.out.println("o.equals(p) : " + (o.equals(p)) );
		
		
	}
}
