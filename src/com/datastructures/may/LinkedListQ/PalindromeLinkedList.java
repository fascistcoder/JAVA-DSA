package com.datastructures.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 29/05/22
 */
public class PalindromeLinkedList {

	private static MiddleNode.ListNode reverse(MiddleNode.ListNode head){
		MiddleNode.ListNode prev = null;
		MiddleNode.ListNode currentNode = head;
		MiddleNode.ListNode next = null;

		while (currentNode!=null){
			next = currentNode.next;
			currentNode.next = prev;
			prev = currentNode;
			currentNode = next;
		}

		return prev;
	}

	private static MiddleNode.ListNode mid(MiddleNode.ListNode head){
		MiddleNode.ListNode slow = head;
		MiddleNode.ListNode fast = head;

		while (fast.next != null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}

		return reverse(slow);
	}

	public  boolean isPalindrome(MiddleNode.ListNode head) {
		if(head==null){
			return false;
		}

		if(head.next==null){
			return true;
		}

		MiddleNode.ListNode head1 = mid(head);

		while (head1!=null && head!=null){
			if(head1.val != head.val){
				return false;
			}
			head1 = head1.next;
			head = head.next;
		}
		return true;
	}
}
