package array_list_copy_on_array_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListClass {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<String> itr = list.iterator();
		
		System.out.println("Iterating Without Error");
		while(itr.hasNext())
		{
			
			String c = itr.next();
			System.out.println(c);
			if("B".equals(c)){
				itr.remove();
			}
		}
		
		System.out.println(list);
		
		/*Iterator<String> itr1 = list.iterator();
		System.out.println("Iterating With when add element in list Error");
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
			list.add("D");
		}*/
		
		Iterator<String> itr1 = list.iterator();
		System.out.println("Iterating With when remove element in list Error");
		while(itr1.hasNext())
		{
			list.remove("C");
			System.out.println(itr1.next());
			
		}

	}

}
