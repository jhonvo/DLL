package com.codingdojo.datastructure;

public class DLL {
	private Node head;
	private Node tail;

	public DLL() {
		this.head = null;
		this.tail = null;
	}
	
	public void insertFirst (int val) {
		Node newNode = new Node(val);
		
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
		else {
			this.head.setPrevious(newNode);
			newNode.setNext(this.head);
			this.head = newNode;
		}
	}
	
	public void insertLast (int val) {
		Node newNode = new Node(val);
		
		if (this.tail == null) {
			insertFirst(val);
		}
		
		else {
			this.tail.setNext(newNode);
			newNode.setPrevious(this.head);
			this.tail = newNode;
		}
	
	}
	
	public void insertAtPosition(int index, int val) {
		if (length() <= index ) {
			System.out.println("That index doesn't exist in the list yet!");
		}
		else {
			if (index==0) {
				insertFirst(val);
			}
			else {
				Node current = this.head;
				Node previous = current;
				int count = 0;
				
				while (count != index) {
					previous = current;
					current = current.getNext();
					count ++;
				}
				
				Node newNode = new Node(val);
				newNode.setNext(current);
				current.setPrevious(newNode);
				newNode.setPrevious(previous);
				previous.setNext(newNode);
			}
		}
		
	}
	
	public int length() {
		int count = 0;
		Node current = this.head;
		while (current != null) {
			count ++;
			current = current.getNext();
		}
		return count;
	}
		
	public void printForward() {
		Node current = this.head;
		
		while (current != null) {
			System.out.print(current.getValue() + " ");
			current = current.getNext();
		}
		
		if (this.head == null) {
			System.out.print("This list is empty");
		}
	}
	
	public void printBackward() {
		Node current = this.tail;
		
		while (current != null) {
			System.out.print(current.getValue() + " ");
			current = current.getPrevious();
		}
		
		if (this.head == null) {
			System.out.print("This list is empty");
		}
	}
	
	public void find(int val) {
		Node current = this.head;
		int find = 0;
		
		while (current != null) {
			if (current.getValue() == val) {
				System.out.println("The value has been found in the node " + current);
				find =+ 1;
				current = current.getNext();
			}
			else {
				current = current.getNext();
			}
		}
		if (find == 0) {
			System.out.println("The value his not part of the list");
		}
	}
	
	public void updateFirst(int val, int newVal) {
		Node current = this.head;
		int find = 0;
		
		while (current != null && find == 0) {
			if (current.getValue() == val) {
				current.setValue(newVal);
				System.out.println(String.format("The value has been updated from %d to %d.", val, newVal));
				find =+ 1;
				current = current.getNext();
			}
			else {
				current = current.getNext();
			}
		}
		if (find == 0) {
			System.out.println("The value his not part of the list");
		}
	}
	
	public void updateAll(int val, int newVal) {
		Node current = this.head;
		int find = 0;
		
		while (current != null) {
			if (current.getValue() == val) {
				current.setValue(newVal);
				System.out.println(String.format("The value(s) has been updated from %d to %d.", val, newVal));
				find =+ 1;
				current = current.getNext();
			}
			else {
				current = current.getNext();
			}
		}
		if (find == 0) {
			System.out.println("The value his not part of the list");
		}
	}
	
	public void remove(int val) {
				
		if (this.head.getValue() == val) {
			Node next = this.head.getNext();
			next.setPrevious(null);
			this.head = next;
			System.out.println("The value has been removed.");
			return;
		}
		
		if (this.tail.getValue() == val) {
			Node previous = this.tail.getPrevious();
			previous.setNext(null);
			this.tail = previous;
			System.out.println("The value has been removed.");
			return;
		}
		
		Node current = this.head;
		int find = 0;
		
		while (current.getNext() != null && find == 0) {
			if (current.getValue() == val) {
				Node previous = current.getPrevious();
				Node next = current.getNext();
				previous.setNext( next);
				next.setPrevious(previous);
				System.out.println("The value has been removed.");
				find =+ 1;
				current = current.getNext();
			}
			else {
				current = current.getNext();
			}
		}
		
		if (find == 0) {
			System.out.println("The value his not part of the list");
		}
	}

}
