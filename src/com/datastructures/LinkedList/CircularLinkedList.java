package com.datastructures.LinkedList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 18/11/23
 */
public class CircularLinkedList {
	public Node head;
	public Node tail;
	public int size;

	public static void main(String[] args) {
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		circularLinkedList.createCSLL(1);
		circularLinkedList.insertInCLL(3, 1);
		circularLinkedList.insertInCLL(2, 2);
		circularLinkedList.insertInCLL(4, 3);

		circularLinkedList.traverseCLL();

		circularLinkedList.searchCLL(5);

		circularLinkedList.deleteCLL(3);
		circularLinkedList.traverseCLL();

		circularLinkedList.deleteEntireCLL();
		circularLinkedList.traverseCLL();
	}

	public Node createCSLL(int val) {
		head = new Node();
		Node node = new Node();
		node.value = val;
		node.next = node;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	public void insertInCLL(int val, int location) {
		Node node = new Node();
		node.value = val;
		if (head == null) {
			createCSLL(val);
		} else if (location == 0) {
			node.next = head;
			head = node;
			tail.next = head;
		} else if (location >= size) {
			tail.next = node;
			tail = node;
			tail.next = head;
		} else {
			Node tempNode = head;
			while (tempNode != null) {
				tempNode = tempNode.next;
			}
			Node nextNode = tempNode.next;
			tempNode.next = node;
			node.next = nextNode;
		}
		size++;
	}

	public void traverseCLL() {
		if (head == null) {
			System.out.println("CLL does not exist");
			return;
		}

		Node tempNode = head;

		do {
			System.out.print(tempNode.value);
			if (tempNode.next != head) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.next;

		} while (tempNode != head);
		System.out.println("\n");

	}

	public void searchCLL(int val) {
		if (head == null) {
			System.out.println("CLL does not exist");
			return;
		}
		Node tempNode = head;
		int i = 0;

		do {
			if (tempNode.value == val) {
				System.out.println("Value is found in the linked list at index " + i);
				return;
			}
			tempNode = tempNode.next;
			i++;
		} while (tempNode != head);

		System.out.println("Value is  not found in the Linked list");

	}

	public void deleteCLL(int location) {
		if (head == null) {
			System.out.println("CLL does not exist");
		}else if(location == 0){
			Node first = head;
			head = first.next;
			tail.next = head;
			size --;
			if(size == 0){
				tail = null;
				head.next = null;
				head = null;
			}
		}else if (location >= size) {
			Node tempNode = head;
			for(int i = 0;  i< size -1 ; i++){
				tempNode = tempNode.next;
			}
			if (tempNode == head) {
				head.next = null;
				tail = head = null;
				size--;
				return;
			}
			tempNode.next = head;
			tail = tempNode;
			size--;
		}else {
			Node tempNode = head;
			for(int i = 0;  i< location -1 ; i++){
				tempNode = tempNode.next;
			}
			Node delNode = tempNode.next;
			tempNode.next = delNode.next;
			size--;
		}
	}

	public void deleteEntireCLL() {
		if (head == null) {
			System.out.println("CLL does not exist");
			return;
		}
		head = null;
		tail.next = null;
		tail = null;
		System.out.println("Entire Linked lIst deleted successfully");
	}
}
