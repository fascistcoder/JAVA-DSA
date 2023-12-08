package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 29/05/22
 */
public class ReverseLinkedList {

	public MiddleNode.ListNode  reverseList(MiddleNode.ListNode head) {

		if(head==null){
			return null;
		}

		if(head.next==null){
			return head;
		}

		MiddleNode.ListNode prev = null;
		MiddleNode.ListNode next = null;
		MiddleNode.ListNode currentNode = head;

		while (currentNode != null){
			next = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = next;
		}

		return prev;

	}
}
