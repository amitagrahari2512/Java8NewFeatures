package lru_least_recently_used;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheEmployeeImpl extends LinkedHashMap<LRUEmployee, String> {
	   private static final long serialVersionUID = 1L;
	   private int capacity;
	    
	   public LRUCacheEmployeeImpl(int capacity, float loadFactor){
	      super(capacity, loadFactor, true);
	      this.capacity = capacity;
	   }
	    
	   /**
	    * removeEldestEntry() should be overridden by the user, otherwise it will not 
	    * remove the oldest object from the Map.
	    */
	   @Override
	   protected boolean removeEldestEntry(Map.Entry<LRUEmployee, String> eldest){
	      return size() > this.capacity;
	   }
	    
	   public static void main(String arg[]){
	      LRUCacheEmployeeImpl lruCache = new LRUCacheEmployeeImpl(4, 0.75f);
	      LRUEmployee l1 = new LRUEmployee(1, "A", "A");
	      LRUEmployee l2 = new LRUEmployee(2, "B", "B");
	      LRUEmployee l3 = new LRUEmployee(3, "C", "C");
	      LRUEmployee l4 = new LRUEmployee(4, "D", "D");
	      LRUEmployee l5 = new LRUEmployee(5, "E", "E");
	      LRUEmployee l6 = new LRUEmployee(6, "F", "F");
	      LRUEmployee l7 = new LRUEmployee(7, "G", "G");
	      LRUEmployee l8 = new LRUEmployee(8, "H", "H");
	      LRUEmployee l11 = new LRUEmployee(1, "A", "A");
	      lruCache.put(l1, "Object1");
	      lruCache.put(l2, "Object2");
	      lruCache.put(l3, "Object3");
	      lruCache.put(l11, "Object11");
	      lruCache.get(l1);
	      lruCache.put(l4, "Object4");
	      System.out.println(lruCache);
	      lruCache.put(l5, "Object5");
	      lruCache.get(l3);
	      lruCache.put(l6, "Object6");
	      System.out.println(lruCache);
	      lruCache.get(l4);
	      lruCache.put(l7, "Object7");
	      lruCache.put(l8, "Object8");
	      System.out.println(lruCache);
	   }
	}
