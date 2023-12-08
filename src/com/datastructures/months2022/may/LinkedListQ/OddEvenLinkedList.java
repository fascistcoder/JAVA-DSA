package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 30/05/22
 */
public class OddEvenLinkedList {

	private static MiddleNode.ListNode mid(MiddleNode.ListNode head) {

		MiddleNode.ListNode evenPtr = head.next;
		MiddleNode.ListNode oddPtr = head;
		MiddleNode.ListNode evenHead = evenPtr;

		while (evenPtr != null && evenPtr.next != null) {
			oddPtr.next = evenPtr.next;
			oddPtr = oddPtr.next;


			evenPtr.next = oddPtr.next;
			evenPtr = evenPtr.next;
		}

		oddPtr.next = evenHead;

		return head;

	}

	public MiddleNode.ListNode oddEvenList(MiddleNode.ListNode head) {

		return mid(head);
	}
}
