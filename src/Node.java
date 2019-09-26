/**
 * A node to be used in a linked list, value is generic
 * @author Daniel Haluszka
 */
public class Node<T> {

	private Node next;
	private T data;

	/**
	 * Constructor for a new node with no next node
	 * @param data Value of the new node
	 */
	public Node(T data) {

		this.data = data;
		this.next = null;
		
	}

	/**
	 * Constructor for a new node with a new node specified
	 * @param data The value of the new node
	 * @param next Node to be pointed to by the new node
	 */
	public Node(T data, Node<T> next) {

		this.data = data;
		this.next = next;

	}

	/**
	 * Check whether a node points to another node
	 * @return Boolean value true when current node points to another node
	 */
	public boolean hasNext() {
		
		if (next == null) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}

	/**
	 * Set the node that is pointed to by the current node
	 * @param newNext Nde to be pointed to by the current node
	 */
	public void setNext(Node newNext) {
		
		this.next = newNext;
		
	}

	/**
	 * Get the node that is pointed to by the current node
	 * @return Node pointed to by the current node
	 */
	public Node getNext() {
		
		return this.next;
		
	}

	/**
	 * Set the value of the current node
	 * @param newData New value of the current node
	 */
	public void setData(T newData) {
		
		this.data = newData;
		
	}

	/**
	 * Get the value of the current node
	 * @return Value of the current node
	 */
	public T getData() {
		
		return this.data;
		
	}
	
}