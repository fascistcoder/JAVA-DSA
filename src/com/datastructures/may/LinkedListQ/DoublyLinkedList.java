package com.datastructures.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 29/05/22
 */
public class DoublyLinkedList {
	private DoublyListNode head;
	private DoublyListNode tail;
	private int length;

	public DoublyLinkedList(int val) {
		head = new DoublyListNode(val);
		tail = head;
		length = 1;
	}

	public void prepend(int value) {
		DoublyListNode newNode = new DoublyListNode(value, null, head);
		head.setPrev(newNode);
		head = newNode;
		length++;
	}

	public void append(int value) {
		DoublyListNode doublyListNode = new DoublyListNode(value);
		tail.setNext(doublyListNode);
		tail = doublyListNode;
		length++;
	}

	public void printList() {
		DoublyListNode currentNode = head;
		System.out.println(currentNode.getVal());
		currentNode = currentNode.getNext();

		while (currentNode != null) {
			System.out.println("->" + currentNode.getVal());
			currentNode = currentNode.getNext();
		}

		System.out.println();
	}

	public void insert(int value, int index){

		if(index == 0){
			prepend(value);
			return;
		}

		if(index >= length){
			append(value);
			return;
		}

		DoublyListNode currentNode = traverse(index-1);
		DoublyListNode nextNode = currentNode.getNext();

		DoublyListNode newNode = new DoublyListNode(value,currentNode,nextNode);

		currentNode.setNext(newNode);
		newNode.setPrev(currentNode);
		nextNode.setPrev(newNode);

		length++;
	}

	public void remove(int index){

		if(index>=length){
			return;
		}

		if(index==0){
			head = head.getNext();
			length--;
			return;
		}

		DoublyListNode currentNode = traverse(index-1);

		DoublyListNode listNode = currentNode.getNext().getNext();
		currentNode.setNext(listNode);
		listNode.setPrev(currentNode);

		length--;
	}

	private DoublyListNode traverse(int index) {
		DoublyListNode currentNode = head;

		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNext();
		}

		return currentNode;
	}
}
