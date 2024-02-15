// TO DO: add your implementation and JavaDocs.

//Reminder: no array allowed.

import java.util.Iterator;

// singly linked list, no dummy nodes
public class BasicList<T> implements Iterable<T> { 

	//******************************************************
	//*******     BELOW THIS LINE IS PROVIDED code   *******
	//*******             Do NOT edit code!          *******
	//*******         Remember to add JavaDoc        *******
	//******************************************************
	
	// start of the list; do NOT change the name/type of this
	protected Node<T> head = null;  

	public Iterator<T> iterator() {
		//Return an iterator that traverses from
		//the beginning to the end of the list.
		//This provided code would work if you have set up the list correctly.
		
		return new Iterator<T>() {
			Node<T> current = head;
			
			public boolean hasNext(){
				return current!=null;
			}
				
			//next() would throw a NullPointerException
			//if you try to use next when there are no more items 
			public T next(){
				T toReturn = current.getData();
				current = current.getNext();
				return toReturn;
			}
		};
	}
	//******************************************************
	//*******    	END of PROVIDED Code 	 		 *******
	//*******    	Do NOT Change PROVIDED Code 	 *******
	//******************************************************


	// -define additional instance variables as needed, no public ones allowed
	// -you can define additional helper methods but they must be private
	
	// initialize the list to be an empty list
	public BasicList(){


	}
	
	// report number of items
	// O(1)
	public int size(){
	
		//default return; update or change as needed
		return -1;
	}
	
	// return the first value from the beginning of the list
	// do not remove the value!
	// return null if list is empty
	// O(1)
	public T getFirst() {
		//default return; update or change as needed
		return null;
	
	}

	// insert a new node with value at the beginning of the list
	// null value not allowed: 
	//    throw IllegalArgumentException (with any error msg) if value is null
	// O(1)
	public void addFirst(T value) {

	}
	
	// remove and return the first value from the beginning of the list
	//return null if list is empty
	// O(1)
	public T removeFirst(){
		//default return; update or change as needed
		return null;
	
	}

	// return the last value from the end of the list
	// do not remove the value!
	// return null if list is empty
	// O(1)
	public T getLast() {
		//default return; update or change as needed
		return null;
	
	}


	// append a new value at the end of the list
	// null value not allowed:  see addFirst() above
	// O(1)
	public void addLast(T value) {		

	}

	
	// remove and return the last value from the end of the list
	//return null if list is empty
	// O(n) where n is the number of items in list
	public T removeLast(){
		//default return; update or change as needed
		return null;

	}
	
	//remove and return the first occurence of value 
	// (i.e. the occurence that is closest to start of the list)
	// - return null if value is null or not present
	// - note: must return the value from list, not the argument value
	//O(n) where n is the number of items in list
	public T remove(T value){
		//default return; update or change as needed
		return null;
	
	}

	//return the index of the first occurence of value 
	// (i.e. the occurence that is closest to the start of the list)
	// return -1 if value is null or not present	
	//O(n) where n is the number of items in list
	public int indexOf(T value){
		//default return; update or change as needed
		return -10;
	
	}


	// return a string representing all values in the list, from beginning to end,
	// seperated by a single space
	// return empty string for empty list
	// O(n) where n is the number of items in list
	// Warning: concatenating String objects will yield a O(n^2) solution
	public String listToString() {  
		//default return; update or change as needed
		return null;

	}

	//return first node from start that contains value
	//return null if value is null or not present
	// NOTE: the layout of nodes is typically hidden and not available to outside;
	//       we are declaring this public for testing purpose. 
	//       Do not use this method outside of BasicList/SortedList classes.
	//O(n) where n is the number of items in list
	public Node<T> getNode(T value){
		//default return; update or change as needed
		return null;
	}
	
	//find the first node that contains the given value, and move the node to the start of list
	// i.e. indexOf(value)==0 after moving completes
	// - return true if move can be performed
	// 	- no change if value already at the start but still return true
	// - return false if value is null or not present
	// Note: You must reuse the existing node while move its location in list; 
	//        do NOT remove then add the value back using a new node.  
	//        Points will be deducted in grading if you do so.
	//O(n) where n is the number of items in list
	public boolean moveToFront(T value){
		//default return; update or change as needed
		return false;
	
	}
	
