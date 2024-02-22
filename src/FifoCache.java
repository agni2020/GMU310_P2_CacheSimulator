// TO DO: add your implementation and JavaDocs.
import java.util.Iterator;

//

/**
 * Cache implementing FIFO replacement policy.
 */
public class FifoCache implements Cache {

	/**
	 * Capacity of the Cache.
	 */
	private int capacity;
	/**
	 * each address is a string.
	 */
	private BasicList<String> storage; //

	// YOU CANNOT ADD MORE DATA MEMBERS!
	// ADD PRIVATE HELPER METHODS IF NEEDED!

	/**
	 * constructor for  a cache with capacity as cap	.
	 * @param cap cap is not positive, throw an IllegalArgumentException (with any error msg)
	 */
	public FifoCache(int cap){
		this.storage = new BasicList<>();
		this.capacity=cap;
	}
	
	/**
	 * checks if cache is full.
	 * @return  true if cache is full; false otherwise
	 */
	public boolean isFull(){
		//default return; update or change as needed
		return storage.size() == capacity;

	}

	/**
	 * report max number of items allowed in cache.
	 * @return max number of items allowed in cache
	 */
	public int capacity(){
		//default return; update or change as needed
		return capacity;

	}

	/**
	 * report the number of items stored in cache.
	 * @return the number of items stored in cache.
	 */
	public int size(){
		//default return; update or change as needed
		return storage.size();

	}

	/**
	 * return item that will be evicted if the next access is a miss.
	 * @return item that will be evicted if the next access is a miss.
	 */
	public String nextToReplace(){
		//default return; update or change as needed
		return isFull()?storage.getFirst():null;

	}

	/**
	 * determine whether the access to addr is a hit or miss.
	 * @param addr the address requested by the next access.
	 * @return true for a hit and false for a miss.
	 */
	public boolean access(String addr){
		//default return; update or change as needed
		if(addr == null){
			throw new IllegalArgumentException("Address cannot be null");
		}
		if(storage.getNode(addr) == null){
			if(isFull())
				storage.removeFirst();
			storage.addLast(addr);
			return false;
		}else{
			return true;
		}

	}
	
	//return a string representing all items in cache
	// - follow the order from first in to last in
	//return an empty string if cache is empty
	//O(n) where n is the number of items in cache
	@Override
	public String toString(){
		//default return; update or change as needed
		return storage.listToString();
	
	}

}	
