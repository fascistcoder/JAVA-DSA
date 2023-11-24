package com.datastructures.Queue;

import com.datastructures.LinkedList.SinglyLinkedList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 22/11/23
 */
public class QueueLL {
	SinglyLinkedList singlyLinkedList;

	int front = 0;

	public QueueLL(){
		singlyLinkedList = new SinglyLinkedList();
	}

	public static void main(String[] args) {
		QueueLL queueLL = new QueueLL();
		queueLL.push(4);
		queueLL.push(5);

		queueLL.singlyLinkedList.traverseLinkedList();
		System.out.println(queueLL.pop());

		queueLL.push(8);
		queueLL.push(9);
		queueLL.singlyLinkedList.traverseLinkedList();

		System.out.println(queueLL.pop());

		System.out.println(queueLL.peek());
	}

	public void push(int val) {
		singlyLinkedList.insertInSingleLinkedList(val, singlyLinkedList.size);
	}

	public boolean isEmpty(){
		return singlyLinkedList.head == null;
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}

		int result = -1;
		result = singlyLinkedList.head.value;
		singlyLinkedList.deleteLinkedList(0);
		return result;
	}

	public int peek(){
		if(isEmpty()){
			System.out.println("Queue is empty");
			return -1;
		}
		return singlyLinkedList.head.value;
	}

	public void deleteStack(){
		if(isEmpty()){
			System.out.println("queue is empty");
			return;
		}
		singlyLinkedList.deleteEntireLinkedList();
		System.out.println("queue is deleted");
	}

}
