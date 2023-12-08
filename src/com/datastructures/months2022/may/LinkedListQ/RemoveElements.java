package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/05/22
 */
public class RemoveElements {

	public static ListNode removeElements(ListNode head, int val) {

		ListNode currentNode = head;

		while (head!=null && head.val==val){
			head = head.next;
		}

		while (currentNode != null && currentNode.next != null){
			if(currentNode.next.val == val){
				currentNode.next = currentNode.next.next;
			}else{
				currentNode = currentNode.next;
			}
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

	public static void main(String[] args) {

	}
}
