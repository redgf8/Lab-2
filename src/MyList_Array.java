
public class MyList_Array<T> implements MyList {
	
	public T[] list;
	
	private int ArraySize, capacity;
	
	private static final int INITIAL_CAPACITY = 10;
	
	public MyList_Array() {
		capacity = INITIAL_CAPACITY;
		ArraySize = 0;
	}
	
	public MyList_Array(int MaxCapcity) {
		this.capacity = capacity;
		this.ArraySize = 0;
		list = (T[]) new Object[this.capacity];
	}
	
	private void reallocate() {
		this.capacity *= 2;
		
		T[] newList = (T[])new Object[this.capacity];
		for(int i = 0; i < this.ArraySize; i++) {
			newList[i] = list[i];
		}
		
		this.list = newList;
		
	}
	
	public boolean add(int index, T o) {
		
		if(index < 0 || index > ArraySize) {
			System.out.println("Bad Index.");
			return false;
		}
		else if(index == ArraySize){
			this.add(o);
			return true;
		}
		
		else {
			if (this.capacity == this.ArraySize) {
				System.out.println("List Full: Reallocating");
				this.reallocate();
				return true;
			}
			
			for (int i = ArraySize; i > index; i--) {
				this.list[i] = this.list[i - 1];
				return true;
			}
			
			this.list[index] = o;
			capacity++;
		}
		
		return true;
		
	}
	
	public boolean add(T o) {
		
		
		if(ArraySize < capacity) {
			list[ArraySize] = o;
			ArraySize++;
			return true;
		}
		
		else {
			System.out.println("List Full: Reallocating");
			this.reallocate();
			this.add(o);
			return true;
		}
	}
	
	public boolean clear() {
		
		
		
	}
	
	public boolean contains(T o) {
		
		
		
	}
	
	public T get(int index) {
		
		return list[index];
		
	}
	
	public int indexOf(T o) {
		
		return (int) this.get(indexOf(o));
		
	}
	
	public boolean isEmpty() {
		
		if(capacity != 0) {
			return false;
		}
		
		return true;
		
	}
	
	public T remove(int index) {
		
		if(index < 0 || index > ArraySize) {
			System.out.println("Bad Index.");
		}
		else if(index == ArraySize) {
			capacity--;
		}
		
		else {
			if (this.capacity == this.ArraySize) {
				capacity--;
			}
			
			for (int i = ArraySize; i > index; i--) {
				this.list[i] = this.list[i - 1];
			}
			
		}
		
		capacity--;
		return this.remove(index);
	}
	
	public T remove(T o) {
		
		capacity--;
		return this.remove(o);
		
	}
	
	public boolean set(int index, T o) {
		
		return true;
		
	}
	
	public int size() {
		
		return capacity;
		
	}
	
	public MyList subList(int fromIndex, int toIndex) {
		
		
		
	}
	
	public T[] toArray() {
		
		
		
	}
	
	boolean swap(int position1, int position2) {
		
		
		
	}
	
	boolean shift(int positions) {
		
		
		
	}
	
}
