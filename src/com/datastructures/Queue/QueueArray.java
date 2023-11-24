package com.datastructures.Queue;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 22/11/23
 */
public class QueueArray {
	int[] arr;
	int topOfQueue;

	int beginningQueue;

	public QueueArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginningQueue = -1;
		System.out.println("This queue is created of size " + size);
	}

	public static void main(String[] args) {
		QueueArray queueArray = new QueueArray(4);
		queueArray.enqueue(1);
		queueArray.enqueue(2);
		queueArray.enqueue(3);
		queueArray.enqueue(4);
//		queueArray.enqueue(5);

		System.out.println(Arrays.toString(queueArray.arr));

		System.out.println(queueArray.dequeue());

		System.out.println(queueArray.peek());
	}

	public boolean isEmpty() {
		return beginningQueue == -1 || beginningQueue == arr.length;
	}

	public boolean isFull() {
		return topOfQueue == arr.length - 1;
	}

	public void enqueue(int val) {
		if (isFull()) {
			System.out.println("This Queue is full");
		} else if (isEmpty()) {
			beginningQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = val;
			System.out.println("Value is successfully inserted in top " + val);
		} else {
			topOfQueue++;
			arr[topOfQueue] = val;
			System.out.println("Value is successfully inserted " + val);
		}
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("This queue is empty");
			return -1;
		}
		int top = arr[beginningQueue];
		beginningQueue++;
		if(beginningQueue > topOfQueue){
			beginningQueue = topOfQueue = -1;
		}
		return top;
	}

	public int peek() {
		if (isEmpty()) {
			System.out.println("This queue is empty");
			return -1;
		}
		return arr[beginningQueue];
	}

	public void deleteQueue(){
		if (isEmpty()) {
			System.out.println("This queue is empty");
			return;
		}
		arr = null;
		System.out.println("Queue is deleted successfully");
	}

}
