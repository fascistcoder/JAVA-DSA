package com.datastructures.Stack;

import java.util.ArrayList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/11/23
 */
public class MyStack {
	public ArrayList<Integer> queue;
	int index;

	public MyStack() {
		this.queue = new ArrayList<>();
		this.index = 0;
	}

	public void push(int x) {
		queue.add(x);
	}

	public int pop() {
		int ele = queue.remove(index);
		return ele;

	}

	public int top() {
		return queue.get(index);
	}

	public boolean empty() {
		return queue.isEmpty();
	}

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		System.out.println(myStack.empty());

		myStack.push(4);
		myStack.push(5);
		myStack.push(6);

		System.out.println(myStack.pop());
		System.out.println(myStack.top());
	}
}
