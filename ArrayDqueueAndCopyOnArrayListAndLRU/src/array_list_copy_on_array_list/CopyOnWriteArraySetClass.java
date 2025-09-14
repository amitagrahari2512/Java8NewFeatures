package array_list_copy_on_array_list;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetClass {

	public static void main(String[] args) {
		Set<String> s = new CopyOnWriteArraySet<>();
		s.add("A");
		s.add("B");
		
		Iterator<String> i = s.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
			System.out.println(s.add("C"));
			System.out.println(s.remove("B"));
		}
		
		 i = s.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}

}
