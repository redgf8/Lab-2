/**
 * Linked list class to implement the MyList interface and used in a playlist
 * @author Daniel Haluszka
 */
public class MyList_LinkedList<T> implements MyList<T> {

  private Node<T> head;
  private int size;

  /**
   * Constructor for a new empty linked list
   */
  public MyList_LinkedList() {

    this.size = 0;
    this.head = null;

  }

  /**
   * Constructor for a new linked list with specified head
   * @param head Node to be the head of the new linked list
   */
  public MyList_LinkedList(Node<T> head) {

    this.size = 1;
    this.head = head;

  }

  /**
   * Set the head of the current linked list
   * @param newHead Node to be the new head of the current linked list
   */
  public void setHead(Node<T> newHead) {

    this.head = newHead;

  }

  /**
   * Get the head node of the current linked list
   * @return Node head of the currnt linked list
   */
  public Node<T> getHead() {

    return this.head;

  }

  // size should be exclusively managed by the class
  /*public void setSize(int newSize) {
    
    this.size = newSize;
    
  }*/

  /**
   * Get the size of the current linked list
   * @return Int size of the current linked list
   */
  public int size() {

    return this.size;

  }

  /**
   * Add a new node to the end of the current linked list
   * @param o Object value of the new node
   * @return Boolean true if add was successful
   */
  public boolean add(T o) {

    Node<T> newNode = new Node<>(o);

    // check for adding to empty linked list
    if (this.size == 0) {

      this.setHead(newNode);
      this.size = 1;

    } else {

      Node<T> currNode = this.head;
      this.head = currNode;
      for (int i = 0; i < (this.size - 1); i++) {

        if (this.size > 1) currNode = currNode.getNext();

      }
      currNode.setNext(newNode);
      this.size++;

    }

    return true;

  }

  /**
   * Add a new node to the current linked list at the specified index
   * @param index Int index at which to add the new node
   * @param o Object value of the new node
   *    * @return Boolean true if add was successful
   */
  //add a new object to the current linked list at the specified index
  public boolean add(int index, T o) throws IndexOutOfBoundsException {

    // check for invalid index
    if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException("Invalid index specified to add new node");

    // check for adding to end of list
    if (index == (this.size)) return this.add(o);

    Node<T> newNode = new Node<T>(o);
    Node<T> currNode = this.head;
    this.head = currNode;
    Node<T> nextNode = new Node<T>(null);

    // check for adding at head
    if (index == 1) {

      newNode.setNext(currNode);
      this.head = newNode;
      this.size++;
      return true;

    } else {

      for (int i = 0; i < (index - 1); i++) {

        currNode = currNode.getNext();

      }

      nextNode = currNode.getNext();
      newNode.setNext(nextNode);
      currNode.setNext(newNode);
      this.size++;
      return true;

    }

  }

  /**
   * Make the current linked list empty
   * @return Boolean true when successful
   */
  public boolean clear() {

    this.head = null;
    this.size = 0;
    return true;

  }

  /**
   * Check if the current list contains the specified object
   * @param o Object to check the current linked list for
   * @return Boolean true if the current linked list contains the specified object
   */
  public boolean contains(T o) throws IllegalArgumentException {

    if (this.size == 0) throw new IllegalArgumentException("Linked list is empty");

    Node<T> currNode = this.head;

    // loop through until specified object is found or end of list is reached
    for (int i = 0; i < this.size; i++) {

      if (currNode.getData().equals(o)) return true;

      currNode = currNode.getNext();

    }

    return false;

  }

  /**
   * Get the object at the specified index of the current linked list
   * @param index Int index of object to return
   * @return Object at specified index in current linked list
   */
  public T get(int index) throws IndexOutOfBoundsException, NullPointerException {

    // check for empty list
    if (this.size == 0) throw new NullPointerException("Linked list is empty");

    // check for invalid index
    if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException("Invalid index specified to get object");

    // check for getting data at head
    if (index == 0) return this.head.getData();

    Node<T> currNode = this.head;

    for (int i = 0; i < index; i++) {

        currNode = currNode.getNext();

    }

    return currNode.getData();

  }

