package com.datastructures.LinkedList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 18/11/23
 */
public class SinglyLinkedList {
	public Node head;
	public Node tail;
	public int size;

	public static void main(String[] args) {
		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
		singlyLinkedList.createSinglyLinkedList(1);
		singlyLinkedList.insertInSingleLinkedList(1, 1);
		singlyLinkedList.insertInSingleLinkedList(2, 2);
		singlyLinkedList.insertInSingleLinkedList(6, 3);
		singlyLinkedList.insertInSingleLinkedList(3, 4);
		singlyLinkedList.insertInSingleLinkedList(4, 4);
		singlyLinkedList.insertInSingleLinkedList(5, 5);
		singlyLinkedList.insertInSingleLinkedList(6, 6);

		singlyLinkedList.traverseLinkedList();

		singlyLinkedList.searchLinkedList(14);
		singlyLinkedList.searchLinkedList(90);
		singlyLinkedList.searchLinkedList(1);

		singlyLinkedList.deleteLinkedList(5);
		singlyLinkedList.traverseLinkedList();

		singlyLinkedList.deleteEntireLinkedList();
		singlyLinkedList.traverseLinkedList();

		singlyLinkedList.removeNthFromEnd(2);
		System.out.println(singlyLinkedList.isPalindrome());
		singlyLinkedList.isPalindrome();
		singlyLinkedList.removeElements(1);
		singlyLinkedList.traverseLinkedList();

		//		System.out.println(singlyLinkedList.isPalindrome("A man, a plan, a canal: Panama"));
	}

	public Node createSinglyLinkedList(int nodeVal) {
		head = new Node();
		Node node = new Node();
		node.next = null;
		node.value = nodeVal;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	// Insert Method
	public void insertInSingleLinkedList(int val, int location) {
		Node node = new Node();
		node.value = val;
		if (head == null) {
			createSinglyLinkedList(val);
		} else if (location == 0) {
			node.next = head;
			head = node;
		} else if (location >= size) {
			node.next = null;
			tail.next = node;
			tail = node;
		} else {
			Node tempNode = head;
			int index = 0;
			while (index < location - 1) {
				tempNode = tempNode.next;
				index++;
			}
			Node nextNode = tempNode.next;
			tempNode.next = node;
			node.next = nextNode;
		}
		size++;
	}

	public void traverseLinkedList() {
		if (head == null) {
			System.out.println("SLL does not exist");
		}

		Node tempNode = head;
		while (tempNode != null) {
			System.out.print(tempNode.value);
			if (tempNode.next != null) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.next;
		}

		System.out.println("\n");
	}

	public void searchLinkedList(int val) {
		if (head == null) {
			System.out.println("SLL does not exist");
		}

		Node tempNode = head;
		int i = 0;
		while (tempNode != null) {
			if (tempNode.value == val) {
				System.out.println("Value is found in the linked list at index " + i);
				return;
			}
			tempNode = tempNode.next;
			i++;
		}
		System.out.println("Value is  not found in the Linked list");
	}

	public void deleteLinkedList(int location) {
		if (head == null) {
			System.out.println("SLL does not exist");
			return;
		} else if (location == 0) {
			Node first = head;
			head = first.next;
			size--;
			if (size == 0) {
				tail = null;
			}
		} else if (location >= size) {
			Node tempNode = head;
			Node prevNode = null;
			while (tempNode.next != null) {
				prevNode = tempNode;
				tempNode = tempNode.next;
			}
			if (prevNode == null) {
				tail = head = null;
				size--;
				return;
			}
			prevNode.next = null;
			tail = prevNode;
			size--;
		} else {
			Node tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.next;
			}
			Node deleteNode = tempNode.next;
			tempNode.next = deleteNode.next;
			size--;
		}
	}

	public void deleteEntireLinkedList() {
		head = null;
		tail = null;
		System.out.println("Entire Linked lIst deleted successfully");
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
}
