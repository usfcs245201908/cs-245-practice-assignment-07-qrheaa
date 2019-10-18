import java.util.*;

public class LinkedList<T> implements List<T> {

	Node head;
	int size;

	private class Node<T> {
		Object data;
		Node next;

		public Node(Object item) {
			this.data = item;
			this.next = null;
		}
	}

	public LinkedList() {
		this.head = new Node(null);
		this.size = 0;
	}

	public void add(Object item) {
		if(head.data == null) {
			head = new Node(item); //add items in list

			++size;
		}
		else {
			//Insert element at end of list
			Node node = new Node(item);
			Node prev = head; //Accesses first element on list 

			while(prev.next != null) { //not already reached last element
				prev = prev.next; //reach last element
			}

			prev.next = node;
			size++;
		}

	}

	public void add(int pos, Object item) {
		//check if position(index) exists
		if(pos +1 > size || pos < 0)
			System.out.println("Not a valid position.");
		if(pos == 0) {
			Node node = new Node(item);
			node.next = head;
			head = node;

			++size;
		}
		else {
			Node prev = head;
			for(int i = 0; i < pos ; i++) {
				prev = prev.next;
			}
				Node node = new Node(item);
				node.next = prev.next;
				prev.next = node;

				++size;
		}
	}

	public Object remove(int pos) {
		//check is position exists
		if(pos > size || pos < 0) {
			System.out.println("Position is not valid.");
			return null;
		}
		if(pos == 0) {
			Node node = head;
			head = head.next;
			--size;

			return node.data;
		}
		else {
			Node prev = head;
			for(int i = 0; i < pos; i++) 
				prev = prev.next;

			Node node = prev.next;
			prev.next = node.next;
			--size;

			return node.data;
		}
	}

	public Object get(int pos) {
		Node current = head;
		int count = 0;
		//check if position(index) exists
		if(pos < 0 || pos > size-1 ) {
			System.out.println("Position is not valid.");
			return null;
		}
		else {
			while(current!=null) {
				if(count == pos) {
					return current.data;
				}
				count++;
				current = current.next;
			}
		}
		return null;

		
	}

	public int size() {
		return this.size;
	}

}