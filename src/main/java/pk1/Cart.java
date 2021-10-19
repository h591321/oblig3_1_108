package pk1;

import java.util.LinkedList;

public class Cart {
	private LinkedList<String> linkedCart;
	
	public Cart(){
		this.linkedCart=new LinkedList<>();
	}
	public void add(String input) {
		linkedCart.add(input);
	}
	public void remove(String input) {
		linkedCart.remove(input);
	}
	public LinkedList<String> getLinkedList(){
		return linkedCart;
	}
	public boolean isEmpty() {
		return linkedCart.isEmpty();
	}
	
}
