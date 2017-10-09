
public interface MyList<T> {
	
	boolean addAt(int index, T o);
	
	boolean add(T o);
	
	boolean clear();
	
	boolean contains(T o);
	
	T get(int index);
	
	int indexOf(T o);
	
	boolean isEmpty();
	
	T removeAt(int index);
	
	T remove(T o);
	
	boolean set(int index, T o);
	
	int size();
	
	MyList subList(int fromIndex, int toIndex);
	
	T[] toArray();
	
	boolean swap(int position1, int position2);
	
	boolean shift(int positions);
		
}
