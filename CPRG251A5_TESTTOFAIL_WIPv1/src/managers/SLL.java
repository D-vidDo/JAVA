package managers;

import contracts.*;
import problemdomain.*;

import java.io.*;
import java.util.Iterator;

/**
 * @author ElMenshawy
 * @version 14-03-2020
 */
public class SLL implements LinkedListADT {
	/**
	 * The first node in the linked list.
	 */
	private Node head;

	/**
	 * The number of nodes in the linked list.
	 */
	private int size;

	public SLL() throws NotSerializableException {
		this.head = null;
		this.size = 0;
	}

	public void prepend(Object data) {
		// Create a new node object to prepend.
		Node newNode = new Node(data);

		// Set next of new node to head
		// This must be done before we change the head.
		newNode.setNext(head);

		// Set head to new node
		head = newNode;

		// Increment the size
		size++;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void clear() {
		head = null;
	}

	public void append(Object data) {
		Node newNode = new Node(data);
		Node tempNode = null;
		if (head == null) {
			prepend(data);
		} else {
			tempNode = head;
			while (tempNode.getNext() != null) {
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(newNode);
			size++;
		}
	}

	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		Node tempNode = head;
		Node newNode = new Node(data);
		if (index == 0) {
			prepend(data);
		} else {
			for (int i = 0; i != index - 1; i++) {
				tempNode = tempNode.getNext();
			}
			Node swapNode = tempNode.getNext();
			tempNode.setNext(newNode);
			newNode.setNext(swapNode);
			size++;
		}
	}

	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		Node tempNode = head;
		for (int i = 0; i != index; i++) {
			tempNode = tempNode.getNext();
		}
		tempNode.setData(data);
	}

	public int size() {
		return this.size;
	}

	public void delete(int index) throws IndexOutOfBoundsException {
		Node tempNode = head;
		for (int i = 0; i != index - 1; i++) {
			tempNode = tempNode.getNext();
		}
		Node delNode = tempNode.getNext();
		tempNode.setNext(delNode.getNext());
		delNode = null;
		size--;
	}

	public Object retrieve(int index) throws IndexOutOfBoundsException {
		Node tempNode = head;
		for (int i = 0; i != index; i++) {
			tempNode = tempNode.getNext();
		}
		return tempNode.getData();
	}

	@Override
	public int indexOf(Object data) {
		Node tempNode = head;
		int i = 0;
		while (data != tempNode.getData()) {
			tempNode = tempNode.getNext();
			i++;
		}
		return i;
	}

	@Override
	public boolean contains(Object data) {
		Node tempNode = head;
		for (int i = 0; i < size; i++) {
			if (data == tempNode.getData()) {
				return true;
			}
			tempNode = tempNode.getNext();
		}
		return false;
	}

	// You have error because you need to implement other methods in the interface
}