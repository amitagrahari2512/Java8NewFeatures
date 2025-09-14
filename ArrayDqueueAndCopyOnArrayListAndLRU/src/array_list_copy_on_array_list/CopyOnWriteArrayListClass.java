package array_list_copy_on_array_list;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListClass {

	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<String> itr = list.iterator();
		
		System.out.println("Iterating Without Error");
		while(itr.hasNext())
		{
			
			String c = itr.next();
			System.out.println(c);
			System.out.println(list.remove("C"));
			System.out.println(list.add("D"));
		}
		
		itr = list.iterator();
		while(itr.hasNext())
		{
			
			String c = itr.next();
			System.out.println(c);
		}
		/*Iterator<String> itr1 = list.iterator();
		System.out.println("Iterating With when add element in list Error");
		while(itr1.hasNext())
		{
			System.out.println(itr1.next());
			list.add("D");
		}*/
		
		/*Iterator<String> itr1 = list.iterator();
		System.out.println("Iterating With when remove element in list Error");
		while(itr1.hasNext())
		{
			String c = itr1.next();
			if("B".equals(c)){
				list.remove("C");
			}
			
			System.out.println(c);
			
		}
*/
	}


}
