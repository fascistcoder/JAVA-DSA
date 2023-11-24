package com.datastructures.Queue;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 22/11/23
 */
public class CircularQueue {
	int[] arr;
	int topOfQueue;

	int beginningQueue;

	int size;

	public CircularQueue(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginningQueue = -1;
		this.size = size;
		System.out.println("This queue is created of size " + size);
	}

	public static void main(String[] args) {
		CircularQueue circularQueue = new CircularQueue(3);
		circularQueue.enqueue(2);
		circularQueue.enqueue(3);
		circularQueue.enqueue(4);

		System.out.println(circularQueue.dequeue());
		circularQueue.enqueue(5);

		System.out.println(circularQueue.dequeue());

	}

	public boolean isEmpty() {
		return beginningQueue == -1 || topOfQueue == -1;
	}

	public boolean isFull() {
		if (topOfQueue + 1 == beginningQueue) {
			return true;
		} else
			return beginningQueue == 0 && topOfQueue + 1 == size;
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
			if (topOfQueue + 1 == size) {
				topOfQueue = 0;
			} else {
				topOfQueue++;
			}
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
		arr[beginningQueue] = 0;
		if (beginningQueue == topOfQueue) {
			beginningQueue = topOfQueue = -1;
		} else if (beginningQueue +1 == size -1 ) {
			beginningQueue = 0;
		} else {
			beginningQueue++;
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

	public void deleteQueue() {
		if (isEmpty()) {
			System.out.println("This queue is empty");
			return;
		}
		arr = null;
		System.out.println("Queue is deleted successfully");
	}
}
