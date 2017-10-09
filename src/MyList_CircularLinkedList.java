
public class MyList_CircularLinkedList<T> implements MyList<T> {
	
	private Node head;
	private Node tail;
	private int size = 0;
	
	public MyList_CircularLinkedList() {
		
		this.setHead(null);
		this.setTail(null);
		this.getHead().setNext(this.getTail());
		this.getTail().setNext(this.getHead());
		
	}
	
	public void setHead(Node newHead) {
		
		this.head = newHead;
		
	}
	
	public Node getHead() {
		
		return this.head;
		
	}
	
	public void setTail(Node newTail) {
		
		if (newTail.hasNext() == true) {
			
			newTail.setNext(null);
			
		}

		this.tail = newTail;
		
	}
	
	public Node getTail() {
		
		return this.tail;
		
	}
	
	public void setSize(int newSize) {
		
		this.size = newSize;
		
	}
	
	public int getSize() {
		
		return this.size;
		
	}

	public boolean add(int index, T o) {

		System.out.println(this.getSize());
		if (index < 1 || index > this.getSize()) {
			
			System.out.println("Error: Invalid index value specified in add method of MyList_CircularLinkedList.");
			return false;
			
		} else {
		
			Node<T> newNode = new Node<T>(o);
			Node<T> currentNode = new Node<T>(null);
			currentNode.setNext(this.getHead().getNext());
			currentNode.setData((T) this.getHead().getData());
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
		
		Node newNode = new Node(o);
		
		if (this.getHead() == null) {
			
			this.setHead(newNode);
			this.setTail(newNode);
			this.setSize(1);
			
		} else {
			
			newNode.setNext(this.getHead());
			this.getTail().setNext(newNode);
			this.setTail(newNode);
			this.setSize((this.getSize() + 1));
			
		}
		
		return true;
		
	}

	public boolean clear() { //not accessed in playlist
		
		this.setHead(null);
		this.setTail(null);
		this.setSize(0);
		return true;
		
	}

	public boolean contains(T o) {

		Node<T> currentNode = new Node<T>(null);
		currentNode.setNext(this.getHead().getNext());
		currentNode.setData((T) this.getHead().getData());
		
		for (int i = 0; i < this.getSize(); i++) {
			
			if (currentNode.getData() == o) {
				
				return true;
				
			}
			currentNode = currentNode.getNext();
			
		}
		
		return false;
		
	}

	public T get(int index) {

		if (index < 1 || index > this.getSize()) {
			
			System.out.println("Error: Invalid index value specified in get method of MyList_CircularLinkedList.");
			return null;
			
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

	public int indexOf(T o) { //not accessed in playlist
		
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
	
	public boolean isEmpty() { //not accessed in playlist

		if (this.getHead() == null) {
			
			return true;
			
		} else {
			
			return false;
		
		}
	}

	public T remove(int index) { //not accessed in playlist

		if (index < 1 || index > this.getSize()) {
			
			System.out.println("Error: Invalid index value specified in remove method of MyList_CircularLinkedList.");
			return null;
			
		} else {
			
			Node<T> currentNode = new Node<T>(null);
			currentNode.setNext(this.getHead().getNext());
			currentNode.setData((T) this.getHead().getData());
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
		currentNode.setData((T) this.getHead().getData());
		Node<T> nextNode = new Node<T>(null);
		int index = 0;
		
		for (int i = 0; i < this.getSize(); i++) {
			
			
			if (currentNode.getData() == o) {

				index = i;
				
			} else if (i == this.getSize()){
				
				System.out.println("Error: Specified song to remove is not present in CircularLinkedList_Playlist.");
				return null;
				
			}
			
			currentNode = currentNode.getNext();
			
		}
		
		currentNode = this.getHead();
		
		for (int i = 0; i < (index - 1); i++) {
			
			currentNode = currentNode.getNext();
		
		}
		
		nextNode = currentNode.getNext();
		currentNode.setNext(nextNode.getNext());
		this.setSize(this.getSize() - 1);
		return (T) nextNode.getData();
		
	}

	public boolean set(int index, T element) {

		if (index < 1 || index > this.getSize()) {
			
			System.out.println("Error: Invalid index value specified in set method of MyList_CircularLinkedList.");
			return false;
			
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

	public int size() {
		
		return this.getSize();
		
	}

	public MyList<T> subList(int fromIndex, int toIndex) { //not accessed in playlist

		if (fromIndex < 1 || fromIndex > this.getSize() || toIndex < 1 || toIndex > this.getSize()) {
			
			System.out.println("Error: Invalid index value specified in subList method of MyList_CircularLinkedList.");
			return null;
			
		} else if (fromIndex > toIndex){
			
			System.out.println("Error: Invalid 'to' index value specified in subList method of MyList_CircularLinkedList.");
			return null;
			
		} else {
			
			MyList_LinkedList<T> newList = new MyList_LinkedList<T>();
			Node<T> currentNode = new Node<T>(null);
			currentNode.setNext(this.getHead().getNext());
			currentNode.setData((T) this.getHead().getData());
			
			for (int i = 0; i < toIndex; i++) {
				
				if (i == (fromIndex - 1)) {
					
					newList.setHead(currentNode);
					
				} else {
					
					if (i == (toIndex- 1)) {
						
						System.out.println(currentNode.getData());
						currentNode.setNext(null);
						
					}
					
					newList.add((T) currentNode);
					
				}
				
				currentNode = currentNode.getNext();
				
			}
			
			return newList;
			
		}

	}

	public T[] toArray() { //not accessed in playlist

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

	public boolean swap(int position1, int position2) { //not accessed in playlist

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
			
			for (int i = 0; i < position2; i++) {
				
				if (i == (position1 - 1)) {
					
					pos1Node = currentNode;
					
				} else if (i == (position2 - 1)) {
					
					pos2Node = currentNode;
					
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
			
			System.out.println("Error: Invalid number of positions specified in shift method of MyList_CircularLinkedList.");
			return false;
			
		} else {
			
			Node<T> tailNode = new Node<T>(null);
			Node<T> currentNode = new Node<T>(null);
			currentNode.setNext(this.getHead().getNext());
			currentNode.setData((T) this.getHead().getData());
			
			for (int i = 0; i < this.getSize(); i++) {
				
				currentNode = currentNode.getNext();
				
			}
			
			tailNode = currentNode;
			currentNode.setNext(this.getHead().getNext());
			currentNode.setData((T) this.getHead().getData());
			this.setHead(currentNode);
			
			if (positions == 0 || positions == this.getSize()) {
				
				return true;
				
			} else if (positions > 0) {
				
				return true; //shifting elements to the right
				
			} else {
				
				return true; //shifting elements to the left
				
			}
			
		}
		
	}

}