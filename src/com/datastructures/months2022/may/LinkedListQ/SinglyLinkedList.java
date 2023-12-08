package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/05/22
 */
public class SinglyLinkedList {

	private ListNode head;
	private ListNode tail;
	private int length;

	public SinglyLinkedList(int value) {
		head = new ListNode(value);
		tail = head;
		length = 1;
	}

	public void prepend(int value) {
		head = new ListNode(value, head);
		length++;
	}

	public void append(int value) {
		ListNode listNode = new ListNode(value);
		tail.setNext(listNode);
		tail = listNode;
		length++;
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

		ListNode currentNode = traverse(index-1);

		ListNode nextNode = currentNode.getNext();
		ListNode newNode = new ListNode(value,nextNode);

		currentNode.setNext(newNode);
		length++;
	}

	private ListNode traverse(int index){
		ListNode currentNode = head;

		for(int i=0; i< index;i++){
			currentNode = currentNode.getNext();
		}

		return currentNode;
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

		ListNode currentNode = traverse(index-1);

		ListNode listNode = currentNode.getNext().getNext();
		currentNode.setNext(listNode);
		length--;
	}

	public void printList() {
		if (head == null) {
			return;
		}

		int c= 1;

		ListNode currentNode = head;
		System.out.print(currentNode.getVal());

		currentNode = currentNode.getNext();

		while (currentNode != null) {
			System.out.print("->" + currentNode.getVal());
			currentNode = currentNode.getNext();
			c++;
		}
		System.out.println();
		System.out.println(c);
	}

	public void deleteNode(ListNode node){
		node.setVal(node.getNext().getVal());
		node.setNext(node.getNext().getNext());
	}

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList(5);
		singlyLinkedList.printList();
		singlyLinkedList.append(10);
		singlyLinkedList.prepend(2);
		singlyLinkedList.insert(7, 1);
		singlyLinkedList.printList();


	}

}
