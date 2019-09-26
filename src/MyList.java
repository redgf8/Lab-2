/**
 * Interface for list implementations to utilize
 */
public interface MyList<T> {
	
	boolean add(int index, T o);
	
	boolean add(T o);
	
	boolean clear();
	
	boolean contains(T o);
	
	T get(int index);
	
	int indexOf(T o);
	
	boolean isEmpty();
	
	T remove(int index);
	
	T remove(T o);
	
	boolean set(int index, T element);
	
	int size();
	
	MyList subList(int fromIndex, int toIndex);
	
	T[] toArray();
	
	boolean swap(int position1, int position2);
	
	boolean shift(int positions);
		
}