	//find the first node that contains the given value, 
	// and move the node one location closer to start of the list
	// i.e. if indexOf(value)==x before the move, then after moving completes, indexOf(value)==x-1
	// - return true if move can be performed
	// 	- no change if value already at the start but still return true
	// - return false if value is null or not present
	// Note:  You must reuse the existing node while move its location in list; 
	//        do NOT remove then add the value back using a new node
	//        Points will be deducted in grading if you do so.
	//O(n) where n is the number of items in list
	public boolean moveForward(T value){
		//default return; update or change as needed
		return false;

	}
	
	//find the first node that contains the given value, and move the node to the end of list
	// i.e. if only one node contains value, then indexOf(value)==size()-1 after moving completes 
	// - return true if move can be performed
	// 	- no change if value already at the end but still return true
	// - return false if value is null or not present
	// Note:  You must reuse the existing node while move its location in list; 
	//        do NOT remove then add the value back using a new node
	//        Points will be deducted in grading if you do so.
	//O(n) where n is the number of items in list
	public boolean moveToBack(T value){
		//default return; update or change as needed
		return false;
	}
	
	//find the first node that contains the given value, 
	// and move the node one location closer to end of the list
	// i.e. if only one node contains value and indexOf(value)==x before the move, 
	//      then after moving completes, indexOf(value)==x+1
	// - return true if move can be performed
	// 	- no change if value already at the end but still return true
	// - return false if value is null or not present
	// Note:  You must reuse the existing node while move its location in list; 
	//        do NOT remove then add the value back using a new node
	//        Points will be deducted in grading if you do so.
	//O(n) where n is the number of items in list
	public boolean moveBackward(T value){

		//default return; update or change as needed
		return false;
		
	}
	
	

	//******************************************************
	//*******     BELOW THIS LINE IS TESTING CODE    *******
	//*******      Edit it as much as you'd like!    *******
	//*******        Remember to add JavaDoc         *******
	//******************************************************
	

	public static void main(String[] args) {

		//a list of integers	
		BasicList<Integer> nums = new BasicList<>();

		//basic operations
		nums.addLast(100);
		nums.addFirst(200);
		nums.addFirst(300);
		nums.addFirst(400);	
		
		if (nums.getFirst()==400 && nums.getLast()==100 &&
			nums.listToString().equals("400 300 200 100")) {
			System.out.println("Yay1");
		}
		//System.out.println(nums.listToString());	
		
		//a list of strings
		BasicList<String> names = new BasicList<>();
		names.addLast("apple");
		names.addLast("banana");
		names.addLast("blueberry");
		names.addLast("orange");
		names.addLast("blueberry");
		names.addLast("peach");

		if (names.removeFirst().equals("apple") && 
			names.remove("blueberry").equals("blueberry") && names.size() == 4 &&
			names.indexOf("blueberry") == 2 && 
			names.listToString().equals("banana orange blueberry peach")){
			System.out.println("Yay2");			
		}

		//getNode and move methods
		// -reminder: keep the original node but move it to a new location
		// - we will use getNode() to verify this as the examples below
		
		Node<String> node = names.getNode("orange");
		if (names.moveToFront("orange") && names.getNode("orange") == node &&
			names.listToString().equals("orange banana blueberry peach")){
			System.out.println("Yay3");						
		}

		node = names.getNode("peach");
		if (names.moveForward("peach") && names.getNode("peach") == node &&
			names.listToString().equals("orange banana peach blueberry")){
			System.out.println("Yay4");
		}

		//remove special case
		class SomeType{
			private String value;

			public SomeType(String value) { this.value = value; }
			
			public boolean equals(Object o) {
				if (!(o instanceof SomeType)) return false;
				
				//both null
				if (((SomeType)o).value == null && this.value==null) return true;
				
				//both empty string
				if (((SomeType)o).value.length() == 0 && this.value.length()==0) return true;
				
				//compare the leading chars
				return ((SomeType)o).value.charAt(0) == this.value.charAt(0);
			}
			
			public String toString(){ return value;}
		}
		
		SomeType item1 = new SomeType("Apple");
		SomeType item2 = new SomeType("Alligator");
		SomeType item3 = new SomeType("Bee");
		SomeType item4 = new SomeType("Alder");
		
		
		BasicList<SomeType> items = new BasicList<>();
		items.addLast(item1);
		items.addLast(item2);
		items.addLast(item3);
		
		SomeType deleted = items.remove(item4);
		if (deleted.toString().equals("Apple")){
			System.out.println("Yay5");
		}
	
		//add more test cases by yourself!
		
	}
}