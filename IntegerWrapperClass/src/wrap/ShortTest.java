package wrap;

public class ShortTest {
	public static void main(String[] args) {
		short val = 10;
		Short i = new Short(val);
		Short j = new Short(val);
		
		System.out.println("i == j : " + (i==j) );
		System.out.println("i.equals(j) : " + (i.equals(j)) );
		
		System.out.println("********************************************");
		
		Short k = 10;
		Short l = new Short(val);
		
		System.out.println("k == l : " + (k==l) );
		System.out.println("k.equals(l) : " + (k.equals(l)) );
		
		System.out.println("********************************************");
		
		Short m = 10;
		Short n = 10;
		
		System.out.println("m == n : " + (m==n) );
		System.out.println("m.equals(n) : " + (m.equals(n)) );
		
		System.out.println("********************************************");
		
		Short o = 128;
		Short p = 128;
		
		System.out.println("o == p : " + (o==p) );
		System.out.println("o.equals(p) : " + (o.equals(p)) );
		
		
	}
}
