//TODO: rework this class
public class MyList_CircularLinkedList<T> implements MyList<T> {
  
  private Node head;
  private Node tail;
  private int size = 0;
  
  //create a new circular linked list
  public MyList_CircularLinkedList() {
    
    Node<T> emptyNode = new Node<T> (null);
    
    this.setHead(null);
    this.setTail(null);
    
  }
  
  //set head of current list
  public void setHead(Node newHead) {
    
    this.head = newHead;
    
  }
  
  //return head of current list
  public Node getHead() {
    
    return this.head;
    
  }
  
  //set tail of current list
  public void setTail(Node newTail) {
    
    if (this.getHead() != null) { //if the list is not empty
      
      newTail.setNext(this.getHead());
      
    }
    
    this.tail = newTail;
    
  }
  
  //return tail of current list
  public Node getTail() {
    
    return this.tail;
    
  }
  
  //set size of current list
  public void setSize(int newSize) {
    
    this.size = newSize;
    
  }
  
  //get size of current list
  public int getSize() {
    
    return this.size;
    
  }

  //add specified object to current list at specified index
  public boolean add(int index, T o) {

    if (index == (this.getSize() + 1)) { //if index specified is the end of the list
      
      this.add(o);
      return true;
      
    } else if (index < 1 || index > this.getSize()) { //if index is invalid
      
      System.out.println("Error: Invalid index value specified in add method of MyList_CircularLinkedList.");
      return false;
      
    } else {
    
      Node<T> newNode = new Node<T>(o);
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData((T) this.getHead().getData());
      this.setHead(currentNode);
      Node<T> nextNode = new Node<T>(null);
      
      if (index == 1) { //if adding to head of list

        newNode.setNext(currentNode);
        this.setHead(newNode);
        this.setSize(this.size() + 1);
        return true;
        
      } else {
        
        for (int i = 0; i < (index - 2); i++) {
          
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
  
  //add a new object to the end of the current\ list
  public boolean add(T o) {
    
    Node<T> newNode = new Node<T>(o);
    
    if (this.getHead() == null) { //if object being added is the first to be added to current list
      
      this.setHead(newNode);
      this.setTail(this.getHead());
      this.getHead().setNext(this.getTail());
      this.setSize(1);
      
    } else { //else add to end of current linked list
      
      newNode.setNext(this.getHead());
      this.getTail().setNext(newNode);
      this.setTail(newNode);
      this.setSize(this.size() + 1);
      
    }
    
    return true;
    
  }

//clear the current list
  public boolean clear() {
    
    if (this.getHead() != null) {
      
      this.setHead(null);
      this.setTail(null);
      this.setSize(0);
      
    }
    
    return true;
    
  }
  
  //return if the specified object is contained in the current list
  public boolean contains(T o) {

    Song currentSong = new Song("", "", 0);
    Song newSong = new Song ("", "", 0);
    newSong = (Song) o;
    Node<T> currentNode = new Node<T>(null);
    currentNode.setNext(this.getHead().getNext());
    currentNode.setData((T) this.getHead().getData());
    
    for (int i = 0; i < this.getSize(); i++) {
      
      currentSong = (Song) currentNode.getData();
      if (currentSong.getName().toLowerCase().equals(newSong.getName().toLowerCase())
          && currentSong.getArtist().toLowerCase().equals(newSong.getArtist().toLowerCase())) {
        
        return true;
        
      }
      currentNode = currentNode.getNext();
      
    }
    
    return false;
    
  }

  //return the object at the specified index of current linked list
  public T get(int index) {

    if (index < 1 || index > this.getSize()) {
      
      System.out.println("Error: Invalid index value specified in get method of MyList_CircularLinkedList.");
      return null;
      
    } else if (index == this.getSize()) {
      
      return (T) this.getTail().getData();
      
    } else {
    
      Node<T> currentNode = new Node<T>(null);
      
      for (int i = 0; i < index; i++) {
      
        if (i == 0) {
          
          currentNode.setNext(this.getHead().getNext());
          currentNode.setData((T) this.getHead().getData());
          
        } else {
          
          currentNode = currentNode.getNext();
          
        }
      
      }
      
      return (T) currentNode.getData();
      
    }
    
  }

  //return the index of the specified object in current linked list
  public int indexOf(T o) {
    
    Node<T> currentNode = new Node<T>(null);
    currentNode.setNext(this.getHead().getNext());
    currentNode.setData((T) this.getHead().getData());
    
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

  //remove the object at specified index in current list
  public T remove(int index) {

    if (index < 1 || index > this.getSize()) {
      
      System.out.println("Error: Invalid index value specified in remove method of MyList_CircularLinkedList.");
      return null;
      
    } else {
      
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData((T) this.getHead().getData());
      this.setHead(currentNode);
      Node<T> nextNode = new Node<T>(null);
      
      if (index == 1) { // if removing the head
        
        nextNode = currentNode.getNext();
        this.setHead(nextNode);
        this.getTail().setNext(nextNode);
        this.setSize(this.getSize() - 1);
        return (T) nextNode.getData();
        
      } else if (index == this.getSize()) { //if removing the tail
          
        for (int i = 0; i < (this.getSize() - 2); i++) {
          
          currentNode = currentNode.getNext();
          
        }
        
        nextNode = this.getTail();
        currentNode.setNext(this.getHead());
        this.setTail(currentNode);
        this.setSize(this.getSize() - 1);
        return (T) nextNode.getData();
          
       } else {
        
        for (int i = 0; i < (index - 2); i++) {
          
          currentNode = currentNode.getNext();
        
        }
        
        nextNode = currentNode.getNext();
        currentNode.setNext(nextNode.getNext());
        this.setSize(this.getSize() - 1);
        return (T) nextNode.getData();
        
      }
      
    }
    
  }

//remove the object specified from current list
  public T remove(T o) {
    
    Node<T> currentNode = new Node<T>(null);
    currentNode.setNext(this.getHead().getNext());
    currentNode.setData((T) this.getHead().getData());
    Node<T> nextNode = new Node<T>(null);
    int index = 0;
    
    for (int i = 0; i < this.getSize(); i++) {
      
      
      if (currentNode.getData() == o) {

        index = i;
        break;
        
      } else if (i == this.getSize()){
        
        System.out.println("Error: Specified song to remove is not present in LinkedList_CircularPlaylist.");
        return null;
        
      }
      
      currentNode = currentNode.getNext();
      
    }
    
    currentNode = this.getHead();
    this.setHead(currentNode);
    
    if (index == 0) { //if removing the head
      
      nextNode = currentNode.getNext();
      this.setHead(nextNode);
      this.getTail().setNext(nextNode);
      this.setSize(this.getSize() - 1);
      return (T) nextNode.getData();
      
    } else if (index == (this.getSize() - 1)) { //if removing the tail
      
      for (int i = 0; i < (this.getSize() - 2); i++) {
        
        currentNode = currentNode.getNext();
        
      }
      
      nextNode = this.getTail();
      currentNode.setNext(this.getHead());
      this.setTail(currentNode);
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

   //set the specified index of current list to specified object
  public boolean set(int index, T element) {

    if (index < 1 || index > this.getSize()) {
      
      System.out.println("Error: Invalid index value specified in set method of MyList_CircularLinkedList.");
      return false;
      
    } else if (index == this.getSize()) {
      
      //test this code
      this.getTail().setData(element);
      return true;
      
    } else {
      
      Node<T> newNode = new Node<T>(element);
      Node<T> currentNode = new Node<T>(null);
      Node<T> nextNode = new Node<T>(null);
      
      for (int i = 0; i < (index - 1); i++) {
      
        if (i == 0) {
          
          currentNode.setNext(this.getHead().getNext());
          currentNode.setData((T) this.getHead().getData());
          
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

  //return the size of current list
  public int size() {
    
    return this.getSize();
    
  }

  //return a sublist containing items in current list from specified index to specified index
  public MyList<T> subList(int fromIndex, int toIndex) {

    if (fromIndex < 1 || fromIndex > this.getSize() || toIndex < 1 || toIndex > this.getSize()) {
      
      System.out.println("Error: Invalid index value specified in subList method of MyList_CircularLinkedList.");
      return null;
      
    } else if (fromIndex > toIndex){
      
      System.out.println("Error: Invalid 'to' index value specified in subList method of MyList_CircularLinkedList.");
      return null;
      
    } else {
      
      MyList_CircularLinkedList<T> newList = new MyList_CircularLinkedList<T>();
      Node<T> currentNode = new Node<T>(null);
      Node<T> newNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData((T) this.getHead().getData());
      int max = 0;
      
      for (int i = 0; i < toIndex; i++) {
        
        if (i == (fromIndex - 1)) {
          
          newList.setHead(currentNode);
          
        } else {
          
          if (i == (toIndex - 1)) {
            
            newNode.setData(currentNode.getData());
            newNode.setNext(newList.getHead());
            newList.setTail(newNode);
            
          }
          
          newList.add((T) newNode);
          
        }
        
        currentNode = currentNode.getNext();
        
      }
      
      return newList;
      
    }

  }

  //return a new array containing the elements of current list
  public T[] toArray() {

    T[] llArray = (T[])new Object[this.getSize()];
    Node<T> currentNode = new Node(null);
    currentNode.setNext(this.getHead().getNext());
    currentNode.setData((T) this.getHead().getData());
    
    for (int i = 0; i < this.getSize(); i++) {
      
      llArray[i] = currentNode.getData();
      currentNode = currentNode.getNext();
      
    }
    
    return llArray;
    
  }

  //swap the data in two specified postions of current list
  public boolean swap(int position1, int position2) {

    if (position1 < 1 || position1 > this.getSize() || position2 < 1 || position2 > this.getSize()) {
      
      System.out.println("Error: Invalid index value specified in swap method of MyList_CircularLinkedList.");
      return false;
      
    } else if (position2 <= position1){
      
      System.out.println("Error: Invalid 'position2' index value specified in swap method of MyList_CircularLinkedList.");
      return false;
      
    } else {
      
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData((T) this.getHead().getData());
      Node<T> pos1Node = new Node<T>(null);
      Node<T> pos2Node = new Node<T>(null);
      int max = 0;
      
      if (position2 == this.getSize()) {
        
        pos2Node = this.getTail();
        max = position1;
        
      } else {
        
        max = position2;
        
      }
      
      for (int i = 0; i < max; i++) {
        
        if (i == (position1 - 1)) {
          
          pos1Node.setData(currentNode.getData());
          pos1Node.setNext(currentNode.getNext());
          
        } else if (i == (position2 - 1)) {
          
          pos2Node.setData(currentNode.getData());
          pos2Node.setNext(currentNode.getNext());
          
        }
        currentNode = currentNode.getNext();
        
      }
      
      currentNode = this.getHead();
      this.setHead(currentNode);
      
      for (int i = 0; i < (position2 - 1); i++) {
        
        if (i == (position1 - 1)) {
          
          currentNode.setData(pos2Node.getData());
          
        }
        
        currentNode = currentNode.getNext();
        
      }
      
      currentNode.setData(pos1Node.getData());
      return true;
      
    }
    
  }

  //shift all elements in current list by specified number of indexes
  public boolean shift(int positions) {

    if (Math.abs(positions) > this.getSize()) {
      
      System.out.println("Error: Invalid number of positions specified in shift method of MyList_LinkedList.");
      return false;
      
    } else {
      
      if (positions == 0 || Math.abs(positions) == this.getSize()) {
        
        return true;
        
      } else {
        
        Node<T> tailNode = new Node<T>(null);
        Node<T> currentNode = new Node<T>(null);
        tailNode.setNext(this.getHead().getNext());
        tailNode.setData((T) this.getHead().getData());
        this.setHead(tailNode);
        int max = 0;
        
        if (positions < 0) { //move to the left
          
          positions = Math.abs(positions);
          max = positions;
          
        } else { //move to the right
          
          max = (this.getSize() - positions);
          
        }
        
        currentNode.setNext(this.getHead().getNext());
        currentNode.setData((T) this.getHead().getData());
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
        
        currentNode.setNext(this.getHead());
        this.setTail(currentNode);
      
      return true;
      
      }
    
    }

  }
  
}