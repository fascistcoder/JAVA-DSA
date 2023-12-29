package com.datastructures.Tree;

import com.datastructures.LinkedList.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
		binaryTreeLL.insertNodeInTree(3);
		binaryTreeLL.insertNodeInTree(9);
		binaryTreeLL.insertNodeInTree(20);
		binaryTreeLL.insertNodeInTree(15);
		binaryTreeLL.insertNodeInTree(7);
		//		binaryTreeLL.levelOrderTraversal();
		//		binaryTreeLL.maxDepth();
		//		binaryTreeLL.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
		//		binaryTreeLL.levelOrderTraversal();
		//		binaryTreeLL.findSecondMinimumValue(binaryTreeLL.root);
		//		binaryTreeLL.zigzagLevelOrder(binaryTreeLL.root);
		binaryTreeLL.averageOfLevels(binaryTreeLL.root);
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

	public boolean isValidBST(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		}

		if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
			return false;
		}

		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
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
		if (k > result.size()) {
			return -1;
		}
		list.sort(Collections.reverseOrder());
		return list.get(k - 1);
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		List<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		list.add(root.val);
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.remove();
			list.add(currentNode.val);
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		return list.size();
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean zigzag = false;
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> levelNodes = new ArrayList<>();

			for (int i = 0; i < levelSize; i++) {
				TreeNode presentNode = queue.remove();

				if (zigzag) {
					levelNodes.add(0, presentNode.val);
				} else {
					levelNodes.add(presentNode.val);
				}

				if (presentNode.left != null) {
					queue.add(presentNode.left);
				}

				if (presentNode.right != null) {
					queue.add(presentNode.right);
				}

			}
			result.add(levelNodes);
			zigzag = !zigzag;
		}

		System.out.println(result);

		return result;
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return targetSum - root.val == 0;
		}

		boolean leftResult = hasPathSum(root.left, targetSum - root.val);
		boolean rightResult = hasPathSum(root.right, targetSum - root.val);

		return leftResult || rightResult;
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		if (root.left == null && root.right == null) {
			return 1;
		}

		if (root.left == null) {
			return 1 + minDepth(root.right);
		}

		if (root.right == null) {
			return 1 + minDepth(root.left);
		}

		return 1 + Math.min(minDepth(root.left), minDepth(root.right));

	}

	int maxFrequency = 0;
	Map<Integer, Integer> map = new HashMap<>();

	public int[] findFrequentTreeSum(TreeNode root) {
		postOrderSum(root);
		List<Integer> frequentSums = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == maxFrequency) {
				frequentSums.add(entry.getKey());
			}
		}

		return frequentSums.stream().mapToInt(Integer::intValue).toArray();
	}

	int postOrderSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftSum = postOrderSum(root.left);
		int rightSum = postOrderSum(root.right);
		int currSum = leftSum + rightSum + root.val;

		map.put(currSum, map.getOrDefault(currSum, 0) + 1);
		maxFrequency = Math.max(maxFrequency, map.get(currSum));

		return currSum;
	}

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<Integer> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			LinkedList<Integer> levelNodes = new LinkedList<>();
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
			levelNodes.add(null);
		}
		System.out.println(list);
		return list;
	}

	public List<Double> averageOfLevels(TreeNode root) {
		if (root == null) {
			return null;
		}

		List<Double> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			double sum = 0;

			for (int i = 0; i < levelSize; i++) {
				TreeNode presentNode = queue.remove();
				sum += presentNode.val;
				if (presentNode.left != null) {
					queue.add(presentNode.left);
				}
				if (presentNode.right != null) {
					queue.add(presentNode.right);
				}
			}
			list.add(sum / levelSize);
		}

		System.out.println(list);
		return list;
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int ans = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.remove();
			if (currentNode.left == null && currentNode.right == null) {
				ans += currentNode.val;
			} else {
				if (currentNode.left != null) {
					currentNode.left.val += currentNode.val * 10;
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					currentNode.right.val += currentNode.val * 10;
					queue.add(currentNode.right);
				}
			}
		}
		return ans;
	}

	//	public String smallestFromLeaf(TreeNode root) {
	//		if (root == null) {
	//			return null;
	//		}
	//
	//		Queue<TreeNode> queue = new LinkedList<>();
	//		Queue<String> pathQueue = new LinkedList<>();
	//		queue.add(root);
	//		pathQueue.add("" + (char) (root.val + 'a'));
	//		String smallestPath = null;
	//
	//		while (!queue.isEmpty()) {
	//			TreeNode curr = queue.remove();
	//			String path = pathQueue.poll();
	//
	//			if (curr.left == null && curr.right == null) {
	//				if (smallestPath == null || Objects.requireNonNull(path).compareTo(smallestPath) < 0) {
	//					smallestPath = path;
	//				}
	//			}
	//
	//
	//			if (curr.left != null) {
	//				queue.add(curr.left);
	//				pathQueue.add((char) (curr.left.val + 'a') + path);
	//			}
	//
	//			if (curr.right != null) {
	//				queue.add(curr.right);
	//				pathQueue.add((char) (curr.right.val + 'a') + path);
	//			}
	//		}
	//
	//		return smallestPath;
	//	}

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		Queue<String> pathQueue = new LinkedList<>();
		List<String> pathList = new LinkedList<>();
		queue.add(root);
		pathQueue.add(String.valueOf(root.val));

		while (!queue.isEmpty()) {
			TreeNode curr = queue.remove();
			String path = pathQueue.poll();

			if (curr.left == null && curr.right == null) {
				pathList.add(path);
			} else {
				if (curr.left != null) {
					queue.add(curr.left);
					pathQueue.add(path + "->" + curr.left.val);
				}
				if (curr.right != null) {
					queue.add(curr.right);
					pathQueue.add(path + "->" + curr.right.val);
				}
			}

		}
		System.out.println(pathList);
		return pathList;
	}
}

