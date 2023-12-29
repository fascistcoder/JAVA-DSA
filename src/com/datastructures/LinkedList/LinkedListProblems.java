package com.datastructures.LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/11/23
 */
public class LinkedListProblems {
	public Node head;
	public Node tail;
	public int size;

	public static void main(String[] args) {
		LinkedListProblems linkedListProblems = new LinkedListProblems();

		linkedListProblems.create(1);
		linkedListProblems.insertNode(2);
		linkedListProblems.insertNode(3);
		linkedListProblems.insertNode(3);
		linkedListProblems.insertNode(4);
		linkedListProblems.insertNode(4);
		linkedListProblems.insertNode(5);
		linkedListProblems.traverse();

		linkedListProblems.traverse();
	}

	public void create(int nodeValue) {
		Node newNode = new Node();
		newNode.value = nodeValue;
		newNode.next = null;
		head = newNode;
		tail = newNode;
		size = 1;
	}

	public void insertNode(int nodeValue) {
		if (head == null) {
			create(nodeValue);
		} else {
			Node newNode = new Node();
			newNode.value = nodeValue;
			newNode.next = null;
			tail.next = newNode;
			tail = newNode;
			size++;
		}

	}

	public void traverse() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.value);
			if (temp.next != null) {
				System.out.print(" -> ");
			}

			temp = temp.next;
		}
		System.out.println("\n");
	}

	public Node getIntersectionNode(Node headA, Node headB) {
		if (headA == null || headB == null) {
			return null;
		}

		int headASize = lengthOfLinkedList(headA);
		int headBSize = lengthOfLinkedList(headB);

		Node longer = new Node();
		Node shorter = new Node();

		if (headASize > headBSize) {
			longer = headA;
			shorter = headB;
		} else {
			longer = headB;
			shorter = headA;
		}

		int res = Math.abs(headASize - headBSize);

		for (int i = 0; i < res; i++) {
			longer = longer.next;
		}

		while (longer != shorter) {
			longer = longer.next;
			shorter = shorter.next;
		}

		return longer;
	}

	private int lengthOfLinkedList(Node head) {
		Node temp = head;
		int l = 0;
		while (temp != null) {
			l++;
			temp = temp.next;
		}
		return l;
	}

	public LinkedListProblems sumLists(LinkedListProblems l1, LinkedListProblems l2) {
		Node h1 = l1.head;
		Node h2 = l2.head;
		int carry = 0;
		LinkedListProblems resultLL = new LinkedListProblems();

		while (h1 != null || h2 != null) {
			int result = carry;
			if (h1 != null) {
				result += h1.value;
				h1 = h1.next;
			}
			if (h2 != null) {
				result += h2.value;
				h2 = h2.next;
			}
			resultLL.insertNode(result % 10);
			carry = result / 10;
		}
		return resultLL;
	}

	public void rotate(int number) {
		int index = number;

		if (number < 0) {
			index = number + size;
		}

		if (head == null || number == 0) {
			return;
		}

		Node temp = head;
		Node prev = null;

		while (temp != null) {
			prev = temp;
			temp = temp.next;
		}

		Node newHead = head;
		Node newTail = head;
		Node rotateHead = head;

		for (int i = 0; i < number - 1; i++) {
			newTail = newTail.next;
		}

		newHead = newTail.next;
		newTail.next = null;
		prev.next = rotateHead;

		tail = newTail;
		head = newHead;
	}

	public void removeDuplicates() {
		HashSet<Integer> hashSet = new HashSet<>();

		Node temp = head;
		Node prev = null;

		while (temp != null) {
			if (hashSet.contains(temp.value)) {
				prev.next = temp.next;
			} else {
				hashSet.add(temp.value);
				prev = temp;
			}
			temp = temp.next;
		}

	}

	public boolean set(int index, int value) {
		Node newNode = new Node();
		newNode.value = value;

		if (index >= size || index < 0 || head == null) {
			return false;
		}

		if (index == 0) {
			Node headNext = head.next;
			head = newNode;
			newNode.next = headNext;
		}

		Node tempNode = head;
		Node prev = null;

		for (int i = 0; i < index; i++) {
			prev = tempNode;
			tempNode = tempNode.next;
		}

		if (prev == null) {
			return true;
		}

		Node nextNode = tempNode.next;
		prev.next = newNode;
		newNode.next = nextNode;
		return true;
	}

	public Node deleteDups(Node n) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}

		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}

		int pos = count - n.value;

		Node temp1 = head;

		for (int i = 0; i < pos; i++) {
			temp1 = temp1.next;
		}

		return temp1;
	}

	public void partition(int x) {
		if (head == null) {
			return;
		}

		Node currentNode = head;
		tail = head;

		while (currentNode != null) {
			Node next = currentNode.next;
			if (x < currentNode.value) {
				currentNode.next = head;
				head = currentNode;
			} else {
				tail.next = currentNode;
				tail = currentNode;
			}
			currentNode = next;
		}
		tail.next = null;
	}

	public Node removeNthFromEnd(int n) {
		Node tempNode = head;

		if (head == null) {
			return null;
		}

		int length = 0;
		while (tempNode != null) {
			tempNode = tempNode.next;
			length++;
		}

		if (length == 1) {
			head = null;
			return null;
		}

		int pos = length - n;
		if (pos == 0) {
			Node first = head;
			head = first.next;
			return head;
		}

		Node tempNode2 = head;
		for (int i = 0; i < pos - 1; i++) {
			tempNode2 = tempNode2.next;
		}
		Node delNode = tempNode2.next;
		tempNode2.next = delNode.next;

		return tempNode2;
	}

	public void deleteMiddle() {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}

		if (count == 1) {
			head = null;
		}

		int pos = count / 2;

		Node tempNode2 = head;
		for (int i = 0; i < pos - 1; i++) {
			tempNode2 = tempNode2.next;
		}
		Node delNode = tempNode2.next;
		tempNode2.next = delNode.next;

	}

	public Node swapNodes(int k) {
		// Length of linked list
		if (head == null) {
			return null;
		}

		Node temp = head;
		int l = 0;
		while (temp != null) {
			temp = temp.next;
			l++;
		}

		if (l == 1) {
			return head;
		}

		if (k == l - k + 1) {
			return head;
		}

		if (l == 2) {
			Node first = head;
			Node second = head.next;
			first.next = null;
			second.next = first;

			head = second;
			return head;
		}

		// First
		Node first = head;
		Node firstPrev = null;
		for (int i = 1; i < k; i++) {
			firstPrev = first;
			first = first.next;
		}

		Node second = head;
		Node secondPrev = null;
		int lastPos = l - k + 1;

		for (int i = 1; i < lastPos; i++) {
			secondPrev = second;
			second = second.next;
		}

		if (firstPrev != null) {
			firstPrev.next = second;
		}

		if (secondPrev != null) {
			secondPrev.next = first;
		}

		Node tempNext = first.next;
		first.next = second.next;
		second.next = tempNext;

		if (k == 1) {
			head = second;
		}

		if (k == l) {
			head = first;
		}

		return head;
	}

	public void reorderList() {

		if (head == null || head.next == null) {
			return;
		}

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node mid = slow;
		Node midNext = slow.next;
		mid.next = null;
		//
		Node reverseMiddleList = reverseLinkedList(midNext);

		Node mergeList = mergeAlternateLinkedList(head, reverseMiddleList);
		head = mergeList;
	}

	public static Node reverseLinkedList(Node oddHead) {
		Node prev = null;
		Node current = oddHead;

		while (current != null) {
			Node next;
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		oddHead = prev;
		return oddHead;
	}

	public static Node mergeAlternateLinkedList(Node beforeMiddleList, Node reverseMiddleList) {
		Node beforeListCurr = beforeMiddleList;
		Node afterListCurr = reverseMiddleList;
		Node beforeListNext, afterListNext;
		Node mergedHead = beforeListCurr; // Updated to use the head of the reversed odd list

		while (beforeListCurr != null && afterListCurr != null) {

			beforeListNext = beforeListCurr.next;
			afterListNext = afterListCurr.next;

			beforeListCurr.next = afterListCurr;
			afterListCurr.next = beforeListNext;

			beforeListCurr = beforeListNext;
			afterListCurr = afterListNext;
		}

		return mergedHead;
	}

	public void oddEvenLinkedList() {

		if (head == null || head.next == null || head.next.next == null) {
			return;
		}

		Node evenHead = null;
		Node oddHead = null;
		Node evenTail = null;
		Node oddTail = null;
		Node temp1 = head;
		int index = 1;

		while (temp1 != null) {
			if (index % 2 == 0) {
				if (evenHead == null) {
					evenHead = temp1;
				} else {
					evenTail.next = temp1;
				}
				evenTail = temp1;
			} else {
				if (oddHead == null) {
					oddHead = temp1;
				} else {
					oddTail.next = temp1;
				}
				oddTail = temp1;
			}
			temp1 = temp1.next;
			index++;
		}
		oddTail.next = evenHead;
		evenTail.next = null;

		head = oddHead;

		//	Node merge = mergeAlternateLinkedList(oddHead, evenHead);

	}

	public boolean isPalindrome() {
		if (head == null || head.next == null) {
			return true;
		}

		Node fast = head;
		Node slow = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node reverseMid = reverseList(slow);

		while (reverseMid != null && head != null) {
			if (reverseMid.value != head.value) {
				return false;
			}
			reverseMid = reverseMid.next;
			head = head.next;
		}

		return true;
	}

	public Node reverseList(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node current = head;
		Node prev = null;

		while (current != null) {
			Node next;
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;

	}

	public boolean isPalindrome(String s) {
		String modify = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

		StringBuilder stringBuilder = new StringBuilder(modify);
		String rev = stringBuilder.reverse().toString();
		System.out.println(rev);
		System.out.println(modify);
		return modify.equals(rev);
	}

	public void removeElements(int val) {
		if (head == null) {
			return;
		}

		if (head.next == null && head.value == val) {
			return;
		}

		if (head.next == null) {
			return;
		}

		while (head != null && head.value == val) {
			head = head.next;
		}

		Node temp = head;
		Node prev = null;

		while (temp != null) {
			if (temp.value == val) {
				prev.next = temp.next;
			} else {
				prev = temp;
			}
			temp = temp.next;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode current = dummy;

		while (current.next != null && current.next.next != null) {
			if (current.next.val == current.next.next.val) {
				int dupVal = current.next.val;
				while (current.next != null && current.next.val == dupVal) {
					current.next = current.next.next;
				}
			} else {
				current = current.next;
			}
		}
		return dummy.next;
	}

	public ListNode sortList(ListNode head) {
		ListNode temp = head;
		List<Integer> list = new ArrayList<>();

		while (temp != null) {
			list.add(temp.val);
			temp = temp.next;
		}

		list.sort(Collections.reverseOrder());

		head = null;

		for (Integer integer : list) {
			ListNode newNode = new ListNode(integer);
			newNode.next = head;
			head = newNode;
		}
		return head;
	}

	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head.next == null) {
			return head;
		}

		List<Integer> list = new ArrayList<>();
		ListNode leftTemp = head;
		for (int i = 0; i < left; i++) {
			leftTemp = leftTemp.next;
		}

		for (int i = left; i < right; i++) {
			list.add(leftTemp.val);
			leftTemp = leftTemp.next;
		}

		Collections.reverse(list);

		return null;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		}

		if (list1 == null && list2.next == null) {
			return list2;
		}

		if (list1.next == null && list2 == null) {
			return list1;
		}

		ListNode l1 = list1;
		ListNode l2 = list2;

		ListNode mergeList = new ListNode();
		if (l1.val < l2.val) {
			mergeList = l1;
			l1 = l1.next;
		} else {
			mergeList = l2;
			l2 = l2.next;
		}
		ListNode current = mergeList;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}

		if (l1 != null) {
			current.next = l1;
		}

		if (l2 != null) {
			current.next = l2;
		}

		return current;
	}
}
