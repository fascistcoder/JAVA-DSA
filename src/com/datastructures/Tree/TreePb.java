package com.datastructures.Tree;

import com.datastructures.LinkedList.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/12/23
 */
public class TreePb {

	TreeNode root;

	public TreePb() {
		this.root = null;
	}

	List<Integer> res = new ArrayList<>();
	List<List<Integer>> result = new ArrayList<>();

	public static void main(String[] args) {
		TreePb binaryTreeLL = new TreePb();
		binaryTreeLL.insertNodeInTree(5);
		binaryTreeLL.insertNodeInTree(8);
		binaryTreeLL.insertNodeInTree(9);
		binaryTreeLL.insertNodeInTree(2);
		binaryTreeLL.insertNodeInTree(1);
		binaryTreeLL.insertNodeInTree(3);
		binaryTreeLL.insertNodeInTree(7);
		binaryTreeLL.insertNodeInTree(4);
		binaryTreeLL.insertNodeInTree(6);
		//		binaryTreeLL.levelOrderTraversal();
		//		binaryTreeLL.maxDepth();
		//		binaryTreeLL.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
		//		binaryTreeLL.levelOrderTraversal();
		//		binaryTreeLL.findSecondMinimumValue(binaryTreeLL.root);
		binaryTreeLL.kthLargestLevelSum(binaryTreeLL.root, 2);
	}

	public void insertNodeInTree(int val) {
		TreeNode newNode = new TreeNode();
		newNode.val = val;
		if (root == null) {
			root = newNode;
		} else {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				TreeNode presentNode = queue.remove();
				if (presentNode.left == null) {
					presentNode.left = newNode;
					break;
				} else if (presentNode.right == null) {
					presentNode.right = newNode;
					break;
				} else {
					queue.add(presentNode.left);
					queue.add(presentNode.right);
				}
			}
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			res.add(root.val);
			inorderTraversal(root.right);
		}
		return res;
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		if (root != null) {
			res.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		return res;
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			res.add(root.val);
		}
		return res;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null || q == null || p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public List<List<Integer>> levelOrderTraversal() {
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelNodes = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {

				TreeNode presentNode = queue.remove();
				levelNodes.add(presentNode.val);
				if (presentNode.left != null) {
					queue.add(presentNode.left);
				}
				if (presentNode.right != null) {
					queue.add(presentNode.right);
				}

			}
			result.add(levelNodes);
		}
		System.out.println(result);
		return result;
	}

	public int maxDepth() {
		if (root == null) {
			return -1;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelNodes = new ArrayList<>();
			for (int i = 0; i < levelSize; i++) {

				TreeNode presentNode = queue.remove();
				levelNodes.add(presentNode.val);
				if (presentNode.left != null) {
					queue.add(presentNode.left);
				}
				if (presentNode.right != null) {
					queue.add(presentNode.right);
				}

			}
			result.add(levelNodes);
		}
		return result.size();
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isMirror(root.left, root.right);
	}

	private boolean isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (left == null || right == null) {
			return false;
		}

		return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
	}

	public int getMinimumDifference(TreeNode root) {
		if (root == null) {
			return 0;
		}

		List<Integer> list = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode presentNode = queue.remove();
			list.add(presentNode.val);
			if (presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if (presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}

		if (list.size() == 1) {
			return list.get(0);
		}

		Collections.sort(list);

		int minDifference = Integer.MAX_VALUE;

		for (int i = 1; i < list.size(); i++) {
			int currentDifference = list.get(i) - list.get(i - 1);
			minDifference = Math.min(minDifference, currentDifference);
		}

		return minDifference;
	}

	private int minDifference = Integer.MAX_VALUE;
	private TreeNode prevNode = null;

	public int getMinimumDifferenceOptimized(TreeNode root) {
		inOrderTraversal(root);
		return minDifference;
	}

	private void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		if (prevNode != null) {
			minDifference = Math.min(minDifference, Math.abs(root.val - prevNode.val));
		}
		prevNode = root;
		inOrderTraversal(root.right);
	}

	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = inorderTraversal(root);
		return list.get(k - 1);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		root = insertInBST(nums, 0, nums.length - 1);
		return insertInBST(nums, 0, nums.length - 1);
	}

	private TreeNode insertInBST(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = insertInBST(nums, start, mid - 1);
		root.right = insertInBST(nums, mid + 1, end);
		return root;
	}

	public TreeNode sortedListToBST(Node head) {
		return sortListToBst(head, 0, lengthOfLL(head) - 1);
	}

	private TreeNode sortListToBst(Node head, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		Node midHead = midHead(head, mid);
		TreeNode root = new TreeNode(midHead.value);
		root.left = sortListToBst(head, start, mid - 1);
		root.right = sortListToBst(head, mid + 1, end);
		return root;
	}

	private int lengthOfLL(Node head) {
		Node temp = head;
		int l = 0;
		while (temp != null) {
			l++;
			temp = temp.next;
		}
		return l;
	}

	private Node midHead(Node head, int mid) {
		Node current = head;
		for (int i = 0; i < mid; i++) {
			current = current.next;
		}
		return current;
	}

	public int findSecondMinimumValue(TreeNode root) {
		List<Integer> list = inorderTraversal(root);
		List<Integer> distinctList = new ArrayList<>(list.stream().distinct().toList());
		Collections.sort(distinctList);
		if (distinctList.size() == 1) {
			return -1;
		}
		System.out.println(list);
		System.out.println(distinctList);
		return distinctList.get(1);
	}

	public long kthLargestLevelSum(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}

		List<Long> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		long sum = 0;
		list.add((long) root.val);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelNodes = new ArrayList<>();
			sum = 0;
			for (int i = 0; i < levelSize; i++) {
				TreeNode presentNode = queue.remove();
				levelNodes.add(presentNode.val);
				if (presentNode.left != null) {
					queue.add(presentNode.left);
					sum += presentNode.left.val;
				}
				if (presentNode.right != null) {
					queue.add(presentNode.right);
					sum += presentNode.right.val;
				}
			}
			result.add(levelNodes);
			list.add(sum);
		}
		if(k > result.size()){
			return -1;
		}
		list.sort(Collections.reverseOrder());
		return list.get(k - 1);
	}

}
