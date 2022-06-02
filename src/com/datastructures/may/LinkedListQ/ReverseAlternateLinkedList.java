package com.datastructures.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/06/22
 */
public class ReverseAlternateLinkedList {
	public static RemoveLoopInLinkedList.Node rearrange(RemoveLoopInLinkedList.Node head) {
		// add your code here

		if(head == null || head.next == null) return head;

		RemoveLoopInLinkedList.Node currentNode = head;

		boolean bit = true;

		while (currentNode.next != null) {
			if (bit) {
				if (currentNode.data > currentNode.next.data) {
					int holdingData = currentNode.next.data;
					currentNode.next.data = currentNode.data;
					currentNode.data = holdingData;
				}
			} else {
				if (currentNode.data < currentNode.next.data) {
					int holdingData = currentNode.next.data;
					currentNode.next.data = currentNode.data;
					currentNode.data = holdingData;
				}
			}
			bit = !bit;
			currentNode = currentNode.next;
		}

		return head;
	}
}
