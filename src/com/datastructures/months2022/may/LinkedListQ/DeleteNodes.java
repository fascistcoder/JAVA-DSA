package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/06/22
 */
public class DeleteNodes {
	public static RemoveLoopInLinkedList.Node compute(RemoveLoopInLinkedList.Node head) {
		// your code here

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		RemoveLoopInLinkedList.Node firstReverse = reverse(head);
		RemoveLoopInLinkedList.Node first = firstReverse;
		RemoveLoopInLinkedList.Node second = null;

		int max = Integer.MIN_VALUE;

		while (first != null) {
			if (first.data >= max) {
				max = first.data;
				second = first;
				first = first.next;
			} else {
				second.next = first.next;
				first.next = null;
				first = second.next;
			}

		}

		return reverse(firstReverse);

	}

	private static RemoveLoopInLinkedList.Node reverse(RemoveLoopInLinkedList.Node head) {
		RemoveLoopInLinkedList.Node prev = null;
		RemoveLoopInLinkedList.Node current = head;
		RemoveLoopInLinkedList.Node next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	}
}
