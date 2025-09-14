package wrap;

public class LongTest {
	public static void main(String[] args) {
		Long i = new Long(10);
		Long j = new Long(10);
		
		System.out.println("i == j : " + (i==j) );
		System.out.println("i.equals(j) : " + (i.equals(j)) );
		
		System.out.println("********************************************");
		
		long val = 10;
		Long k = val;
		Long l = new Long(10);
		
		System.out.println("k == l : " + (k==l) );
		System.out.println("k.equals(l) : " + (k.equals(l)) );
		
		System.out.println("********************************************");
		
		Long m = val;
		Long n = val;
		
		System.out.println("m == n : " + (m==n) );
		System.out.println("m.equals(n) : " + (m.equals(n)) );
		
		System.out.println("********************************************");
		
		long val1 = 128;
		Long o = val1;
		Long p = val1;
		
		System.out.println("o == p : " + (o==p) );
		System.out.println("o.equals(p) : " + (o.equals(p)) );
		
		
	}
}
