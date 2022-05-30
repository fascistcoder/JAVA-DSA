package com.datastructures.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 29/05/22
 */
public class MaxTwinSum {

	private static MiddleNode.ListNode reverse(MiddleNode.ListNode head) {
		MiddleNode.ListNode prev = null;
		MiddleNode.ListNode currentNode = head;
		MiddleNode.ListNode next;

		while (currentNode != null) {
			next = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = next;
		}

		return prev;
	}

	private static MiddleNode.ListNode mid(MiddleNode.ListNode head) {
		MiddleNode.ListNode slow = head;
		MiddleNode.ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return reverse(slow.next);
	}

	public int pairSum(MiddleNode.ListNode head) {
		MiddleNode.ListNode head2 = mid(head);

		int max = 0;

		while (head != null && head2 != null) {

			max = Math.max(head.val + head2.val, max);

			head = head.next;
			head2 = head2.next;

		}

		return max;

	}
}
