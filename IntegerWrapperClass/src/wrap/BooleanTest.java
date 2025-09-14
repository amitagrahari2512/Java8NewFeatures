package wrap;

public class BooleanTest {
	public static void main(String[] args) {
		Boolean i = new Boolean(true);
		Boolean j = new Boolean(true);
		
		System.out.println("i == j : " + (i==j) );
		System.out.println("i.equals(j) : " + (i.equals(j)) );
		
		System.out.println("********************************************");
		
		Boolean k = true;
		Boolean l = new Boolean(true);
		
		System.out.println("k == l : " + (k==l) );
		System.out.println("k.equals(l) : " + (k.equals(l)) );
		
		System.out.println("********************************************");
		
		Boolean m = true;
		Boolean n = true;
		
		System.out.println("m == n : " + (m==n) );
		System.out.println("m.equals(n) : " + (m.equals(n)) );
		
		System.out.println("********************************************");
		
		Boolean o = true;
		Boolean p = true;
		
		System.out.println("o == p : " + (o==p) );
		System.out.println("o.equals(p) : " + (o.equals(p)) );
		
		
	}
}
