package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 29/05/22
 */
public class DoublyListNode {
	private int val;
	private DoublyListNode prev;
	private DoublyListNode next;

	public DoublyListNode(int val) {
		this.val = val;
		this.next = null;
	}

	public DoublyListNode(int val, DoublyListNode prev, DoublyListNode next) {
		this.val = val;
		this.prev = prev;
		this.next = next;
	}

	public int getVal() {
		return val;
	}

	public DoublyListNode getPrev() {
		return prev;
	}

	public DoublyListNode getNext() {
		return next;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public void setPrev(DoublyListNode prev) {
		this.prev = prev;
	}

	public void setNext(DoublyListNode next) {
		this.next = next;
	}
}
