package com.interview.gs;

class Node {
	int data;
	Node next;
	Node prev;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class Deque {
	private Node front;
	private Node rear;

	public Deque() {
		front = null;
		rear = null;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			newNode.next = front;
			front.prev = newNode;
			front = newNode;
		}
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
		} else {
			newNode.prev = rear;
			rear.next = newNode;
			rear = newNode;
		}
	}

	public int removeFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Deque is empty");
		}
		int data = front.data;
		front = front.next;
		if (front != null) {
			front.prev = null;
		} else {
			rear = null; // The deque is now empty
		}
		return data;
	}

	public int removeLast() {
		if (isEmpty()) {
			throw new RuntimeException("Deque is empty");
		}
		int data = rear.data;
		rear = rear.prev;
		if (rear != null) {
			rear.next = null;
		} else {
			front = null; // The deque is now empty
		}
		return data;
	}

	public int peekFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Deque is empty");
		}
		return front.data;
	}

	public int peekLast() {
		if (isEmpty()) {
			throw new RuntimeException("Deque is empty");
		}
		return rear.data;
	}
}

public class _11_Deque {

	public static void main(String[] args) {
		Deque deque = new Deque();

		// Adding elements to the deque
		deque.addFirst(1);
		deque.addLast(2);
		deque.addFirst(3);
		deque.addLast(4);

		// Removing and displaying elements
		System.out.println("Front element: " + deque.removeFirst());
		System.out.println("Rear element: " + deque.removeLast());

		// Peeking at elements
		System.out.println("Front element (peek): " + deque.peekFirst());
		System.out.println("Rear element (peek): " + deque.peekLast());
	}

}
