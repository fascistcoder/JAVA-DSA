package com.datastructures.Tree.BinaryHeap;

import java.util.Objects;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/12/23
 */
public class BinaryHeap {
	int[] arr;
	int sizeOfTree;

	public BinaryHeap(int size) {
		arr = new int[size + 1];
		this.sizeOfTree = 0;
		System.out.println("binary Heap had been created");
	}

	public static void main(String[] args) {
		BinaryHeap binaryHeap = new BinaryHeap(5);
		binaryHeap.insert(10, "Min");
		binaryHeap.insert(15, "Min");
		binaryHeap.insert(5, "Min");
		binaryHeap.insert(1, "Min");
		binaryHeap.levelOrderTraversal();
		System.out.println(binaryHeap.extractHeadOfBH("Min"));
		binaryHeap.levelOrderTraversal();
	}

	public boolean isEmpty() {
		return sizeOfTree == 0;
	}

	public int peekBH() {
		if (isEmpty()) {
			System.out.println("Binary heap is empty");
			return -1;
		}
		return arr[1];
	}

	public int getSizeOfTree() {
		return sizeOfTree;
	}

	public void levelOrderTraversal() {
		for (int i = 1; i <= sizeOfTree; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	public void heapifyBottomToTop(int index, String heapType) {
		int parent = index / 2;
		if (index <= 1) {
			return;
		}
		if (Objects.equals(heapType, "Min")) {
			if (arr[index] < arr[parent]) {
				int temp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = temp;
			}
		} else if (Objects.equals(heapType, "Max")) {
			if (arr[index] > arr[parent]) {
				int temp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = temp;
			}
		}
		heapifyBottomToTop(parent, heapType);
	}

	public void insert(int value, String heapType) {
		arr[sizeOfTree + 1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree, heapType);
		System.out.println("Value is inserted " + value);
	}

	public void heapifyTopToBottom(int index, String heapType) {
		int left = index * 2;
		int right = index * 2 + 1;
		int swapOfChild;
		if (sizeOfTree < left) {
			return;
		} else if (Objects.equals(heapType, "Max")) {
			if (sizeOfTree == left) {
				if (arr[index] < arr[left]) {
					int temp = arr[index];
					arr[index] = arr[left];
					arr[left] = temp;
				}
				return;
			} else {
				if (arr[right] < arr[left]) {
					swapOfChild = left;
				} else {
					swapOfChild = right;
				}
				if (arr[index] < arr[swapOfChild]) {
					int temp = arr[index];
					arr[index] = arr[swapOfChild];
					arr[swapOfChild] = temp;
				}
			}
		} else if (Objects.equals(heapType, "Min")) {
			if (sizeOfTree == left) {
				if (arr[index] > arr[left]) {
					int temp = arr[index];
					arr[index] = arr[left];
					arr[left] = temp;
				}
				return;
			} else {
				if (arr[right] > arr[left]) {
					swapOfChild = left;
				} else {
					swapOfChild = right;
				}
				if (arr[index] > arr[swapOfChild]) {
					int temp = arr[index];
					arr[index] = arr[swapOfChild];
					arr[swapOfChild] = temp;
				}
			}

			heapifyTopToBottom(swapOfChild, heapType);
		}
	}

	public int extractHeadOfBH(String heapType) {
		if (isEmpty()) {
			return -1;
		} else {
			int extractedValue = arr[1];
			arr[1] = arr[sizeOfTree];
			sizeOfTree--;
			heapifyTopToBottom(1, heapType);
			return extractedValue;
		}
	}

	public void deleteEntireTree() {
		arr = null;
		System.out.println("Successfully Deleted the entire tree");
	}
}
