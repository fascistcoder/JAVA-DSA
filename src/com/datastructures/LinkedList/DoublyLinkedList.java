package com.datastructures.LinkedList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 20/11/23
 */
public class DoublyLinkedList {
	DoublyNode head;
	DoublyNode tail;
	int size;

	public static void main(String[] args) {
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		doublyLinkedList.createDLL(1);
		doublyLinkedList.insertInDLL(2, 1);
		doublyLinkedList.insertInDLL(3, 2);
		doublyLinkedList.insertInDLL(4, 3);
		doublyLinkedList.insertInDLL(5, 4);
		doublyLinkedList.traverseLinkedList();
		doublyLinkedList.reversalTraversalDLL();
		doublyLinkedList.searchDLL(5);
		doublyLinkedList.searchDLL(7);
		doublyLinkedList.deleteDLL(0);
		doublyLinkedList.traverseLinkedList();
	}

	public void createDLL(int val) {
		head = new DoublyNode();
		DoublyNode newNode = new DoublyNode();
		newNode.value = val;
		newNode.next = null;
		newNode.prev = null;
		head = newNode;
		tail = newNode;
		size = 1;
	}

	public void insertInDLL(int val, int location) {
		DoublyNode newNode = new DoublyNode();
		newNode.value = val;
		if (head == null) {
			createDLL(val);
		} else if (location == 0) {
			newNode.next = head;
			newNode.prev = null;
			head.prev = newNode;
			head = newNode;
		} else if (location >= size) {
			newNode.next = null;
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		} else {
			DoublyNode tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			DoublyNode nextNode = tempNode.next;
			newNode.prev = tempNode;
			newNode.next = nextNode;
			tempNode.next = newNode;
			nextNode.prev = newNode;
		}
		size++;
	}

	public void traverseLinkedList() {
		if (head == null) {
			System.out.println("SLL does not exist");
		}

		DoublyNode tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.value);
			if (tempNode.next != null) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.next;
		}

		System.out.println("\n");
	}

	public void reversalTraversalDLL() {
		if (head == null) {
			System.out.println("SLL does not exist");
		}

		DoublyNode tempNode = tail;
		while (tempNode != null) {
			System.out.print(tempNode.value);
			if (tempNode.prev != null) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.prev;
		}

		System.out.println("\n");
	}

	public void searchDLL(int val) {
		if (head == null) {
			System.out.println("DLL does not exist");
		}

		DoublyNode tempNode = head;
		int i = 0;

		while (tempNode != null) {
			if (tempNode.value == val) {
				System.out.println("Value is found in the linked list at index " + i);
				return;
			}
			tempNode = tempNode.next;
			i++;
		}
		System.out.println("Value is not found in the Linked list");
	}

	public void deleteDLL(int location) {
		if (head == null) {
			System.out.println("DLL does not exist");
		} else if (location == 0) {
			DoublyNode first = head;
			head = first.next;
			head.prev = null;
			size--;
			if (size == 0) {
				tail = null;
			}
		} else if (location >= size) {
			DoublyNode tempNode = tail.prev;
			if (size == 1) {
				head = null;
				tail = null;
			} else {
				tempNode.next = null;
				tail = tempNode;
			}
			size--;
		} else {
			DoublyNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.next;
			}
			DoublyNode deleteNode = tempNode.next;
			tempNode.next = deleteNode.next;
			deleteNode.prev = tempNode;
			size--;
		}
	}

	public void deleteEntireLinkedList() {
		DoublyNode tempNode = head;

		while (tempNode != null){
			tempNode.prev = null;
			tempNode = tempNode.next;
		}

		head = null;
		tail = null;
		System.out.println("Entire Double Linked lIst deleted successfully");
	}
}
