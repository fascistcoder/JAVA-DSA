package com.datastructures.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/05/22
 */
public class ListNode {
	private int val;
	private ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
}
