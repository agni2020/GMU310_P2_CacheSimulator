// TO DO: add your implementation and JavaDocs.

// ONLY need to implement these THREE METHODS: put(), get(), and delete()
// Keep other code AS IS but you will need to add JavaDocs

import java.util.Iterator;


/**
 * Basic map with seperate chaining methodology.
 * @param <K> represents the key.
 * @param <V> represents the value.
 */
public class BasicMap<K, V> {
	
	//******************************************************
	//*******     BELOW THIS LINE IS PROVIDED code   *******
	//*******             Do NOT edit code!          *******
	//*******		   Remember to add JavaDoc		 *******
	//******************************************************

	/**
	 * each entry of the hash map would be a &lt;key, value&gt; pair, key of type K and value of type V.
	 */
	private class Pair {

		/**
		 * Key object that keys the value.
		 */
		private K key;
		/**
		 * Value object to hold value.
		 */
		private V value;

		/**
		 * Constructor to create the Pair object.
		 * @param key represents the key.
		 * @param value represents the value.
		 */
		public Pair(K key, V value){
			this.key = key;
			this.value = value;
		}
		public K getKey(){ return key; }
		public V getValue(){ return value; }
		public void setValue(V value){ this.value = value; }

		@Override
		public String toString(){
			return "<"+key.toString()+":"+value.toString()+">";
		}

		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object o) {
			// return true if two pairs have matching keys
			// i.e. <"Alice", 1> is considered as equal to <"Alice", 2>
			if(o instanceof BasicMap<?,?>.Pair) {
				Pair pair = (Pair)o;
				return pair.key.equals(key);  
			}
			return false;
		}

