package com.datastructures.months2022.may.LinkedListQ;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/06/22
 */
public class Add1 {
	public static RemoveLoopInLinkedList.Node addOne(RemoveLoopInLinkedList.Node head) {
		//code here.

		RemoveLoopInLinkedList.Node temp = head;

		int c= 0;

		while (head != null) {
			c++;
			head = head.next;
		}

		int[] a = new int[c];
		int j = 0;

		while (temp != null) {
			a[j] = temp.data;
			temp = temp.next;
			j++;
		}

		Arrays.sort(a);

		RemoveLoopInLinkedList.Node p = null;

		for (int i = a.length - 1; i >= 0; i--) {
			RemoveLoopInLinkedList.Node newNode = new RemoveLoopInLinkedList.Node(a[i]);
			newNode.next = p;
			p = newNode;
		}

		return p;
	}
}
