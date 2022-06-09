package com.datastructures.may.Trees;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 05/06/22
 */
public class CheckForBST {

	boolean isBST(BinaryNodeGfg.Node root)
	{
		int maxVal = Integer.MAX_VALUE;
		int minVal = Integer.MIN_VALUE;

		return isValidBST(root, minVal, maxVal);

	}

	public static boolean isValidBST(BinaryNodeGfg.Node root, long minVal, long maxVal){
		if(root == null){
			return true;
		}
		if(root.data >= maxVal || root.data <=minVal){
			return false;
		}
		return isValidBST(root.left, minVal, root.data) && isValidBST(root.right, root.data, maxVal);
	}


}
