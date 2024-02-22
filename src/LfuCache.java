// TO DO: add your implementation and JavaDocs.
import java.util.Iterator;

//Cache implementing LFU replacement policy
public class LfuCache implements Cache { 

	//******************************************************
	//*******     BELOW THIS LINE IS PROVIDED code   *******
	//*******             Do NOT edit code!          *******
	//*******		   Remember to add JavaDoc		 *******
	//******************************************************

	//wrap each item we need to save in cache in a block and keep the access count
	private class Block implements Comparable<Block> {
	
		//data item to store in cache
		private String data;
		
		//how many times this item is accessed since it is loaded in
		private int count;
		
		//constructor
		public Block(String addr){
			this.data = addr;
			count = 1;
		}
	
		//getter of count
		public int getCount(){
			return count;
		}
		
		//increment count 
		public void incCount(){
			count++;
		}
		
		//getter of data item
		public String getData(){
			return data;
		}
		
		//used to determine whether an item is already in cache
		@Override
		public boolean equals(Object other){
			if (other instanceof Block){
				if ( ((Block)other).data.equals(this.data) ){
            		return true;
        		}
    		}
   			return false;		
		}
		
		//used to compare two items based on their access counts
		public int compareTo(Block other){
			return this.count - other.count;			
		}
	
		//string representation including access count
		@Override
		public String toString(){
			return "<"+data.toString()+","+count+">";
		}
	}
	
	private int capacity;
	private SortedList<Block> storage; //NOTE: SortedList! List of Blocks! 

	//******************************************************
	//*******    	END of PROVIDED Code 	 		 *******
	//*******    	Do NOT Change PROVIDED Code 	 *******
	//******************************************************

	// YOU CANNOT ADD MORE DATA MEMBERS!
	// ADD PRIVATE HELPER METHODS IF NEEDED!

	//constructor for a cache with capacity as cap	
	// - if cap is not positive, throw an IllegalArgumentException (with any error msg)
	//O(1)
	public LfuCache(int cap){
		storage = new SortedList<>();
		this.capacity = cap;
	}

	//return true if cache is full; false otherwise
	//O(1)
	public boolean isFull(){
		//default return; update or change as needed
		return this.capacity == size();

	}

	//report max number of items allowed in cache
	//O(1)
	public int capacity(){
		//default return; update or change as needed
		return this.capacity;

	}
	
	//report the number of items stored in cache
	//O(1)
	public int size(){
		//default return; update or change as needed
		return storage.size();

	}

	//return item that will be evicted if the next access is a miss
	//return null if no item will be evicted
	//O(1)
	public String nextToReplace(){
		//default return; update or change as needed
		return isFull()?storage.getFirst().data:null;

	}
	
	//determine whether the access to addr is a hit or miss
	//return true for a hit and false for a miss
	// perform necessary updating to maintain the LRU cache
	// - if addr is null, throw an IllegalArgumentException (with any error msg)
	//O(n) where n is the number of items in cache

	public boolean access(String addr){
		//default return; update or change as needed

		if(addr == null){
			throw new IllegalArgumentException("Address cannot be null");
		}
		Node<Block> page = storage.getNode(new Block(addr));
		if(page != null){
			page.getData().incCount();
			storage.moveToBack(page.getData());
			return true;
		}else{
			if(isFull())
				storage.removeFirst();
			storage.add(new Block(addr));
			return false;
		}
	
	}


	//return a string representing all items in cache
	// - follow the order from LFU to MFU
	// - if there is a tie, items should be included from LRU to MRU
	//return an empty string if cache is empty
	//O(n) where n is the number of items in cache
	@Override
	public String toString(){
		//default return; update or change as needed
		return storage.listToString();

	}



}