package com.datastructures.LinkedList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/11/23
 */
public class CircularDLL {
	DoublyNode head;
	DoublyNode tail;
	int size;

	public static void main(String[] args) {
		CircularDLL circularDLL = new CircularDLL();
		circularDLL.createCircularDLL(2);
		circularDLL.insertInCircularDll(3, 1);
		circularDLL.insertInCircularDll(4, 2);
		circularDLL.insertInCircularDll(5, 3);
		circularDLL.traverseCDLL();
		circularDLL.reverseTraverseCDLL();
		circularDLL.searchDCLL(4);
		circularDLL.searchDCLL(10);
		circularDLL.deleteEntireLinkedList();
		circularDLL.traverseCDLL();
	}

	public void createCircularDLL(int val) {
		head = new DoublyNode();
		DoublyNode newNode = new DoublyNode();
		newNode.value = val;
		newNode.next = newNode;
		newNode.prev = newNode;
		head = newNode;
		tail = newNode;
		size = 1;
	}

	public void insertInCircularDll(int val, int location) {
		DoublyNode newNode = new DoublyNode();
		newNode.value = val;
		if (head == null) {
			createCircularDLL(val);
		} else if (location == 0) {
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
			tail.next = newNode;
			head = newNode;
		} else if (location >= size) {
			newNode.next = head;
			newNode.prev = tail;
			head.prev = newNode;
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

	public void traverseCDLL() {
		if (head == null) {
			System.out.println("CDLL does not exist");
			return;
		}

		DoublyNode tempNode = head;

		do {
			System.out.print(tempNode.value);
			if (tempNode.next != head) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.next;

		} while (tempNode != head);
		System.out.println("\n");

	}

	public void reverseTraverseCDLL() {
		if (head == null) {
			System.out.println("CDLL does not exist");
			return;
		}

		DoublyNode tempNode = tail;

		do {
			System.out.print(tempNode.value);
			if (tempNode.prev != tail) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.prev;

		} while (tempNode != tail);
		System.out.println("\n");

	}

	public void searchDCLL(int val) {
		if (head == null) {
			System.out.println("DCLL does not exist");
			return;
		}
		DoublyNode tempNode = head;
		int i = 0;

		do {
			if (tempNode.value == val) {
				System.out.println("Value is found in the circular double linked list at index " + i);
				return;
			}
			tempNode = tempNode.next;
			i++;
		} while (tempNode != head);

		System.out.println("Value is  not found in the Linked list");

	}

	public void deleteCDLL(int location){
		if (head == null){
			System.out.println("DCLL does not exist");
		} else if (location == 0) {
			if(size == 1){
				head.prev = null;
				tail.next = null;
				head = null;
				tail = null;
			}else {
				DoublyNode first = head;
				head = first.next;
				head.prev = tail;
				tail.next = head;
			}
			size--;
		} else if (location >= size) {
			if (size == 1) {
				head.prev = null;
				tail.next = null;
				head = null;
				tail = null;
			} else {
				DoublyNode tempNode = tail.prev;
				tempNode.next = head;
				tail = tempNode;
				head.prev= tempNode;
			}
			size--;
		}else {
			DoublyNode tempNode = head;
			for(int i = 0; i<location-1;i++){
				tempNode = tempNode.next;
			}
			DoublyNode delNode = tempNode.next;
			tempNode.next = delNode.next;
			delNode.prev = tempNode;
			size--;
		}
	}

	public void deleteEntireLinkedList() {
		DoublyNode tempNode = head;

		do{
			tempNode.prev = null;
			tempNode = tempNode.next;
		} while (tempNode != head);

		head.prev = null;
		head = null;
		tail.next = null;
		tail = null;

		System.out.println("Entire Double Linked lIst deleted successfully");
	}
}
