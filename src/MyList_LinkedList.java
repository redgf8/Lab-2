
public class MyList_LinkedList<T> implements MyList<T> {
  
  private Node<T> head;
  private int size = 0;
  
  //create a new linked list
  public MyList_LinkedList() {
    
    this.setHead(null);
    
  }
  
  //set the head node of the current linked list
  public void setHead(Node<T> newHead) {
    
    this.head = newHead;
    
  }
  
  //return the head node of the current linked list
  public Node<T> getHead() {
    
    return this.head;
    
  }
  
  //set the size of the current linked list
  public void setSize(int newSize) {
    
    this.size = newSize;
    
  }
  
  //return the size of the current linked list
  public int getSize() {
    
    return this.size;
    
  }

  //add a new object to the current linked list at the specified index
  public boolean add(int index, T o) {

    if (index == (this.getSize() + 1)) { //if index specified is the end of the list
      
      this.add(o);
      return true;
      
    } else if (index < 1 || index > this.getSize()) { //if index specified is invalid
      
      System.out.println("Error: Invalid index value specified in add method of MyList_LinkedList.");
      return false;
      
    } else {
    
      Node<T> newNode = new Node<T>(o);
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData(this.getHead().getData());
      this.setHead(currentNode);
      Node<T> nextNode = new Node<T>(null);
      
      if (index == 1) { //if adding at the head of the current linked list

        newNode.setNext(currentNode);
        this.setHead(newNode);
        this.setSize(this.size() + 1);
        return true;
        
      } else {
        
        for (int i = 0; i < (index - 2); i++) { //find the object before the specified index and insert the new object
          
          currentNode = currentNode.getNext();
        
        }
        
        nextNode = currentNode.getNext();
        newNode.setNext(nextNode);
        currentNode.setNext(newNode);
        this.setSize(this.size() + 1);
        return true;
        
      }
      
    }
    
  }

  //add a new object to the end of the current linked list
  public boolean add(T o) {
    
    Node<T> newNode = new Node<T>(o);
    
    if (this.getHead() == null) { //if object being added is the first to be added to current linked list
      
      this.setHead(newNode);
      this.setSize(1);
      
    } else { //else add to end of current linked list
      
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData(this.getHead().getData());
      this.setHead(currentNode);
      for (int i = 0; i < (this.getSize() - 1); i++) {
        
        currentNode = currentNode.getNext();
        
      }
      currentNode.setNext(newNode);
      this.setSize(this.getSize() + 1);
      
    }
    
    return true;
    
  }

  //clear the current linked list
  public boolean clear() {
    
    this.setHead(null);
    this.setSize(0);
    return true;
    
  }

  //return if the specified object is contained in the current linked list
  public boolean contains(T o) {

    Song currentSong = new Song("", "", 0);
    Song newSong = new Song ("", "", 0);
    newSong = (Song) o;
    Node<T> currentNode = new Node<T>(null);
    currentNode.setNext(this.getHead().getNext());
    currentNode.setData(this.getHead().getData());
    
    for (int i = 0; i < this.getSize(); i++) { //loop through until specified object is found or end of list is reached
      
      currentSong = (Song) currentNode.getData();
      if (currentSong.getSongName().toLowerCase().equals(newSong.getSongName().toLowerCase())
          && currentSong.getArtist().toLowerCase().equals(newSong.getArtist().toLowerCase())) {
        
        return true;
        
      }
      currentNode = currentNode.getNext();
      
    }
    
    return false;
    
  }

  //return the object at the specified index of current linked list
  public T get(int index) {

    if (this.isEmpty() == true) { //check for empty list
      
      System.out.println("Error: Playlist is empty.");
      return null;
      
    } else {
      
       if (index < 1 || index > this.getSize()) { //if index specified is invalid
        
        System.out.println("Error: Invalid index value specified in get method of MyList_LinkedList.");
        return null;
        
      } else {
      
        Node<T> currentNode = new Node<T>(null);
        
        for (int i = 0; i < index; i++) {
        
          if (i == 0) {
            
            currentNode.setNext(this.getHead().getNext());
            currentNode.setData(this.getHead().getData());
            
          } else {
            
            currentNode = currentNode.getNext();
            
          }
        
        }
        
        return (T) currentNode.getData();
      
      }
    
    }
    
  }

  //return the index of the specified object in current linked list
  public int indexOf(T o) {
    
    Node<T> currentNode = new Node<T>(null);
    currentNode.setNext(this.getHead().getNext());
    currentNode.setData(this.getHead().getData());
    
    for (int i = 0; i < this.getSize(); i++) {
    
      if (currentNode.getData() == o) {
        
        return (i + 1);
        
      } else {
        
        currentNode = currentNode.getNext();
        
      }
      
    }
    
    return -1;
    
  }
  
