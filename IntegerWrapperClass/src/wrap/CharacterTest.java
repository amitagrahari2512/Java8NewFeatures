package wrap;

public class CharacterTest {
	public static void main(String[] args) {
		Character i = new Character('a');
		Character j = new Character('a');
		
		System.out.println("i == j : " + (i==j) );
		System.out.println("i.equals(j) : " + (i.equals(j)) );
		
		System.out.println("********************************************");
		
		Character k = 'a';
		Character l = new Character('a');
		
		System.out.println("k == l : " + (k==l) );
		System.out.println("k.equals(l) : " + (k.equals(l)) );
		
		System.out.println("********************************************");
		
		Character m = 'a';
		Character n = 'a';
		
		System.out.println("m == n : " + (m==n) );
		System.out.println("m.equals(n) : " + (m.equals(n)) );
		
		System.out.println("********************************************");
		
		Character o = '\u00e9';
		Character p = '\u00e9';
		
		System.out.println("o value in numeric : "+ (int)o);
		System.out.println("o == p : " + (o==p) );
		System.out.println("o.equals(p) : " + (o.equals(p)) );
		
		
	}
}
