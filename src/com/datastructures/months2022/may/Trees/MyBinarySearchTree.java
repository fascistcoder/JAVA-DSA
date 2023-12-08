package com.datastructures.months2022.may.Trees;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 05/06/22
 */
public class MyBinarySearchTree {

	private MyBinaryNode root;

	public MyBinarySearchTree() {
		root = null;
	}

	public void insert(int value){
		if(root == null){
			root = new MyBinaryNode(value);
			return;
		}

		MyBinaryNode currentNode = root;

		while(true){
			if(currentNode.getValue() > value){
				// left
				if(currentNode.getLeft() == null){
					currentNode.setLeft(new MyBinaryNode(value));
					return;
				}
				currentNode = currentNode.getLeft();
			}else {
				if(currentNode.getRight() == null){
					currentNode.setRight(new MyBinaryNode(value));
					return;
				}
				currentNode = currentNode.getRight();
			}
		}
	}

	public MyBinaryNode lookUp(int value){
		if(root == null){
			return null;
		}

		MyBinaryNode currentNode = root;

		while (currentNode != null){
			if(value < currentNode.getValue()){
				currentNode = currentNode.getLeft();
			}else if(value > currentNode.getValue()){
				currentNode = currentNode.getRight();
			}else {
				return currentNode;
			}
		}
		return null;
	}

	public void remove(int value){
		if(root==null){
			return;
		}

		MyBinaryNode nodeToRemove= root;
		MyBinaryNode parentNode = null;

		while (nodeToRemove.getValue() != value){
			parentNode = nodeToRemove;
			if(value< nodeToRemove.getValue()){
				nodeToRemove = nodeToRemove.getLeft();
			}else {
				nodeToRemove = nodeToRemove.getRight();
			}
		}

		MyBinaryNode replacementNode = null;
		if (nodeToRemove.getRight() != null) { //We have a right node
			replacementNode = nodeToRemove.getRight();
			if(replacementNode.getLeft() == null) { //We don't have a left node
				replacementNode.setLeft(nodeToRemove.getLeft());
			} else { //We have a left node, lets find the leftmost
				MyBinaryNode replacementParentNode = nodeToRemove;
				while (replacementNode.getLeft() != null) {
					replacementParentNode = replacementNode;
					replacementNode = replacementNode.getLeft();
				}
				replacementParentNode.setLeft(null);
				replacementNode.setLeft(nodeToRemove.getLeft());
				replacementNode.setRight(nodeToRemove.getRight());
			}
		} else if(nodeToRemove.getLeft() != null) {//We only have a left node
			replacementNode = nodeToRemove.getLeft();
		}

		if(parentNode == null) {
			root = replacementNode;
		} else if(parentNode.getLeft() == nodeToRemove) { //We are a left child
			parentNode.setLeft(replacementNode);
		} else { //We are a right child
			parentNode.setRight(replacementNode);
		}

	}

	int count = 0;
	public void printTree(){
		count = 0;
		printTree(root);
	}

	public void printTree(MyBinaryNode node){
		System.out.println(node.getValue());
		System.out.println();
		count++;

		if(node.getLeft()!=null){
			System.out.println("\t".repeat(Math.max(0,count))+ "Left: ");
			printTree(node.getLeft());
		}

		if(node.getRight()!=null){
			System.out.println("\t".repeat(Math.max(0,count))+ "Right: ");
			printTree(node.getRight());
		}

		count--;
	}

	public static void main(String[] args) {
		MyBinarySearchTree tree = new MyBinarySearchTree();
		tree.insert(9);
		tree.insert(4);
		tree.insert(20);
		tree.insert(1);
		tree.insert(6);
		tree.insert(15);
		tree.insert(170);
		tree.printTree();
//		tree.remove(20);
//		tree.remove(4);
//		tree.printTree();
//		tree.insert(20);
//		tree.insert(18);
//		tree.insert(10);
//		tree.printTree();
//		tree.remove(170);
//		tree.printTree();
	}
}
