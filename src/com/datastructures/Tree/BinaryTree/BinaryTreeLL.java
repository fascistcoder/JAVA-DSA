package com.datastructures.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/12/23
 */
public class BinaryTreeLL {
	BinaryNode root;

	public BinaryTreeLL() {
		this.root = null;
	}

	public static void main(String[] args) {
		BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
		binaryTreeLL.insertNodeInTree("N1");
		binaryTreeLL.insertNodeInTree("N2");
		binaryTreeLL.insertNodeInTree("N3");
		binaryTreeLL.insertNodeInTree("N4");
		binaryTreeLL.insertNodeInTree("N5");
		binaryTreeLL.insertNodeInTree("N6");
		binaryTreeLL.insertNodeInTree("N7");
		binaryTreeLL.insertNodeInTree("N8");
		binaryTreeLL.insertNodeInTree("N9");

		binaryTreeLL.preOrderTraversal(binaryTreeLL.root);
		System.out.println("\n");
		binaryTreeLL.postOrderTraversal(binaryTreeLL.root);
		System.out.println("\n");
		binaryTreeLL.inOrderTraversal(binaryTreeLL.root);
		System.out.println("\n");
		binaryTreeLL.levelOrderTraversal();
		System.out.println("\n");

		binaryTreeLL.searchInTree("n7");
		binaryTreeLL.searchInTree("n11");

		binaryTreeLL.deleteNodeInTree("N4");
		binaryTreeLL.levelOrderTraversal();
	}

	public void preOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.value + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	public void postOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.value + " ");
	}

	public void inOrderTraversal(BinaryNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		System.out.print(node.value + " ");
		inOrderTraversal(node.right);
	}

	public void levelOrderTraversal() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
	}

	public void searchInTree(String val) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			;
			if (Objects.equals(presentNode.value, val)) {
				System.out.println("Value is present in the tree " + presentNode.value);
				return;
			}
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
		System.out.println("Value is not present in the tree ");
	}

	public void insertNodeInTree(String val) {
		BinaryNode newNode = new BinaryNode();
		newNode.value = val;
		if (root == null) {
			root = newNode;
			System.out.println("Inserted new Node at Root");
		} else {
			Queue<BinaryNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BinaryNode presentNode = queue.remove();
				if (presentNode.left == null) {
					presentNode.left = newNode;
					System.out.println("SuccessFully Inserted");
					break;
				} else if (presentNode.right == null) {
					presentNode.right = newNode;
					System.out.println("SuccessFully Inserted");
					break;
				} else {
					queue.add(presentNode.left);
					queue.add(presentNode.right);
				}
			}
		}
	}

	// Get Deepest node
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode presentNode = null;
		while (!queue.isEmpty()) {
			presentNode = queue.remove();
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
		return presentNode;
	}

	public void deleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while (!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if (presentNode.left == null) {
				previousNode.right = null;
				return;
			} else if (presentNode.right == null) {
				presentNode.left = null;
				return;
			}
			queue.add(presentNode.left);
			queue.add(presentNode.right);
		}
	}

	public void deleteNodeInTree(String val) {
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (Objects.equals(presentNode.value, val)) {
				presentNode.value = getDeepestNode().value;
				deleteDeepestNode();
				System.out.println("Node is deleted ");
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
	}

	public void deleteEntireTree() {
		root = null;
		System.out.println("Binary tree had been deleted successfully deleted");
	}
}
