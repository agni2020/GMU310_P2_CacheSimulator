// TO DO: add your implementation and JavaDocs.
import java.util.Iterator;

//Cache implementing FIFO replacement policy
public class FifoCache implements Cache { 

	private int capacity;
	private BasicList<String> storage; //each address is a string

	// YOU CANNOT ADD MORE DATA MEMBERS!
	// ADD PRIVATE HELPER METHODS IF NEEDED!

	//constructor for a cache with capacity as cap	
	// - if cap is not positive, throw an IllegalArgumentException (with any error msg)
	//O(1)
	public FifoCache(int cap){

	}
	
	//return true if cache is full; false otherwise
	//O(1)
	public boolean isFull(){
		//default return; update or change as needed
		return false;

	}

	//report max number of items allowed in cache
	//O(1)
	public int capacity(){
		//default return; update or change as needed
		return -2;

	}

	//report the number of items stored in cache
	//O(1)
	public int size(){
		//default return; update or change as needed
		return -2;

	}

	//return item that will be evicted if the next access is a miss
	//return null if no item will be evicted
	//O(1)
	public String nextToReplace(){
		//default return; update or change as needed
		return null;

	}

	//determine whether the access to addr is a hit or miss
	//return true for a hit and false for a miss
	// perform necessary updating to maintain the FIFO cache
	// - if addr is null, throw an IllegalArgumentException (with any error msg)
	//O(n) where n is the number of items in cache
	public boolean access(String addr){
		//default return; update or change as needed
		return false;

	}
	
	//return a string representing all items in cache
	// - follow the order from first in to last in
	//return an empty string if cache is empty
	//O(n) where n is the number of items in cache
	@Override
	public String toString(){
		//default return; update or change as needed
		return null;
	
	}

}	