  //return if the current linked list is empty
  public boolean isEmpty() {

    if (this.getHead() == null) {
      
      return true;
      
    } else {
      
      return false;
    
    }
  }

  //remove the object at specified index in current linked list
  public T remove(int index) {

    if (index < 1 || index > this.getSize()) { //if specified index is invalid
      
      System.out.println("Error: Invalid index value specified in remove method of MyList_LinkedList.");
      return null;
      
    } else {
      
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData(this.getHead().getData());
      this.setHead(currentNode);
      Node<T> nextNode = new Node<T>(null);
      
      if (index == 1) { //if removing the head
        
        nextNode = currentNode.getNext();
        this.setHead(nextNode);
        this.setSize(this.getSize() - 1);
        return (T) currentNode.getData();
        
      } else {
        
        for (int i = 0; i < (index - 2); i++) { //find the index before the specified index and remove the specified index
          
          currentNode = currentNode.getNext();
        
        }
        
        nextNode = currentNode.getNext();
        currentNode.setNext(nextNode.getNext());
        this.setSize(this.getSize() - 1);
        return (T) nextNode.getData();
        
      }
      
    }
    
  }

  //remove the object specified from current linked list
  public T remove(T o) {
    
    Node<T> currentNode = new Node<T>(null);
    currentNode.setNext(this.getHead().getNext());
    currentNode.setData(this.getHead().getData());
    Node<T> nextNode = new Node<T>(null);
    int index = 0;
    
    for (int i = 0; i < this.getSize(); i++) { //loop through until object is found or end of list is reached
      
      
      if (currentNode.getData() == o) { //if specified object is found

        index = i;
        break;
        
      } else if (i == this.getSize()){ //if specified object is not found
        
        System.out.println("Error: Specified song to remove is not present in LinkedList_Playlist.");
        return null;
        
      }
      
      currentNode = currentNode.getNext();
      
    }
    
    currentNode = this.getHead();
    
    if (index == 0) { //if removing the head
      
      nextNode = currentNode.getNext();
      this.setHead(nextNode);
      this.setSize(this.getSize() - 1);
      return (T) nextNode.getData();
      
    } else {
    
      for (int i = 0; i < (index - 1); i++) {
      
        currentNode = currentNode.getNext();
    
      }
    
      nextNode = currentNode.getNext();
      currentNode.setNext(nextNode.getNext());
      this.setSize(this.getSize() - 1);
      return (T) nextNode.getData();
    
    }
    
  }

  //set the specified index of current linked list to specified object
  public boolean set(int index, T element) {

    if (index < 1 || index > this.getSize()) { //if specified index is invalid
      
      System.out.println("Error: Invalid index value specified in set method of MyList_LinkedList.");
      return false;
      
    } else {
      
      Node<T> newNode = new Node<T>(element);
      Node<T> currentNode = new Node<T>(null);
      Node<T> nextNode = new Node<T>(null);
      
      for (int i = 0; i < (index - 1); i++) { //loop to specified index and change data
      
        if (i == 0) {
          
          currentNode.setNext(this.getHead().getNext());
          currentNode.setData(this.getHead().getData());
          
        } else {
          
          currentNode = currentNode.getNext();
          
        }
      
      }
      
      nextNode = currentNode.getNext();
      currentNode.setNext(newNode);
      newNode.setNext(nextNode.getNext());
      return true;
    
    }

  }

  //return the size of current linked list
  public int size() {
    
    return this.getSize();
    
  }

  //return a sublist containing items in current linked list from specified index to specified index
  public MyList<T> subList(int fromIndex, int toIndex) {

    if (this.isEmpty() == true) { //if playlist is empty
      
      System.out.println("Error: Playlist is empty.");
      return null;
      
    } else {
      
      if (fromIndex < 1 || fromIndex > this.getSize() || toIndex < 1 || toIndex > this.getSize()) { //if either specified index is invalid
        
        System.out.println("Error: Invalid index value specified in subList method of MyList_LinkedList.");
        return null;
        
      } else if (fromIndex > toIndex){ //if second specified index is before first
        
        System.out.println("Error: Invalid 'to' index value specified in subList method of MyList_LinkedList.");
        return null;
        
      } else {
        
        MyList_LinkedList<T> newList = new MyList_LinkedList<T>();
        Node<T> currentNode = new Node<T>(null);
        Node<T> newNode = new Node<T>(null);
        currentNode.setNext(this.getHead().getNext());
        currentNode.setData(this.getHead().getData());
        
        for (int i = 0; i < toIndex; i++) {
          
          if (i == (fromIndex - 1)) {
            
            newList.setHead(currentNode);
            
          } else {
            
            if (i == (toIndex - 1)) {
              
              newNode.setData(currentNode.getData());
              newNode.setNext(null);
              
            }
            
            newList.add((T) newNode);
            
          }
          
          currentNode = currentNode.getNext();
          
        }
        
        return newList;
      
     }
    
   }

 }

