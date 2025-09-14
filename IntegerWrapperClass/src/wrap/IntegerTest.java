package wrap;

public class IntegerTest {
	public static void main(String[] args) {
		Integer i = new Integer(10);
		Integer j = new Integer(10);
		
		System.out.println("i == j : " + (i==j) );
		System.out.println("i.equals(j) : " + (i.equals(j)) );
		
		System.out.println("********************************************");
		
		Integer k = 10;
		Integer l = new Integer(10);
		
		System.out.println("k == l : " + (k==l) );
		System.out.println("k.equals(l) : " + (k.equals(l)) );
		
		System.out.println("********************************************");
		
		Integer m = 10;
		Integer n = 10;
		
		System.out.println("m == n : " + (m==n) );
		System.out.println("m.equals(n) : " + (m.equals(n)) );
		
		System.out.println("********************************************");
		
		Integer o = 128;
		Integer p = 128;
		
		System.out.println("o == p : " + (o==p) );
		System.out.println("o.equals(p) : " + (o.equals(p)) );
		
		
	}
}
