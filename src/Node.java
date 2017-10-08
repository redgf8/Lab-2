
public class Node<T> {

	private Node next;
	private T data;
	
	public Node(T data) {
		
		this.setNext(null);
		this.setData(data);
		
	}
	
	public boolean hasNext() {
		
		if (next == null) {
			
			return false;
			
		} else {
			
			return true;
			
		}
		
	}
	
	public Node next() {
		
		return this.getNext();
		
	}
	
	public void setNext(Node newNextValue) {
		
		this.next = newNextValue;
		
	}
	
	public Node getNext() {
		
		return this.next;
		
	}
	
	public void setData(T newData) {
		
		this.data = newData;
		
	}
	
	public T getData() {
		
		return this.data;
		
	}
	
	
}
