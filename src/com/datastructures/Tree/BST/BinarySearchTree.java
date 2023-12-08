package com.datastructures.Tree.BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/12/23
 */
public class BinarySearchTree {
	BSTNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(70);
		binarySearchTree.insert(50);
		binarySearchTree.insert(90);
		binarySearchTree.insert(30);
		binarySearchTree.insert(60);
		binarySearchTree.insert(80);
		binarySearchTree.insert(100);
		binarySearchTree.insert(20);
		binarySearchTree.insert(40);

		System.out.print("\n");
		binarySearchTree.preOrderTraversal(binarySearchTree.root);
		System.out.print("\n");
		binarySearchTree.inOrderTraversal(binarySearchTree.root);
		System.out.print("\n");
		binarySearchTree.postOrderTraversal(binarySearchTree.root);
		System.out.print("\n");
		binarySearchTree.levelOrderTraversal();
		System.out.print("\n");
		binarySearchTree.searchInBST(40);
		binarySearchTree.optimizedSearch(binarySearchTree.root, 100);
		binarySearchTree.optimizedSearch(binarySearchTree.root, 101);
		binarySearchTree.deleteNode(binarySearchTree.root, 70);
		binarySearchTree.levelOrderTraversal();
	}

	private BSTNode insertInBST(BSTNode currentNode, int val) {

		if (currentNode == null) {
			BSTNode newNode = new BSTNode();
			newNode.value = val;
			return newNode;
		} else if (val <= currentNode.value) {
			currentNode.left = insertInBST(currentNode.left, val);
			return currentNode;
		} else {
			currentNode.right = insertInBST(currentNode.right, val);
			return currentNode;
		}
	}

	void insert(int val) {
		root = insertInBST(root, val);
	}

	void preOrderTraversal(BSTNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.value + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	void postOrderTraversal(BSTNode node) {
		if (node == null) {
			return;
		}

		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + " ");
	}

	void inOrderTraversal(BSTNode node) {
		if (node == null) {
			return;
		}

		inOrderTraversal(node.left);
		System.out.print(node.value + " ");
		inOrderTraversal(node.right);
	}

	void levelOrderTraversal() {
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BSTNode presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
	}

	BSTNode optimizedSearch(BSTNode node, int val) {
		if (node == null) {
			System.out.println("Value is not present in the tree");
			return null;
		} else if (node.value == val) {
			System.out.println("Value is found in BST " + val);
			return node;
		} else if (node.value < val) {
			return optimizedSearch(node.right, val);
		} else {
			return optimizedSearch(node.left, val);
		}
	}

	void searchInBST(int val) {
		Queue<BSTNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BSTNode presentNode = queue.remove();
			if (presentNode.value == val) {
				System.out.println("Value is found in BST ");
				return;
			} else {
				if (presentNode.left != null) {
					queue.add(presentNode.left);
				}
				if (presentNode.right != null) {
					queue.add(presentNode.right);
				}
			}
		}
		System.out.println("Value is not present in the tree ");
	}

	//Minimum node
	public static BSTNode minNode(BSTNode root) {
		if (root.left == null) {
			return root;
		} else {
			return minNode(root.left);
		}
	}

	// Delete a node
	public BSTNode deleteNode(BSTNode root, int val) {
		if (root == null) {
			System.out.println("Value is not found in the bst");
			return null;
		} else if (val < root.value) {
			root.left = deleteNode(root.left, val);
		} else if (val > root.value) {
			root.right = deleteNode(root.right, val);
		} else {
			if (root.left != null && root.right != null) {
				BSTNode min = minNode(root.right);
				root.value = min.value;
				root.right = deleteNode(root.right, min.value);
			} else if (root.left != null) {
				root = root.left;
			} else if (root.right != null) {
				root = root.right;
			} else {
				root = null;
			}
		}
		return root;
	}

	public void deleteEntireBST() {
		root = null;
		System.out.println("Binary Search tree had been deleted successfully deleted");
	}
}
