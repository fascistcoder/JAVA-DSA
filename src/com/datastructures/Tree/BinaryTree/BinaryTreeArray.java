package com.datastructures.Tree.BinaryTree;

import java.util.Objects;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/12/23
 */
public class BinaryTreeArray {
	String[] arr;
	int lastUsedIndex;

	public BinaryTreeArray(int size) {
		arr = new String[size + 1];
		this.lastUsedIndex = 0;
		System.out.println("Tree size " + size);
	}

	public static void main(String[] args) {
		BinaryTreeArray binaryTreeArray = new BinaryTreeArray(9);
		binaryTreeArray.insertNode("N1");
		binaryTreeArray.insertNode("N2");
		binaryTreeArray.insertNode("N3");
		binaryTreeArray.insertNode("N4");
		binaryTreeArray.insertNode("N5");
		binaryTreeArray.insertNode("N6");
		binaryTreeArray.insertNode("N7");
		binaryTreeArray.insertNode("N8");
		binaryTreeArray.insertNode("N9");

		binaryTreeArray.preOrderTraversal(1);
		System.out.print("\n");
		binaryTreeArray.inOrderTraversal(1);
		System.out.print("\n");
		binaryTreeArray.postOrderTraversal(1);
		System.out.print("\n");
		binaryTreeArray.levelOrderTraversal();
		System.out.print("\n");
		binaryTreeArray.searchInTree("N4");
		binaryTreeArray.searchInTree("N11");
		binaryTreeArray.deleteInTree("N5");
		binaryTreeArray.levelOrderTraversal();
	}

	boolean isFull() {
		return arr.length - 1 == lastUsedIndex;
	}

	public void insertNode(String val) {
		if (!isFull()) {
			arr[lastUsedIndex + 1] = val;
			lastUsedIndex++;
			System.out.println("The value of " + val + " has been inserted");
		} else {
			System.out.println("Binary Tree is Full");
		}
	}

	public void preOrderTraversal(int i) {
		if (i > lastUsedIndex) {
			return;
		}

		System.out.print(arr[i] + " ");
		preOrderTraversal(2 * i);
		preOrderTraversal(2 * i + 1);
	}

	public void inOrderTraversal(int i) {
		if (i > lastUsedIndex) {
			return;
		}

		inOrderTraversal(2 * i);
		System.out.print(arr[i] + " ");
		inOrderTraversal(2 * i + 1);
	}

	public void postOrderTraversal(int i) {
		if (i > lastUsedIndex) {
			return;
		}

		postOrderTraversal(2 * i);
		postOrderTraversal(2 * i + 1);
		System.out.print(arr[i] + " ");
	}

	public void levelOrderTraversal() {
		for (int i = 1; i <= lastUsedIndex; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public void searchInTree(String val) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (Objects.equals(arr[i], val)) {
				System.out.println("Value is present in the tree " + arr[i] + " at index " + i);
				return;
			}
		}
		System.out.println("Value is not present in the tree");
	}

	public void deleteInTree(String val) {
		for (int i = 1; i <= lastUsedIndex; i++) {
			if (Objects.equals(arr[i], val)) {
				arr[i] = arr[lastUsedIndex];
				lastUsedIndex--;
				return;
			}
		}
	}

	public void deleteTree(){
		try{
			arr = null;
			System.out.println("Tree had been deleted");
		}catch (Exception e){
			System.out.println("There was an error to delete the tree");
		}
	}
}
