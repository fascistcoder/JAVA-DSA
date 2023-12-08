package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/05/22
 */
public class DeleteMiddle {

	private static int countNoOfListElements(ListNode1 node1) {
		int count = 1;

		while (node1 != null) {
			node1 = node1.next;
			count++;
		}

		return count;
	}

	public static ListNode1 deleteMiddle(ListNode1 head) {

		if(head==null){
			return null;
		}

		if(head.next == null){
			return null;
		}

		ListNode1 currentNode = head;

		int count = countNoOfListElements(currentNode);

		int mid = count / 2;

		while (mid-- > 1){
			head = head.next;
		}

		head.next= head.next.next;

		return head;
	}

	// Optmized way


	public static ListNode1 deleteMiddleOptimized(ListNode1 head) {

		if(head==null){
			return null;
		}

		if(head.next == null){
			return null;
		}

		ListNode1 prev = null;

		ListNode1 rabbit = head;
		ListNode1 tortoise = head;

		while (rabbit != null && rabbit.next !=null){
			rabbit = rabbit.next.next;
			prev = tortoise;
			tortoise = tortoise.next;
		}

		prev.next = tortoise.next;

		return head;
	}

	public static class ListNode1 {
		int val;
		ListNode1 next;

		public ListNode1() {
		}

		public ListNode1(int val) {
			this.val = val;
		}

		public ListNode1(int val, ListNode1 next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {

	}
}