		@Override
		public int hashCode(){
			return key.hashCode();
		}
		
	}

	/**
	 * This hash map implementation uses an array of BasicList where each list will be composed of Node&lt;Pair&gt;.
	 */
	private BasicList<Pair>[] buckets;


	/**
	 * will fix the capacity to 7.
	 */
	final static private int DEFAULT_CAPACITY = 7;

	/**
	 * track how many elements in HashMap.
	 */
	private int size;

	/**
	 * Constructor to create the map.
	 */
	@SuppressWarnings("unchecked")
	public BasicMap() {
		buckets = (BasicList<Pair>[])new BasicList[DEFAULT_CAPACITY];
		size = 0;
	}


	/**
	 * Size of the map.
	 * @return size of the map.
	 */
	public int size() {
		return size;
	}

	/**
	 * To find the capacity to the map.
	 * @return integer value.
	 */
	private int capacity() {
		return buckets.length;
	}

	/**
	 * Absolute hash code if the key.
	 * @param key to find hashcode.
	 * @return hashcode of the key.
	 */
	private int getHash(K key) {
		return Math.abs(key.hashCode());
	}


	/**
	 * String representation of map.
	 * @return string value.
	 */
	public String toStringDebug() {
		//print all entries of buckets, including null ones
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<buckets.length; i++) {		
			BasicList<Pair> list = buckets[i];	
			sb.append("[");	
			if (list != null) {
				sb.append(list.listToString());
			}
			sb.append("]");
			if (i!=buckets.length-1)
				sb.append(",");	  

		}
		return "{" + sb.toString() + "}";
	}

	@Override
	public String toString() {
		//only display non-null entries of buckets
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<buckets.length; i++) {		
			BasicList<Pair> list = buckets[i];	
			if (list != null) {
				if (sb.length()>0)
					sb.append(",");	 
				sb.append(list.listToString());
			}
		}
		return sb.toString();
	}

	//******************************************************
	//*******     BELOW THIS LINE IS YOUR CODE       *******
	//******************************************************
	// ADD PRIVATE METHODS HERE IF NEEDED!
	// YOU CANNOT ADD MORE DATA MEMBERS

	/**
	 * mapping key to value in the hashmap.
	 * @param key hashcode of the object/bucket
	 * @param value value to be sored in bucket.
	 */
	public void put(K key, V value) {
		// mapping key to value in the hashmap
		// - throws IllegalArgumentException for null key or null value (with any error msg)
		if(key == null){
			throw new IllegalArgumentException("Key cannot be null");
		}
		// - if key is new, add a new entry (key, value)
		int hashIndex = getHashIndex(key);
		if(buckets[hashIndex] == null){
			buckets[hashIndex] = new BasicList<>();;
		}

		// - if key is present, make sure (key, value) is the only mapping of key in hashtable
		BasicList<Pair> pairList = buckets[hashIndex];
		Iterator<Pair> pairListItr =  pairList.iterator();

		while (pairListItr.hasNext()){
			Pair pair = pairListItr.next();
			if(pair.getKey().equals(key)){
				pair.setValue(value);
				return;
			}
		}
		pairList.addLast(new Pair(key, value));
		size++;
		// Note: Implement the hash table with separate chaining.
		// - when a new (key,value) pair is added, add it to the end of the chain
		// - if key is already present, you should just change its mapping. 
		//    do not remove the key then add it back, which is less efficient.
		
		// O(load) on average, and O(n) worst case
    }

	/**
	 * Computes the hashIndex of given key.
	 * @param key to compute.
	 * @return hashIndex according to capacity.
	 */
	private int getHashIndex(K key) {
		return Math.abs(key.hashCode() % DEFAULT_CAPACITY);
	}

	/**
	 * Return value related to given key.
	 * @param key of the object.
	 * @return value corresponding to key.
	 */
	public V get(K key) {
		// if key is null or not present, return null
		if(key == null || buckets[getHashIndex(key)] == null){
			return null;
		}
		// return the current mapping of key
		BasicList<Pair> pairList = buckets[getHashIndex(key)];
		Iterator<Pair> pairListItr =  pairList.iterator();

		while (pairListItr.hasNext()){
			Pair pair = pairListItr.next();
			if(pair.getKey().equals(key)){
				return pair.value;
			}
		}

		// O(load) on average, and O(n) worst case

		//default return, remove or update as needed
		return null;
	}

	/**
	 * Deletes the item with key.
	 * @param key to be deleted.
	 * @return corresponding value
	 */
	public V delete(K key){

		// if key is null or not present, return null
		if(key == null || buckets[getHashIndex(key)] == null){
			return null;
		}
		// return the current mapping of key from hashmap and delete it
		// return the current mapping of key
		BasicList<Pair> pairList = buckets[getHashIndex(key)];
		Iterator<Pair> pairListItr =  pairList.iterator();

		Pair nodeToDelete = null;

		while (pairListItr.hasNext()){
			Pair pair = pairListItr.next();
			if(pair.getKey().equals(key)){
				nodeToDelete = pair;
				break;
			}
		}
		if(nodeToDelete != null){
			pairList.remove(nodeToDelete);
			size--;
			return nodeToDelete.getValue();
		}
		// O(load) on average, and O(n) worst case
	
		//default return, remove or update as needed
		return null;
	
	
	}
	
	//******************************************************
	//*******     BELOW THIS LINE IS TESTING CODE    *******
	//*******      Edit it as much as you'd like!    *******
	//*******		Remember to add JavaDoc			 *******
	//******************************************************

	/**
	 * Main method to test BasicMap.
	 * @param args CLI Arguments.
	 */
	public static void main(String args[]) {
		BasicMap<String, String> map = new BasicMap<>();
		
		map.put("apple", "red");
		map.put("pear", "yellow");
		map.put("eggplant", "purple");
		
		if (map.get("apple").equals("red") && map.get("eggplant").equals("purple") && map.size() == 3){
			System.out.println("Yay1");
		}
		
		//change mapping, delete
		map.put("apple", "green");
		if (map.get("apple").equals("green") && map.size()==3 && map.delete("pear").equals("yellow") 
			&& map.size() == 2) {
			System.out.println("Yay2");
		}
		
		//key not present
		if (map.get("banana")==null && map.delete("pear")==null){
			System.out.println("Yay3");		
		}
		
		//add to tail
		map.put("cherry", "red");
		if (map.toStringDebug().equals("{[],[<apple:green> <cherry:red>],[],[],[],[<eggplant:purple>],[]}")){
			System.out.println("Yay4");		
		}
		
	}

}