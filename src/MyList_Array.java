
public class MyList_Array<T> implements MyList<T> {
  
  private T[] list;
  private int ArraySize, capacity;
  
  public MyList_Array() { //constructs the array and allocates the size
    capacity = 1000000; //Size of the array
    ArraySize = 0; //Total number of objects in the array, used to keep track of indices
    list = (T[]) new Object[capacity]; //creates a generic array of 1 million
  }
  
  private void reallocate() { //makes more space in the array
    this.capacity *= 2; //Doubles the size of the array
    T[] newList = (T[])new Object[this.capacity]; //creates a new generic array of double the previous list size
    for(int i = 0; i < this.ArraySize; i++) {
      newList[i] = list[i]; //Populates the new array with the original elements
    } 
    this.list = newList; //redefining list to equal the larger newList
  }
  
  public boolean add(int index, T o) { //Add a specific object to a specific index
    
    if(index < 0 || index > capacity) { //returns false if the provided index is negative o
      System.out.println("Bad Index.");
      return false;
    }
    else if(index == capacity){ //adds object to the end of the list
      this.add(o);
      return true;
    } else {
      if (this.capacity == this.ArraySize) { //resizes the list if the list is full
        System.out.println("List Full: Reallocating");
        this.reallocate();
        return true;
      }
      for (int i = ArraySize; i > index; i--) {
        this.list[i] = this.list[i - 1];
        return true;
      }
      this.list[index] = o; 
      ArraySize++; //assigns an object to an index and increases the array size by one
    }
    return true;
  }
  
  public boolean add(T o) { //adds a specified object to the array
	if(ArraySize < capacity) {
      list[ArraySize] = o;
      ArraySize++; //assigns an object to an index and increases the array size by one
      return true;
   }else {
      System.out.println("List Full: Reallocating");
      this.reallocate();
      this.add(o); //resizes the list if the list is full and adds the object
      return true;
    }
  }
  
  public boolean clear() { //empties the list
    
    if(ArraySize == 0) { //returns false if there are no elements in the list
      return false;
   }else {
      for(int i = ArraySize; i > 0; i--) {
        this.remove(i); //removes each item in the list, one by one
      }
      ArraySize = 0; //sets array size to 0
      return true;
    } 
  }
  
  public boolean contains(T o) { 
    for(int i = 0; i < ArraySize; i++) {
	  if(list[i] == o){
		   System.out.println(o.toString()); //prints the objects info if it is in the list
	  }
	  return true;
    }
    return false;
  }
  
  public T get(int index) {
    return list[index]; //returns the object at the index specified
  }
  
  public int indexOf(T o) {
    return (int) this.get(indexOf(o)); //returns the index of a specified object
  }
  
  public boolean isEmpty() {
    if(ArraySize != 0) { //returns false if there is at least 1 element in the list
      return false;
    }
    return true;
  }
  
  public T remove(int index) {
    if(index < 0 || index > capacity) {
      System.out.println("Bad Index."); //prints to the console if the index is negative or over 1 million
    }
    else if(index == capacity) { //removes the object from the end of the list and decreases list size
      ArraySize--;
   }else {
      if (this.capacity == this.ArraySize) { //removes last element from the list
        ArraySize--;
      }
      for (int i = ArraySize; i > index; i--) {
        this.list[i] = this.list[i - 1]; //moves elements to fill the gap
      }
   }
    ArraySize--;
    return this.remove(index); //decrease array size and removes specified index
  }
  
  public T remove(T o) { //removes specified object and decreases array size
    ArraySize--;
    return this.remove(o);
  }
  
  public boolean set(int index, T o) { //sets values for an object at a specified index
    return true;
  }
  
  public int size() { //returns max capacity of the list
    return capacity;
  }
  
  public MyList subList(int fromIndex, int toIndex) { //creates a list between two specific indices from the original list
    int subListSize = (toIndex - fromIndex);
    T[] innerList = (T[])new MyList[subListSize];
    if(fromIndex < 1 || fromIndex > capacity || 
        toIndex < 1 || toIndex > capacity || fromIndex > toIndex) { //returns null if indices provided are invalid
      System.out.println("Indices Provided are Invalid.");
      return null;
   }else {
      for(int i = 0; i < subListSize; i++) {
        innerList[i] = (list[fromIndex + i]); //populates the subList with items between the specified indices of the original list
      }
  }
    return null;
}
  
  public T[] toArray() { //creates and populates a new array, identical to the first
    T[] array = (T[])new Object[this.size()];
    for (int i = 0; i < this.size(); i++) {
      array[i] = list[i];
    }
    return array;
  }
  
  public boolean swap(int position1, int position2) { //takes positions of two objects in a list and switches them
    int placeholder = 0;
    int greater = 0;
    T[] array = (T[])new Object[this.size()];
    
    if(position1 > position2) {
      greater = position1;
    } else {
      greater = position2;
    }
    if (position1 < 1 || position1 > this.size() || 
        position2 < 1 || position2 > this.size()) {
      System.out.println("Invalid Indecies Provided."); //prints if the indices are greater than the list size or less than 1
      return false;
   }else {
      for(int i = 0; i < greater; i++) { //assigns variables to different values with temporary values to assist
        if(i == position1) {
          placeholder = position2;
          position2 = position1;
          position1 = placeholder;
          placeholder = 0;
          greater = 0;
        }
        else if(i == position2) {
          placeholder = position1;
          position1 = position2;
          position2 = placeholder;
          placeholder = 0;
          greater = 0;
        }
      }
      return true;
    }
  }
  
  public boolean shift(int positions) { //moves elements in the list by a specific amount 
    if(positions > size()) {
      return false;
    }
    else if (positions == 0 || positions == size()) {
      return true;
   }else {
    	for(int i = (size()-1); i > 0; i--) {
    		T temp = (T) list[i];
    		list[i] = list[i-1];
    		list[i-1] = temp;
    	}
    	return true;
     }
  }
    
}
  