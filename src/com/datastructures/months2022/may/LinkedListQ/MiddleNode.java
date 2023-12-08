package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 29/05/22
 */
public class MiddleNode {
	public ListNode middleNode(ListNode head) {

		if(head==null){
			return null;
		}

		if(head.next == null){
			return head;
		}

		ListNode rabbit = head;
		ListNode tortoise = head;

		while (rabbit!=null && rabbit.next != null) {
			rabbit = rabbit.next.next;
			tortoise = tortoise.next;
		}

		return head;

	}

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode() {
		}

		public ListNode(int val) {
			this.val = val;
		}

		public ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
