package com.datastructures.LinkedList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 18/11/23
 */
public class SinglyLinkedList {
	public Node head;
	public Node tail;
	public int size;

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.createSinglyLinkedList(1);
		singlyLinkedList.insertInSingleLinkedList(1, 1);
		singlyLinkedList.insertInSingleLinkedList(2, 2);
		singlyLinkedList.insertInSingleLinkedList(6, 3);
		singlyLinkedList.insertInSingleLinkedList(3, 4);
		singlyLinkedList.insertInSingleLinkedList(4, 4);
		singlyLinkedList.insertInSingleLinkedList(5, 5);
		singlyLinkedList.insertInSingleLinkedList(6, 6);

		singlyLinkedList.traverseLinkedList();

		singlyLinkedList.searchLinkedList(14);
		singlyLinkedList.searchLinkedList(90);
		singlyLinkedList.searchLinkedList(1);

		singlyLinkedList.deleteLinkedList(5);
		singlyLinkedList.traverseLinkedList();

		singlyLinkedList.deleteEntireLinkedList();
		singlyLinkedList.traverseLinkedList();
	}

	public void createSinglyLinkedList(int nodeVal) {
		Node node = new Node();
		node.next = null;
		node.value = nodeVal;
		head = node;
		tail = node;
		size = 1;
	}

	// Insert Method
	public void insertInSingleLinkedList(int val, int location) {
		Node node = new Node();
		node.value = val;
		if (head == null) {
			createSinglyLinkedList(val);
		} else if (location == 0) {
			node.next = head;
			head = node;
		} else if (location >= size) {
			node.next = null;
			tail.next = node;
			tail = node;
		} else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			Node nextNode = tempNode.next;
			tempNode.next = node;
			node.next = nextNode;
		}
		size++;
	}

	public void traverseLinkedList() {
		if (head == null) {
			System.out.println("SLL does not exist");
		}

		Node tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.value);
			if (tempNode.next != null) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.next;
		}

		System.out.println("\n");
	}

	public void searchLinkedList(int val) {
		if (head == null) {
			System.out.println("SLL does not exist");
		}

		Node tempNode = head;
		int i = 0;
		while (tempNode != null) {
			if (tempNode.value == val) {
				System.out.println("Value is found in the linked list at index " + i);
				return;
			}
			tempNode = tempNode.next;
			i++;
		}
		System.out.println("Value is  not found in the Linked list");
	}

	public void deleteLinkedList(int location) {
		if (head == null) {
			System.out.println("SLL does not exist");
		} else if (location == 0) {
			Node first = head;
			head = first.next;
			size--;
			if (size == 0) {
				tail = null;
			}
		} else if (location >= size) {
			Node tempNode = head;
			Node prevNode = null;
			while (tempNode.next != null) {
				prevNode = tempNode;
				tempNode = tempNode.next;
			}
			if (prevNode == null) {
				tail = head = null;
				size--;
				return;
			}
			prevNode.next = null;
			tail = prevNode;
			size--;
		} else {
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.next;
			}
			Node deleteNode = tempNode.next;
			tempNode.next = deleteNode.next;
			size--;
		}
	}

	public void deleteEntireLinkedList() {
		head = null;
		tail = null;
		System.out.println("Entire Linked lIst deleted successfully");
	}
}