  /**
   * Get the index of the specified object in the current linked list
   * @param o Object to return the index of
   * @return The index of the object specified in the current linked list
   */
  public int indexOf(T o) throws IllegalArgumentException{

    Node<T> currNode = this.head;
    int index = -1;

    for (int i = 0; i < this.size; i++) {

      if (currNode.getData().equals(o)) {

        index = i;
        break;

      } else {

        currNode = currNode.getNext();

      }

    }

    // check for object specified not in list
    if (index == -1) throw new IllegalArgumentException("Object specified is not present in linked list");

    return index;

  }

  /**
   * Check if the current linked list is empty
   * @return Boolean true if the current linked list is empty
   */
  public boolean isEmpty() {

    return (this.size == 0) ? true : false;

  }

  /**
   * Remove the object at the specified index from the current linked list
   * @param index Int index at which to remove object from the current linked list
   * @return Object removed from specified index of current linked list
   */
  public T remove(int index) throws IndexOutOfBoundsException {

    // check for invalid index
    if (index < 0 || index >= this.size) throw new IndexOutOfBoundsException("Invalid index specified to remove object");

    Node<T> currNode = this.head;
    this.setHead(currNode);
    Node<T> nextNode;

    // check for removing head
    if (index == 0) {

      nextNode = currNode.getNext();
      this.head = nextNode;
      this.size--;
      return currNode.getData();

    } else {

      for (int i = 0; i < (index - 1); i++) {

        currNode = currNode.getNext();

      }

      nextNode = currNode.getNext();
      currNode.setNext(nextNode.getNext());
      this.size--;
      return nextNode.getData();

    }

  }

  /**
   * Remove the object specified from the current linked list
   * @param o Object to remove from the current linked list
   * @return Object removed from the current linked list
   */
  public T remove(T o) throws IllegalArgumentException {

    Node<T> currentNode = this.head;
    int index = -1;

    for (int i = 0; i < this.size; i++) {

      if (currentNode.getData().equals(o))   {

        index = i;
        break;

      }

      currentNode = currentNode.getNext();

    }

    if (index == -1) throw new IllegalArgumentException("Object specified is not present in linked list");

    return this.remove(index);

  }

  /**
   * Set the object at the specified index of the current linked list to the specified object
   * @param index Int index at which to set
   * @param o Object to set specified index of current linked list to
   * @return Boolean true when successful
   */
  public boolean set(int index, T o) throws IndexOutOfBoundsException {

    // check for invalid index
    if (index < 1 || index >= this.size) throw new IndexOutOfBoundsException("Invalid index specified to set");

    Node<T> newNode = new Node(o);
    Node<T> currentNode = this.head;
    Node<T> nextNode;

    for (int i = 0; i < index; i++) {

        currentNode = currentNode.getNext();

    }

    nextNode = currentNode.getNext();
    currentNode.setNext(newNode);
    newNode.setNext(nextNode.getNext());
    return true;

  }

  /**
   * Get a sublist containing items in the current linked list from specified start to end indices
   * @param fromIndex Int inclusive start bound of sublist
   * @param toIndex Int exclusive end bound of sublist
   * @return
   */
  public MyList_LinkedList<T> subList(int fromIndex, int toIndex) throws IllegalArgumentException, IndexOutOfBoundsException {

    // check for empty list
    if (this.size == 0) throw new IllegalArgumentException("Linked list is empty");

    // check for invalid indices
    if (fromIndex < 0 || fromIndex > this.size || toIndex < 0 || toIndex > this.size) throw new IndexOutOfBoundsException("Invalid index or indices specified to create sublist");

    if (fromIndex > toIndex) throw new IndexOutOfBoundsException("Specified start index is not lower than end index");

    // check for getting sublist of size 1
    if (fromIndex == (toIndex - 1)) return new MyList_LinkedList<>(new Node<>(this.get(fromIndex)));

    Node<T> currNode = this.head;
    MyList_LinkedList<T> newList = new MyList_LinkedList<>();

    //TODO: can probably make this more efficient by not using add
    for (int i = 0; i < toIndex; i++) {

      if (i >= fromIndex) {

        newList.add(currNode.getData());

      }

      currNode = currNode.getNext();

    }

    return newList;

  }

