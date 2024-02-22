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
	protected Node<T> tail = null;
	protected int size;

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
	
	/**
	 * initialize the list to be an empty list.
	 */
	public BasicList(){
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * report number of items O(1).
	 * @return size of the list
	 */
	public int size(){
		return size;
	}
	
	/**
	 * return the first value from the beginning of the list do not remove the value!.
	 * @return null if list is empty
	 */
	public T getFirst() {
		return head != null? head.getData() : null;
	}

	/**
	 * insert a new node with value at the beginning of the list O(1).
	 * @param value: null value not allowed. throw IllegalArgumentException (with any error msg) if value is null.
	 */
	public void addFirst(T value) {
		if(value == null){
			throw new IllegalArgumentException("null value not allowed");
		}
		Node<T> newNode = new Node<>(value);
		newNode.setNext(head);
		head = newNode;
		if(tail == null){
			tail = newNode;
		}
		size++;
	}
	
	/**
	 * remove and return the first value from the beginning of the list O(1).
	 * @return null if list is empty
	 */
	public T removeFirst(){
		Node<T> temp=head;
		head=head.getNext();
		size--;
		return temp.getData();
	
	}

	/**
	 *
	 * @return return the last value from the end of the list
	 */
	public T getLast() {
		return  tail != null? tail.getData() : null;
	}


	/**
	 * append a new value at the end of the list O(1).
	 * @param value null value not allowed.
	 */
	public void addLast(T value) {

		if(value == null){
			throw new IllegalArgumentException("null value not allowed");
		}
		Node<T> newNode = new Node<>(value);
		if (head == null){
			head = newNode;
			tail = newNode;
			size++;
			return ;
		}
		tail.setNext(newNode);
		tail = newNode;
		size++;
	}

	/**
	 * remove and return the last value from the end of the list.
	 * O(n) where n is the number of items in list.
	 * @return returns null if list is empty
	 */
	public T removeLast() {
		if (head == null) {
			// If the list is empty, return null or throw an exception based on your requirements.
			return null;
		}

		T removedData;
		// If there's only one element in the list
		if (head == tail) {
			removedData = head.getData();
			head = tail = null;
			size--;
			return removedData;
		}

		// Traverse the list to find the second-to-last node
		Node<T> current = head;
		while (current.getNext() != tail) {
			current = current.getNext();
		}

		// Update tail to the second-to-last node and remove the last node
		removedData = tail.getData();
		current.setNext(null);
		tail = current;
		size--;
		return removedData;
	}

	/**
	 * remove and return the first occurence of value.
	 * O(n) where n is the number of items in list.
	 * @param value
	 * @return return null if value is null or not present.
	 */
	public T remove(T value) {
		if (head == null) {
			// If the list is empty, return null or throw an exception based on your requirements.
			return null;
		}

		// If the value to be removed is at the head
		if (head.getData().equals(value)) {
			T removedData = head.getData();
			head = head.getNext();
			// If the list becomes empty after removal, update tail to null
			if (head == null) {
				tail = null;
			}
			size--;
			return removedData;
		}

		// Traverse the list to find the node with the given value
		Node<T> current = head;
		while (current.getNext() != null && !current.getNext().getData().equals(value)) {
			current = current.getNext();
		}

		// If the value is found, remove the node
		if (current.getNext() != null) {
			T removedData = current.getNext().getData();
			current.setNext(current.getNext().getNext());

			// If the removed node was the tail, update tail
			if (current.getNext() == null) {
				tail = current;
			}
			size--;
			return removedData;
		}

		// If the value is not found, return null or throw an exception based on your requirements.
		return null;
	}

	//return the index of the first occurence of value 
	// (i.e. the occurence that is closest to the start of the list)
	// return -1 if value is null or not present	
	//O(n) where n is the number of items in list
	public int indexOf(T value) {
		int index = 0;
		Node<T> current = head;

		while (current != null) {
			if (current.getData().equals(value)) {
				return index;
			}
			current = current.getNext();
			index++;
		}
		return -1;
	}


	/**
	 * a string representing all values in the list, from beginning to end,seperated by a single space.
	 * @return returns empty string for empty list.
	 */
	public String listToString() {
		StringBuilder result = new StringBuilder();

		Node<T> current = head;
		while (current != null) {
			result.append(current.getData()).append(" ");
			current = current.getNext();
		}

		// Trim the trailing space and return the result
		return result.toString().trim();
	}

	//return first node from start that contains value
	//return null if value is null or not present
	// NOTE: the layout of nodes is typically hidden and not available to outside;
	//       we are declaring this public for testing purpose. 
	//       Do not use this method outside of BasicList/SortedList classes.
	//O(n) where n is the number of items in list

	/**
	 * Method to get the first node with a specific value.
	 * @param value a specific value to search.
	 * @return returns null if value is null or not present
	 */
	public Node<T> getNode(T value) {
		Node<T> current = head;

		while (current != null) {
			if (current.getData().equals(value)) {
				return current;
			}
			current = current.getNext();
		}

		// If the value is not found, return null
		return null;
	}
	
	/**
	 * finds the first node that contains the given value, and move the node to the start of list.
	 * @param value specific value to find.
	 * @return true if move can be performed and no change if value already at the start but still return true, returns false if value is null or not present.
	 */
	public boolean moveToFront(T value) {
		if (head == null) {
			// List is empty or contains only one node, no swapping needed
			return false;
		}

		if(head.getData().equals(value)){
			return true;
		}

		// If the node to move is the head, no swapping needed
		Node<T> current = head;
		Node<T> prev = null;

		// Iterate through the list to find the node with the specified value
		while (current != null && !current.getData().equals(value)) {
			prev = current;
			current = current.getNext();
		}

		if (current == null) {
			// If the value is not found in the list, return false
			return false;
		}

		// Move the found node to the front
		if (prev != null) {
			prev.setNext(current.getNext());
			current.setNext(head);
			head = current;

			if (tail == current) {
				// If the moved node was the tail, update tail reference
				tail = prev;
			}
		}

		return true;
	}


	/**
	 *  Finds the first node containing the given value and moves the node one location closer to the start of the list.
	 * @param value specific value to move.
	 * @return true if move can be performed and no change if value already at the start but still return true, returns false if value is null or not present.
	 */
	public boolean moveForward(T value) {
		if (head == null ) {
			// List is empty or contains only one node, no moving needed
			return false;
		}

		if(head.getData().equals(value)){
			return true;
		}

		Node<T> current = head;
		Node<T> prev = null;

		// Iterate through the list to find the node with the specified value
		while (current != null && current.getNext() != null && !current.getNext().getData().equals(value)) {
			prev = current;
			current = current.getNext();
		}
		if (current == null || prev == null) {
			// If the value is not found or the node is already at the beginning, return false
			return false;
		}

		// Move the found node one position forward by swapping it with the previous node
		Node<T> nextNode = current.getNext();
		prev.setNext(current.getNext());
		current.setNext(nextNode.getNext());
		nextNode.setNext(current);

		if (head == current) {
			// If the moved node was the head, update head reference
			head = nextNode;
		}

		if (tail == nextNode) {
			// If the next node was the tail, update tail reference
			tail = current;
		}

		return true;
	}


	/**
	 * find the first node that contains the given value, and move the node to the end of list.
	 * @param value  specific value to move.
	 * @return true if move can be performed else false.
	 */
	public boolean moveToBack(T value) {
		if (head == null || size <= 1) {
			// If the list is empty or has only one element, no need to move to back
			return false;
		}

		Node<T> current = head;
		Node<T> prev = null;

		// Part 1: Node to move is the first node
		if (current.getData().equals(value)) {
			head = current.getNext();
			tail.setNext(current);
			tail = current;
			current.setNext(null);
			return true;
		}

		// Part 2: Node to move is the tail
		while (current.getNext() != null) {
			if (current.getNext() == tail && current.getNext().getData().equals(value)) {
				// Node to move is the tail, no need to move, return true
				return true;
			}
			current = current.getNext();
		}

		// Part 3: Node to move is a middle node
		current = head;
		while (current != null && !current.getData().equals(value)) {
			prev = current;
			current = current.getNext();
		}

		if (current == null) {
			// If the value is not found, return false
			return false;
		}

		// Move the found node to the back by updating references
		prev.setNext(current.getNext());
		tail.setNext(current);
		tail = current;
		current.setNext(null);

		return true;
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
	public boolean moveBackward(T value) {
		if (head == null || size <= 1) {
			// If the list is empty or has only one element, no need to move backward
			return false;
		}

		Node<T> current = head;
		Node<T> prev = null;

		// Part 1: Node to move is the first node
		if (current.getData().equals(value)) {
			// Move the first node to the back
			Node<T> nextNode = current.getNext();
			current.setNext(nextNode.getNext());
			nextNode.setNext(current);
			head = nextNode;
			if (tail == current) {
				// If the current node was the tail, update tail reference
				tail = nextNode;
			}
			return true;
		}

		// Part 2: Node to move is the tail
		if (tail.getData().equals(value)) {
			return true; // Node is already the tail, no need to move
		}

		// Part 3: Node to move is a middle node
		while (current != null && current.getNext() != null && !current.getData().equals(value)) {
			prev = current;
			current = current.getNext();
		}

		if (current == null || prev == null) {
			// If the value is not found or the node is already at the beginning, return false
			return false;
		}

		// Move the found node one position forward by swapping it with the previous node
		Node<T> nextNode = current.getNext();
		if (nextNode != null) {
			prev.setNext(nextNode);
			current.setNext(nextNode.getNext());
			nextNode.setNext(current);

			if (head == current) {
				// If the moved node was the head, update head reference
				head = nextNode;
			}

			if (tail == nextNode) {
				// If the next node was the tail, update tail reference
				tail = current;
			}

			return true;
		}

		return false;
	}


	public static void mainn(String[] args) {
		// Create a BasicList
		BasicList<Integer> list = new BasicList<>();
		list.addLast(12);
		list.addLast(34);
		list.addLast(56);
		list.addLast(23);
		list.addLast(67);

		// Expected state before moveBackward(34)
		System.out.println(list.listToString());

		// Perform moveBackward(34)
		System.out.println(list.moveToBack(23));

		// Expected state after moveBackward(34)
		System.out.println(list.listToString());
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

		Node<String> node = names.getNode("banana");
		if (names.moveToFront("banana") && names.getNode("banana") == node &&
				names.listToString().equals("banana orange blueberry peach")){
			System.out.println("Yay31");
		}

		node = names.getNode("orange");
		if (names.moveToFront("orange") && names.getNode("orange") == node &&
			names.listToString().equals("orange banana blueberry peach")){
			System.out.println("Yay32");
		}


		node = names.getNode("peach");
		if (names.moveToFront("peach") && names.getNode("peach") == node &&
				names.listToString().equals("peach orange banana blueberry")){
			System.out.println("Yay33");
		}

		node = names.getNode("peach");
		if (names.moveForward("peach") && names.getNode("peach") == node &&
			names.listToString().equals("peach orange banana blueberry")){
			System.out.println("Yay41");
		}

		node = names.getNode("banana");
		if (names.moveForward("banana") && names.getNode("banana") == node &&
				names.listToString().equals("peach banana orange blueberry")){
			System.out.println("Yay42");
		}

		node = names.getNode("blueberry");
		if (names.moveForward("blueberry") && names.getNode("blueberry") == node &&
				names.listToString().equals("peach banana blueberry orange")){
			System.out.println("Yay43");
		}


		node = names.getNode("orange");
		if (names.moveToBack("orange") && names.getNode("orange") == node &&
				names.listToString().equals("peach banana blueberry orange")){
			System.out.println("Yay51");
		}

		node = names.getNode("peach");
		if (names.moveToBack("peach") && names.getNode("peach") == node &&
				names.listToString().equals("banana blueberry orange peach")){
			System.out.println("Yay52");
		}

		node = names.getNode("blueberry");
		if (names.moveToBack("blueberry") && names.getNode("blueberry") == node &&
				names.listToString().equals("banana orange peach blueberry")){
			System.out.println("Yay53");
		}


		node = names.getNode("banana");// banana is first
		if (names.moveBackward("banana") && names.getNode("banana") == node &&
				names.listToString().equals("orange banana peach blueberry")){
			System.out.println("Yay61");
		}

		node = names.getNode("banana"); // banana is middle
		if (names.moveBackward("banana") && names.getNode("banana") == node &&
				names.listToString().equals("orange peach banana blueberry")){
			System.out.println("Yay62");
		}

		node = names.getNode("blueberry");
		if (names.moveBackward("blueberry") && names.getNode("blueberry") == node &&
				names.listToString().equals("orange peach banana blueberry")){
			System.out.println("Yay63");
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
			System.out.println("Yay7");
		}
	
		//add more test cases by yourself!
		
	}
}