  //return a new array containing the elements of current linked list
  public T[] toArray() {

    if (this.isEmpty() == true) { //if playlist is empty
      
      System.out.println("Error: Playlist is empty.");
      return null;
      
    } else {
      
      T[] llArray = (T[])new Object[this.getSize()];
      Node<T> currentNode = new Node(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData((T) this.getHead().getData());
      
      for (int i = 0; i < this.getSize(); i++) { //loop through to end of list and add to new array
        
        llArray[i] = currentNode.getData();
        currentNode = currentNode.getNext();
        
      }
      
      return llArray;
      
    }
    
    
    
  }

  //swap the data in two specified postions of current linked list
  public boolean swap(int position1, int position2) {

    if (position1 < 1 || position1 > this.getSize() || position2 < 1 || position2 > this.getSize()) { //if either specified index is invalid
      
      System.out.println("Error: Invalid index value specified in swap method of MyList_LinkedList.");
      return false;
      
    } else if (position2 <= position1){ //if second specified index is before first
      
      System.out.println("Error: Invalid 'position2' index value specified in swap method of MyList_LinkedList.");
      return false;
      
    } else {
      
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData(this.getHead().getData());
      Node<T> pos1Node = new Node<T>(null);
      Node<T> pos2Node = new Node<T>(null);
      
      for (int i = 0; i < position2; i++) { //loop until second position is reached
        
        if (i == (position1 - 1)) { //if first position is found
          
          pos1Node.setData(currentNode.getData());
          pos1Node.setNext(currentNode.getNext());
          
        } else if (i == (position2 - 1)) { //if second position is found
          
          pos2Node.setData(currentNode.getData());
          pos2Node.setNext(currentNode.getNext());
          
        }
        currentNode = currentNode.getNext();
        
      }
      
      currentNode = this.getHead();
      this.setHead(currentNode);
      
      for (int i = 0; i < (position2 - 1); i++) { //swap values
        
        if (i == (position1 - 1)) {
          
          currentNode.setData(pos2Node.getData());
          
        }
        
        currentNode = currentNode.getNext();
        
      }
      
      currentNode.setData(pos1Node.getData());
      return true;
      
    }
    
  }

  //shift all elements in current linked list by specified number of indexes
  public boolean shift(int positions) {

    if (Math.abs(positions) > this.getSize()) { //if specified index is invalid
      
      System.out.println("Error: Invalid number of positions specified in shift method of MyList_LinkedList.");
      return false;
      
    } else {
      
      if (positions == 0 || Math.abs(positions) == this.getSize()) { //if index is valid but shifting would result in same list as current
        
        return true;
        
      } else {
        
        Node<T> tailNode = new Node<T>(null);
        Node<T> currentNode = new Node<T>(null);
        tailNode.setNext(this.getHead().getNext());
        tailNode.setData(this.getHead().getData());
        this.setHead(tailNode);
        int max = 0;
        
        if (positions < 0) { //move to the left
          
          positions = Math.abs(positions);
          max = positions;
          
        } else { //move to the right
          
          max = (this.getSize() - positions);
          
        }
          
        for (int i = 0; i < (this.getSize() - 1); i++) { //find old tail
          
          tailNode = tailNode.getNext();
          
        }
        
        tailNode.setNext(this.getHead());
        currentNode.setNext(this.getHead().getNext());
        currentNode.setData(this.getHead().getData());
        this.setHead(currentNode);
        
        for (int i = 0; i < max; i++) { //find new head
          
          currentNode = currentNode.getNext();
          
        }
        
        this.setHead(currentNode);
        currentNode = null;
        currentNode = this.getHead();
        this.setHead(currentNode);
        
        for (int i = 0; i < (this.getSize() - 1); i++) {
          
          currentNode = currentNode.getNext(); //find new tail
          
        }
        
        currentNode.setNext(null);
      
      return true;
      
      }
    
    }

  }
  
}