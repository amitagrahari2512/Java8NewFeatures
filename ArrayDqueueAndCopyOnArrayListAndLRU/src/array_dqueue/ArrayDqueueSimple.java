package array_dqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDqueueSimple {
	
	public static Deque<String> deque = null;
	
	public ArrayDqueueSimple() {
		super();
		populateDqueue();
	}
	
	private void populateDqueue()
	{
		deque = new ArrayDeque<>();
	}
	
	private void offerDeque() {
		commonDisplay("Offer Function Through Add they return boolean value");
		System.out.println(deque.offer("oFirst"));
		System.out.println(deque.offer("oSecond"));
		System.out.println(deque.offerFirst("offerFirst"));
		System.out.println(deque.offer("oThird"));
		System.out.println(deque.offer("oThird"));
		System.out.println(deque.offerLast("offerLast"));
		System.out.println(deque);
	}
	
	private void addDeque(){
		commonDisplay("Add Function Through Add,only add() method return boolean value.But addFirst() and addLast() does not return any value");
		System.out.println(deque.add("aFirst"));
		deque.add("aSecond");
		//System.out.println(deque.addFirst("addFirst"));
		deque.addFirst("addFirst");
		deque.add("aThird");
		deque.add("aThird");
		deque.addLast("addLast");
		System.out.println(deque);
	}
	
	private void nullTestWithOffer()
	{
		commonDisplay("Null test, pass null on offer method");
		try{
		deque.offer(null);
		}
		catch(Exception e)
		{
			System.out.println(e.toString() + " ,null value is not allowed in offer() method");
		}
	}

	public void nullTestWithAdd() {
		commonDisplay("Null test, pass null on add method");
		try {
			deque.add(null);
		} catch (Exception e) {
			System.out.println(e.toString() + " ,null value is not allowed in add() method");
		}
	}
	
	private void commonDisplay(String val){
		System.out.println("*********"+val+"**********");
	}
	
	private void removeTest(String val) {
		try
		{
		commonDisplay("Remove check : "+val);
		System.out.println("deque.remove() : "+deque.remove()); //remove() gives error if no element present in Deque.
		System.out.println(deque);
		System.out.println("deque.removeFirst() : "+deque.removeFirst());  //removeFirst() gives error if no element present in Deque.
		System.out.println(deque);
		System.out.println("deque.removeLast() : "+deque.removeLast());  //removeLast() gives error if no element present in Deque.
		System.out.println(deque);
		}
		catch(Exception e)
		{
			System.out.println(e.toString() + " , looks like Deque is empty" );
		}
	}
	
	private void pollTest(String val) {
		commonDisplay("Poll Test : "+val);
		System.out.println("deque.poll() : "+deque.poll()); 
		System.out.println(deque);
		System.out.println("deque.pollFirst() : "+deque.pollFirst());  
		System.out.println(deque);
		System.out.println("deque.pollLast() : "+deque.pollLast());  
		System.out.println(deque);
	}
	
	
	private void getTest(String val) {
		try
		{
		commonDisplay("Get Test : "+val);
		System.out.println("deque.getFirst() : "+deque.getFirst());  //getFirst() gives error if no element present in Deque.
		System.out.println(deque);
		System.out.println("deque.getLast() : "+deque.getLast());  //getremoveLast() gives error if no element present in Deque.
		System.out.println(deque);
		}
		catch(Exception e)
		{
			System.out.println(e.toString() + " , looks like Deque is empty" );
		}
	}
	
	private void elementTest(String val)
	{
		try
		{
		commonDisplay("Element Test : "+val);
		System.out.println("deque.element() : "+deque.element()); 
		System.out.println(deque);
		}
		catch(Exception e)
		{
			System.out.println(e.toString() + " , looks like Deque is empty" );
		}
	}
	
	private void peekTest(String val) {
		commonDisplay("Peek Test : "+val);
		System.out.println("deque.peek() : "+deque.peek()); 
		System.out.println(deque);
		System.out.println("deque.peekFirst() : "+deque.peekFirst()); 
		System.out.println(deque);
		System.out.println("deque.peekLast() : "+deque.peekLast()); 
		System.out.println(deque);
	}
	
	private void removeObjectTest(String val) {
		commonDisplay("remove object Test : "+val);
		System.out.println("deque.remove(oThird) : "+deque.remove("oThird")); 
		System.out.println(deque);
		System.out.println("deque.removeFirstOccurrence(aThird) : "+deque.removeFirstOccurrence("aThird")); 
		System.out.println(deque);
		System.out.println("deque.removeLastOccurrence(aThird) : "+deque.removeLastOccurrence("aThird")); 
		System.out.println(deque);
	}
	
	private void toArrayTest()
	{
		commonDisplay("toArray test");
		Object[] obj = deque.toArray();
		for (Object object : obj) {
			System.out.println(object);
		}
		
		String[] str = deque.toArray(new String[0]);
		System.out.println("Length of Array : "+str.length);
		for (String object : str) {
			System.out.println(object);
		}
	}
	
	private void containsTest(String val)
	{
		commonDisplay("Contains Test : "+val);
		System.out.println(deque.contains("aThird"));
	}
	

	public static void main(String[] args) {
		ArrayDqueueSimple a = new ArrayDqueueSimple();
		a.containsTest("Deque have no elemnts");
		a.removeObjectTest("Deque have no elemnts");
		a.removeTest("Deque have no elemnts");
		a.pollTest("Deque have no elemnts");
		a.getTest("Deque have no elemnts");
		a.peekTest("Deque have no elemnts");
		a.elementTest("Deque have no elemnts");
		a.offerDeque();
		a.addDeque();
		a.nullTestWithOffer();
		a.nullTestWithAdd();
		a.containsTest("Deque have elemnts");
		a.removeObjectTest("Deque have elemnts");
		a.removeTest("Deque have elements");
		a.pollTest("Deque have elements");
		a.getTest("Deque have elements");
		a.peekTest("Deque have elements");
		a.elementTest("Deque have elemnts");
		a.toArrayTest();
		
	}

	

}