  /**
   * Make an array out of the current linked list
   * @return Generic array containing the elements of the current linked list
   */
  public T[] toArray() throws IllegalArgumentException {

    // check for empty list
    if (this.size == 0) throw new IllegalArgumentException("Linked list is empty");

    T[] newArray = (T[])new Object[this.size];
    Node<T> currNode = this.head;
    currNode.setData((T) this.getHead().getData());

    // populate new array with elements in order from list
    for (int i = 0; i < this.size; i++) {

      newArray[i] = (T) currNode.getData();
      currNode = currNode.getNext();

    }

    return newArray;

  }

  /**
   * Swap two nodes in the specified positions in the current linked list
   * @param pos1 Int index of the first element to swap, should be lower of the two positions
   * @param pos2 Int index of the second element to swap, should be higher of the two positions
   * @return Boolean true if successful
   */
  public boolean swap(int pos1, int pos2) throws IllegalArgumentException, IndexOutOfBoundsException {

    if (pos1 < 1 || pos1 > this.size || pos2 < 1 || pos2 > this.size) throw new IndexOutOfBoundsException("Invalid index or indices specified to swap");

    if (pos2 <= pos1) throw new IllegalArgumentException("Specified first position is not lower than specified second position");

    Node<T> currNode = this.head;
    Node<T> pos1Node = new Node<T>(null);
    Node<T> pos2Node = new Node<T>(null);

    //TODO: finish reworking this part of the method
    for (int i = 0; i < pos2; i++) { //loop until second position is reached

      if (i == (pos1 - 1)) { //if first position is found

        pos1Node.setData(currNode.getData());
        pos1Node.setNext(currNode.getNext());

      } else if (i == (pos2 - 1)) { //if second position is found

        pos2Node.setData(currNode.getData());
        pos2Node.setNext(currNode.getNext());

      }
      currNode = currNode.getNext();

    }

    currNode = this.getHead();
    this.setHead(currNode);

    for (int i = 0; i < (pos2 - 1); i++) { //swap values

      if (i == (pos1 - 1)) {

        currNode.setData(pos2Node.getData());

      }

      currNode = currNode.getNext();

    }

    currNode.setData(pos1Node.getData());
    return true;

  }

  /**
   * Shift all elements in the current linked list by the specified number of indices
   * @param numPos Int number of indices to shift the current link list by
   * @return Boolean true if successful
   */
  public boolean shift(int numPos) throws IllegalArgumentException {

    // check for invalid numPos
    if (Math.abs(numPos) > this.size) throw new IllegalArgumentException("Invalid number of indices to shift by specified");

    // check for valid numPos that would result in the same linked list after shifting
    if (numPos == 0 || Math.abs(numPos) == this.size) return true;

    //TODO: finish reworking this part of the method
    Node<T> tailNode = new Node<T>(null);
    Node<T> currNode = this.head;
    this.setHead(tailNode);
    int max = 0;

    if (numPos < 0) { //move to the left

      numPos = Math.abs(numPos);
      max = numPos;

    } else { //move to the right

      max = (this.size - numPos);

    }

    for (int i = 0; i < (this.size - 1); i++) { //find old tail

      tailNode = tailNode.getNext();

    }

    tailNode.setNext(this.getHead());
    currNode.setNext(this.getHead().getNext());
    currNode.setData(this.getHead().getData());
    this.setHead(currNode);

    for (int i = 0; i < max; i++) { //find new head

      currNode = currNode.getNext();

    }

    this.setHead(currNode);
    currNode = null;
    currNode = this.getHead();
    this.setHead(currNode);

    for (int i = 0; i < (this.size - 1); i++) {

      currNode = currNode.getNext(); //find new tail

    }

    currNode.setNext(null);

    return true;

  }

}