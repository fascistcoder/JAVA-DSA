package com.datastructures.may.LinkedListQ;

import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/06/22
 */
public class RemoveLoopInLinkedList {

	static class Node {
		int data;
		Node next;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
			this.next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	// O(n) o(n)
	public static void removeLoop(Node head) {

		HashSet<Node> hashSet = new HashSet<>();

		while (head.next != null) {
			if (hashSet.contains(head.next)) {
				head.next = null;
				break;
			}

			hashSet.add(head);
			head = head.next;
		}

	}

	// O(n) O(1)
	public static void removeLoopOptimized(Node head) {

		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				break;
			}
		}

		if (fast != slow) {
			return;
		}

		slow = head;

		if (slow == fast) {
			while (fast.next != slow) {
				fast = fast.next;
			}
		} else {
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
		}

		fast.next = null;

	}

	public static int peakElement(int[] arr,int n)
	{
		//add code here.
//		int start = 0;
//		int end = n-1;
//
//		int index = 0;
//
//		while (start < end){
//			if(arr[start] > arr[end]){
//				index = start;
//				end --;
//			}else {
//				index = end;
//				start ++;
//			}
//		}
//		return index;

		int count  =0;

		for (int i=0;i<n-1;i++){
			if(arr[i] < arr[i+1]){
				count = Math.max(count , i+1);
			}
		}

		return count;
	}

	public static void main(String[] args) {

		int a[] = new int[] {6, 1, 15, 19, 9, 13, 12, 6, 7, 2, 10, 4, 1, 14, 11, 14, 14, 13 };

		System.out.println(peakElement(a, 18));
	}

}
