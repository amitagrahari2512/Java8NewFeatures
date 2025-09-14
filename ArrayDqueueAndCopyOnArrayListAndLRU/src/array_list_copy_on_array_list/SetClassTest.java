package array_list_copy_on_array_list;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetClassTest {
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		s.add("A");
		s.add("B");
		
		Iterator<String> i = s.iterator();
		while(i.hasNext())
		{
			String c = i.next();
			System.out.println(c);
			if(c.equals("A"))
			{
				s.add("C");
			}
		}
		
		System.out.println(s);
	}
}
