package array_dqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeUsingEmployee {
public static Deque<DequeEmployee> deque = null;
DequeEmployee d1 ,d2 , d3,d4,d5,d6,d7,d8,d9,d10,d11,d12;
	
	public ArrayDequeUsingEmployee() {
		super();
		populateDqueue();
	}
	
	private void populateDqueue()
	{
		deque = new ArrayDeque<>();
		d1 = new DequeEmployee(1, "oA", "offer");
		d2 = new DequeEmployee(2, "oB", "offer");
		d3 = new DequeEmployee(3, "oC", "offerFirst");
		d4 = new DequeEmployee(4, "oD", "offer");
		d5 = new DequeEmployee(5, "oE", "offer");
		d6 = new DequeEmployee(6, "0B", "offerLast");
		d7 = new DequeEmployee(7, "aG", "add");
		d8 = new DequeEmployee(8, "aH", "add");
		d9 = new DequeEmployee(9, "aI", "addFirst");
		d10 = new DequeEmployee(10, "aJ", "add");
		d11 = new DequeEmployee(11, "aK", "add");
		d12 = new DequeEmployee(12, "aL", "addLast");
	}
	
	private void offerDeque() {
		commonDisplay("Offer Function Through Add they return boolean value");
		System.out.println(deque.offer(d1));
		System.out.println(deque.offer(d2));
		System.out.println(deque.offerFirst(d3));
		System.out.println(deque.offer(d4));
		System.out.println(deque.offer(d5));
		System.out.println(deque.offerLast(d6));
		System.out.println(deque);
	}
	
	private void addDeque(){
		commonDisplay("Add Function Through Add,only add() method return boolean value.But addFirst() and addLast() does not return any value");
		System.out.println(deque.add(d7));
		deque.add(d8);
		deque.addFirst(d9);
		deque.add(d10);
		deque.add(d11);
		deque.addLast(d12);
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
		System.out.println("deque.remove(d1) : "+deque.remove(d1)); 
		System.out.println(deque);
		System.out.println("deque.removeFirstOccurrence(d2) : "+deque.removeFirstOccurrence(d2)); 
		System.out.println(deque);
		System.out.println("deque.removeLastOccurrence(d6) : "+deque.removeLastOccurrence(d6)); 
		System.out.println(deque);
	}
	
	private void toArrayTest()
	{
		commonDisplay("toArray test");
		Object[] obj = deque.toArray();
		for (Object object : obj) {
			System.out.println(object);
		}
		
		DequeEmployee[] str = deque.toArray(new DequeEmployee[0]);
		System.out.println("Length of Array : "+str.length);
		for (DequeEmployee object : str) {
			System.out.println(object);
		}
	}
	

	public static void main(String[] args) {
		ArrayDequeUsingEmployee a = new ArrayDequeUsingEmployee();
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
		a.removeObjectTest("Deque have elemnts");
		a.removeTest("Deque have elements");
		a.pollTest("Deque have elements");
		a.getTest("Deque have elements");
		a.peekTest("Deque have elements");
		a.elementTest("Deque have elemnts");
		a.toArrayTest();
	}
}
