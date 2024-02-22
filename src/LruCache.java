// TO DO: add your implementation and JavaDocs.
import java.util.Iterator;

/**
 * Cache implementing LRU replacement policy.
 */
public class LruCache implements Cache {

	/**
	 * Capacity  of the Cache.
	 */
	private int capacity;
	/**
	 * each address is a string.
	 */
	private BasicList<String> storage; //

	// YOU CANNOT ADD MORE DATA MEMBERS!
	// ADD PRIVATE HELPER METHODS IF NEEDED!
	
	/**
	 * constructor for a cache with capacity as cap	.
	 * @param cap is not positive, throw an IllegalArgumentException (with any error msg).
	 */
	public LruCache(int cap){
		this.storage = new BasicList<>();
		this.capacity = cap;
	}
	
	/**
	 * return true if cache is full; false otherwise.
	 * @return true if cache is full; false otherwise.
	 */
	public boolean isFull(){
		//default return; update or change as needed
		return capacity == storage.size();

	}


	/**
	 * report max number of items allowed in cache.
	 * @return report max number of items allowed in cache.
	 */
	public int capacity(){
		//default return; update or change as needed
		return capacity;

	}

	/**
	 * report the number of items stored in cache.
	 * @return size of the storage.
	 */
	public int size(){
		//default return; update or change as needed
		return storage.size();

	}
	
	/**
	 * return item that will be evicted if the next access is a miss O(1).
	 * @return null if no item will be evicted.
	 */
	public String nextToReplace(){
		//default return; update or change as needed
		return isFull()?storage.getFirst():null;

	}
	
	//determine whether the access to addr is a hit or miss
	//return true for a hit and false for a miss
	// perform necessary updating to maintain the LRU cache
	// - if addr is null, throw an IllegalArgumentException (with any error msg)
	//O(n) where n is the number of items in cache

	/**
	 * determine whether the access to addr is a hit or miss.
	 * @param addr the address requested by the next access
	 * @return true if operation successful.
	 */
	public boolean access(String addr){
		if(addr == null){
			throw new IllegalArgumentException("Address cannot be null");
		}
		Node<String> page = storage.getNode(addr);
		if(page == null){
			if(isFull())
				storage.removeFirst();
			storage.addLast(addr);
			return false;
		}else{
			storage.moveToBack(addr);
			return true;
		}
	}

			
	//return a string representing all items in cache
	// - follow the order from LRU to MRU
	//return an empty string if cache is empty
	//O(n) where n is the number of items in cache
	@Override
	public String toString(){
		//default return; update or change as needed
		return storage.listToString();

	}
	
	

}
