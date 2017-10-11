
public class Node<T> {

	private Node next;
	private T data;
	
	//construct a node with the supplied data
	public Node(T data) {
		
		this.setNext(null);
		this.setData(data);
		
	}
	
	//check if the current node points to another node
	public boolean hasNext() {
		
		if (next == null) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}
	
	//return the node that the current node points to
	public Node next() {
		
		return this.getNext();
		
	}
	
	//set the node that the current node points to
	public void setNext(Node newNextValue) {
		
		this.next = newNextValue;
		
	}
	
	//get method
	public Node getNext() {
		
		return this.next;
		
	}
	
	//set method for the data in the current node
	public void setData(T newData) {
		
		this.data = newData;
		
	}
	
	//get method for the data in the current node
	public T getData() {
		
		return this.data;
		
	}
	
}