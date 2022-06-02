package com.datastructures.may.LinkedListQ;

import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/06/22
 */
public class RemoveDuplicatesLinkedList {
	public RemoveLoopInLinkedList.Node removeDuplicates(RemoveLoopInLinkedList.Node head) {
		// Your code here
		RemoveLoopInLinkedList.Node temp = head;
		RemoveLoopInLinkedList.Node prev = null;

		HashSet<Integer> hashSet = new HashSet<>();

		while (temp != null) {

			if (hashSet.contains(temp.data)) {
				prev.next = temp.next;
			} else {
				hashSet.add(temp.data);
				prev = temp;
			}
			temp = temp.next;
		}

		return head;
	}
}
