package com.datastructures.months2022.may.LinkedListQ;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/06/22
 */
public class ReverseLinkedListInSize {
	public static RemoveLoopInLinkedList.Node reverse(RemoveLoopInLinkedList.Node node, int k) {
		//Your code here

		RemoveLoopInLinkedList.Node temp = node;
		int c = 0;

		while (node != null) {
			c++;
			node = node.next;
		}

		int[] arr = new int[c];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = temp.data;
			temp = temp.next;
		}

		int[] reverseArray = reverseArray(arr, arr.length, k);

		RemoveLoopInLinkedList.Node temp1 = null;

		for (int i = reverseArray.length - 1; i >= 0; i--) {
			RemoveLoopInLinkedList.Node newNode = new RemoveLoopInLinkedList.Node(reverseArray[i]);
			newNode.next = temp1;
			temp1 = newNode;
		}

		return temp1;
	}

	private static int[] reverseArray(int[] arr, int n, int k) {
		for (int i = 0; i < n; i += k) {
			int left = i;
			int right = Math.min(i + k - 1, n - 1);

			while (left <= right) {
				int temp = arr[left];
				arr[left++] = arr[right];
				arr[right--] = temp;
			}
		}
		return arr;
	}

	// Using recursion
	public static RemoveLoopInLinkedList.Node reverseRecursion(RemoveLoopInLinkedList.Node node, int k){
		RemoveLoopInLinkedList.Node current = node;
		RemoveLoopInLinkedList.Node prev = null;
		RemoveLoopInLinkedList.Node next = null;

		int count = 0;

		while (count<k && current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}

		if(next!=null){
			node.next = reverse(next, k);
		}
		return prev;

	}
}
