// TO DO: add your implementation and JavaDocs.
import java.util.Iterator;

//sorted list extended from BasicList
public class SortedList<T extends Comparable<T>> extends BasicList<T> { 

	// add a value into current list;
	// make sure all values are sorted in an ascending order from start to end of the list

	// - you can assume before add() is called, all existing values are sorted	
	// - if there is a tie, insert the new value as the last (i.e. closest to 
	//   the end of the list) among all values that are tied.
	
	// - if value is null, throw an IllegalArgumentException (with any error msg)
	
	//O(n) where n is the number of items in list
	
	public void add(T value){

	}
	
	//******************************************************
	//*******     BELOW THIS LINE IS TESTING CODE    *******
	//*******      Edit it as much as you'd like!    *******
	//*******        Remember to add JavaDoc         *******
	//******************************************************

	public static void main(String[] args) {
		SortedList<String> names = new SortedList<>();
		
		names.add("Mason");
		//System.out.println(names.listToString());
		names.add("George");
		//System.out.println(names.listToString());
		names.add("Washington");
		
		if (names.size()==3 && names.getFirst().equals("George") &&
			names.listToString().equals("George Mason Washington")){		
			System.out.println("Yay1");	
		}

		//System.out.println(names.listToString());
		
		class SomeType implements Comparable<SomeType> {
			private String value;

			public SomeType(String value) { this.value = value; }
			
			public int compareTo(SomeType other) {
				//use the length to compare
				return this.value.length() - other.value.length();
			}
			
			public String toString(){ return value;}
		}	
		
		SomeType item1 = new SomeType("123");
		SomeType item2 = new SomeType("1234");
		SomeType item3 = new SomeType("12345");
		SomeType item4 = new SomeType("7890");
		
		
		SortedList<SomeType> items = new SortedList<>();
		items.add(item2);
		items.add(item1);
		items.add(item3);
		
		boolean ok = items.listToString().equals("123 1234 12345");
		items.add(item4);
		//add with a tie: 7890 should be inserted after 1234
		if ( ok && items.listToString().equals("123 1234 7890 12345")){
			System.out.println("Yay2");				
		}

		
	}	
}
