
public class MyList_LinkedList<T> implements MyList<T> {
  
  private Node<T> head;
  private int size = 0;
  
  public MyList_LinkedList() {
    
    this.setHead(null);
    
  }
  
  public void setHead(Node<T> newHead) {
    
    this.head = newHead;
    
  }
  
  public Node<T> getHead() {
    
    return this.head;
    
  }
  
  public void setSize(int newSize) {
    
    this.size = newSize;
    
  }
  
  public int getSize() {
    
    return this.size;
    
  }

  public boolean add(int index, T o) {

    if (index == (this.getSize() + 1)) {
      
      this.add(o);
      return true;
      
    } else if (index < 1 || index > this.getSize()) {
      
      System.out.println("Error: Invalid index value specified in add method of MyList_LinkedList.");
      return false;
      
    } else {
    
      Node<T> newNode = new Node<T>(o);
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData(this.getHead().getData());
      this.setHead(currentNode);
      Node<T> nextNode = new Node<T>(null);
      
      if (index == 1) {

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

  public boolean add(T o) {
    
    Node<T> newNode = new Node<T>(o);
    
    if (this.getHead() == null) {
      
      this.setHead(newNode);
      this.setSize(1);
      
    } else {
      
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

  public boolean clear() {
    
    this.setHead(null);
    this.setSize(0);
    return true;
    
  }

  public boolean contains(T o) {

    Song currentSong = new Song("", "", 0);
    Song newSong = new Song ("", "", 0);
    newSong = (Song) o;
    Node<T> currentNode = new Node<T>(null);
    currentNode.setNext(this.getHead().getNext());
    currentNode.setData(this.getHead().getData());
    
    for (int i = 0; i < this.getSize(); i++) {
      
      currentSong = (Song) currentNode.getData();
      if (currentSong.getSongName().toLowerCase().equals(newSong.getSongName().toLowerCase())
          && currentSong.getArtist().toLowerCase().equals(newSong.getArtist().toLowerCase())) {
        
        return true;
        
      }
      currentNode = currentNode.getNext();
      
    }
    
    return false;
    
  }

  public T get(int index) {

    if (this.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      return null;
      
    } else {
      
       if (index < 1 || index > this.getSize()) {
        
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
  
  public boolean isEmpty() {

    if (this.getHead() == null) {
      
      return true;
      
    } else {
      
      return false;
    
    }
  }

  public T remove(int index) {

    if (index < 1 || index > this.getSize()) {
      
      System.out.println("Error: Invalid index value specified in remove method of MyList_LinkedList.");
      return null;
      
    } else {
      
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData(this.getHead().getData());
      this.setHead(currentNode);
      Node<T> nextNode = new Node<T>(null);
      
      if (index == 1) {
        
        nextNode = currentNode.getNext();
        this.setHead(nextNode);
        this.setSize(this.getSize() - 1);
        return (T) currentNode.getData();
        
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

  public T remove(T o) {
    
    Node<T> currentNode = new Node<T>(null);
    currentNode.setNext(this.getHead().getNext());
    currentNode.setData(this.getHead().getData());
    Node<T> nextNode = new Node<T>(null);
    int index = 0;
    
    for (int i = 0; i < this.getSize(); i++) {
      
      
      if (currentNode.getData() == o) {

        index = i;
        break;
        
      } else if (i == this.getSize()){
        
        System.out.println("Error: Specified song to remove is not present in LinkedList_Playlist.");
        return null;
        
      }
      
      currentNode = currentNode.getNext();
      
    }
    
    currentNode = this.getHead();
    
    if (index == 0) {
      
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

  public boolean set(int index, T element) {

    if (index < 1 || index > this.getSize()) {
      
      System.out.println("Error: Invalid index value specified in set method of MyList_LinkedList.");
      return false;
      
    } else {
      
      Node<T> newNode = new Node<T>(element);
      Node<T> currentNode = new Node<T>(null);
      Node<T> nextNode = new Node<T>(null);
      
      for (int i = 0; i < (index - 1); i++) {
      
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

  public int size() {
    
    return this.getSize();
    
  }

  public MyList<T> subList(int fromIndex, int toIndex) {

    if (this.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      return null;
      
    } else {
      
      if (fromIndex < 1 || fromIndex > this.getSize() || toIndex < 1 || toIndex > this.getSize()) {
        
        System.out.println("Error: Invalid index value specified in subList method of MyList_LinkedList.");
        return null;
        
      } else if (fromIndex > toIndex){
        
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

  public T[] toArray() {

    if (this.isEmpty() == true) {
      
      System.out.println("Error: Playlist is empty.");
      return null;
      
    } else {
      
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
    
    
    
  }

  public boolean swap(int position1, int position2) {

    if (position1 < 1 || position1 > this.getSize() || position2 < 1 || position2 > this.getSize()) {
      
      System.out.println("Error: Invalid index value specified in swap method of MyList_LinkedList.");
      return false;
      
    } else if (position2 <= position1){
      
      System.out.println("Error: Invalid 'position2' index value specified in swap method of MyList_LinkedList.");
      return false;
      
    } else {
      
      Node<T> currentNode = new Node<T>(null);
      currentNode.setNext(this.getHead().getNext());
      currentNode.setData(this.getHead().getData());
      Node<T> pos1Node = new Node<T>(null);
      Node<T> pos2Node = new Node<T>(null);
      
      for (int i = 0; i < position2; i++) {
        
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