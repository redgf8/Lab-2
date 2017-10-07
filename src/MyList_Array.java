
public class MyList_Array<T> implements MyList {
	
	private T[] list;
	
	private int MaxCapacity, CurrentSize;
	
	public MyList_Array() {
		MaxCapacity = 10;
		list = (T[]) new Object[MaxCapacity];
	}
	
	public boolean add(int index, T o) {
		
		if(index < 0 || index > MaxCapacity) {
			System.out.println("Bad Index.");
			return false;
		}
		else if(index == MaxCapacity) {
			this.add(o);
		}
		
		else {
			if (this.CurrentSize == this.MaxCapacity) {
				System.out.println("List Full.");
				return false;
			}
			
			for (int i = MaxCapacity; i > index; i--) {
				this.list[i] = this.list[i - 1];
			}
			
			this.list[index] = o;
		}
		
		return true;
		
	}
	
	public boolean add(T o) {
		
		
		if(CurrentSize < MaxCapacity) {
			list[CurrentSize] = o;
			CurrentSize++;
			return true;
		}
		
		else {
			System.out.println("List Full");
			return false;
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
		
		if(CurrentSize != 0) {
			return false;
		}
		
		return true;
		
	}
	
	public T remove(int index) {
		
		if(index < 0 || index > MaxCapacity) {
			System.out.println("Bad Index.");
		}
		else if(index == MaxCapacity) {
			CurrentSize--;
		}
		
		else {
			if (this.CurrentSize == this.MaxCapacity) {
				CurrentSize--;
			}
			
			for (int i = MaxCapacity; i > index; i--) {
				this.list[i] = this.list[i - 1];
			}
			
		}
		
		return this.remove(index);
	}
	
	public T remove(T o) {
		
		CurrentSize--;
		return this.remove(o);
		
	}
	
	public boolean set(int index, T o) {
		
		return true;
		
	}
	
	public int size() {
		
		return CurrentSize;
		
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
