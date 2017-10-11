
public interface MyList<T> {
	
	boolean add(int index, T o); //Adds a Song object at a specified index
	
	boolean add(T o); //Adds a Song object to the Array
	
	boolean clear(); //Removes all items from the Array
	
	boolean contains(T o); //Compares an object in the Array to search criteria
	
	T get(int index); //Returns an index
	
	int indexOf(T o); //Returns the index of a specified object
	
	boolean isEmpty(); //Checks the Array for any objects
	
	T remove(int index); //Removes an object at an index form the Array
	
	T remove(T o); //Removes a specified object from the array
	
	boolean set(int index, T element); //sets an index for a specified object in the array list
	
	int size(); //Returns the size of the Array
	
	MyList subList(int fromIndex, int toIndex); //Creates a separate array using specified indices
	
	T[] toArray(); //Creates a new list using the original
	
	boolean swap(int position1, int position2); //changes two object's positions in an array 
	
	boolean shift(int positions); //Moves objects in an array to the left or right (positions) number of spaces
		
}
