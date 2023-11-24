package com.datastructures.Stack;


import com.datastructures.LinkedList.SinglyLinkedList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 21/11/23
 */
public class StackLL {
	SinglyLinkedList singlyLinkedList;

	public StackLL() {
		singlyLinkedList = new SinglyLinkedList();
	}

	public static void main(String[] args) {
		StackLL stackLL = new StackLL();
		stackLL.push(1);
		stackLL.push(2);

		System.out.println(stackLL.pop());

		System.out.println(stackLL.peek());
	}

	public void push(int val){
		singlyLinkedList.insertInSingleLinkedList(val, 0);
		System.out.println("Insert is successful");
	}

	public boolean isEmpty(){
		return singlyLinkedList.head == null;
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
		}

		int result = -1;
		result = singlyLinkedList.head.value;
		singlyLinkedList.deleteLinkedList(0);
		return result;
	}

	public int peek(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return -1;
		}
		return singlyLinkedList.head.value;
	}

	public void deleteStack(){
		if(isEmpty()){
			System.out.println("Stack is empty");
			return;
		}
		singlyLinkedList.deleteEntireLinkedList();
		System.out.println("Stack is deleted");
	}
}
