
public class MyList_Array<T> implements MyList<T> {
  
  private T[] list;
  
  private int ArraySize, capacity;
  
  public MyList_Array() {
    capacity = 1000000;
    ArraySize = 0;
  }
  
  public MyList_Array(int capacity) {
    this.capacity = capacity;
    this.ArraySize = 0;
    list = (T[]) new Object[capacity];
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
      ArraySize++;
    }
    
    return true;
    
  }
  
  public boolean add(T o) {

	if(ArraySize <= capacity) {
      list[ArraySize] = o;
      ArraySize+=1;
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
    
    if(ArraySize == 0) {
      return false;
    }
    else {
      for(int i = ArraySize; i > 0; i--) {
        this.remove(i);
      }
      ArraySize = 0;
      return true;
    }
    
  }
  
  public boolean contains(T o) {
    
    String search = "";
    if(((MyList) o).contains(search)) {
      System.out.println(o);
      return true;
    }
    return false;
  }
  
  public T get(int index) {
    
    return list[index];
    
  }
  
  public int indexOf(T o) {
    
    return (int) this.get(indexOf(o));
    
  }
  
  public boolean isEmpty() {
    
    if(ArraySize != 0) {
      return false;
    }
    
    return true;
    
  }
  
  public T remove(int index) {
    
    if(index < 0 || index > capacity) {
      System.out.println("Bad Index.");
    }
    else if(index == capacity) {
      ArraySize--;
    }
    
    else {
      if (this.capacity == this.ArraySize) {
        ArraySize--;
      }
      
      for (int i = ArraySize; i > index; i--) {
        this.list[i] = this.list[i - 1];
      }
      
    }
    
    ArraySize--;
    return this.remove(index);
  }
  
  public T remove(T o) {
    
    ArraySize--;
    return this.remove(o);
    
  }
  
  public boolean set(int index, T o) {
    
    return true;
    
  }
  
  public int size() {
    
    return capacity;
    
  }
  
  public MyList subList(int fromIndex, int toIndex) {
//    
//    int subListSize = (toIndex - fromIndex);
//    MyList innerList = new Object[subListSize];
//    
//    if(fromIndex < 1 || fromIndex > capacity || 
//        toIndex < 1 || toIndex > capacity || fromIndex > toIndex) {
//      System.out.println("Indices Provided are Invalid.");
//      return null;
//    }
//    
//    else {
//      for(int i = 0; i < subListSize; i++) {
//        innerList[i] = (list[fromIndex + i]);
//      }
//    
//  }
//    
    return null;
}
  
  public T[] toArray() {
    
    T[] array = (T[])new Object[this.size()];
    
    for (int i = 0; i < this.size(); i++) {
      array[i] = list[i];
    }
    return array;
  }
  
  public boolean swap(int position1, int position2) {
    
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
      
      System.out.println("Invalid Indecies Provided.");
      return false;
    }
    else {
      
      for(int i = 0; i < greater; i++) {
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
  
  public boolean shift(int positions) {
    
    if(positions > size()) {
      return false;
    }
    
    else if (positions == 0 || positions == size()) {
      return true;
    }
    else if(positions > 0) {
      for (int i = ArraySize; i > positions; i--) {
        this.list[i] = this.list[i - 1];
      }
      return true;
    } else {
      for (int i = ArraySize; i < positions; i++) {
        this.list[i] = this.list[i + 1];
      }
      return true;
    }
  }
    
}
  