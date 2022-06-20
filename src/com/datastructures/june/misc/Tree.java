package com.datastructures.june.misc;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 17/06/22
 */
public class Tree{
	static class Node {
		String name;
		Node[] child;
		Node(String name, int no_of_children){
			this.name = name;
			this.child = new Node[no_of_children];
		}
	};

	static Node BuildKaryTree(String A[], int ind, int no_of_children, int h){
		if (ind >= A.length) return null;

		Node nNode = new Node(A[ind], no_of_children);
		ind++;

		for (int i = 0; i < no_of_children; i++){
			if (ind < A.length && h > 1) nNode.child[i] = BuildKaryTree(A, ind, no_of_children, h - 1);
			else nNode.child[i] = null;

		}
		return nNode;
	}

	// Function to find the height of the tree
	static int getht(int n, int no_of_children){
		return (int) (Math.log(n * (no_of_children - 1) + 1) / Math.log(no_of_children));
	}

	// Function to print postorder traversal of the tree
	static void postord(Node root, int no_of_children){
		if (root == null) return;
		for (int i = 0; i < no_of_children; i++) {
			postord(root.child[i], no_of_children);
		}

	}


	public static void main(String args[]){
		String arr[] = {"World", "Asia", "Africa", "China", "India", "SouthAfrica", "Egypt"};
		int ind = 0, no_of_children = 2, n = arr.length;
		int height = getht(n, no_of_children);

		Node root = BuildKaryTree(arr, ind, no_of_children, height);

		System.out.println("Postorder traversal of " +
				"constructed full k-ary tree is: ");
		postord(root, no_of_children);
		System.out.println();
	}
}
