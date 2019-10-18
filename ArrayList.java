import java.util.*;

public class ArrayList<T> implements List<T> {
	Object[] a;
	int size;
	int pos;

	public ArrayList() {
		a = new Object[10];
		this.size = 0;
		this.pos = 0;
	}

	public void add(Object item) {
		if(size == a.length)
			grow_array();
		a[size] = item; //size is where list is at (how many elements contained inside)
		size++; //adding element so increment size (or # of elements)
	}

	public void add(int pos, Object item) {
		//check if position(index) exists
		if(pos < 0 || pos > size ) {
			System.out.println("Not a valid position.");
		}
		if(size == a.length)
			grow_array();
		//Shift elements over
		for(int i = size - 1; i > pos; i--)
			a[i+1] = a[i];
		a[pos] = item;
		size++; //adding element
	}

	public Object get(int pos) {
		//check if position(index) exists
		if(pos < 0 || pos > size ) {
			System.out.println("Not a valid position.");;
		}
		return a[pos];
	}

	public int size() {
		return this.size;
	}

	public Object remove(int pos) {
		//check is position exists
		if(pos < 0 || pos > size) {
			System.out.println("Not a valid position.");;
		}
		Object temp = a[pos];
		//Shift elements over
		for(int i = pos; i < size() - 1; i++)
			a[i] = a[i+1];
		size--;

		return temp;
	}

	void grow_array() {
		Object[] new_a = (new Object[a.length*2]);
		for(int i = 0; i < size; i++)
			new_a[i] = a[i];
		a = new_a;
	}
}