package com.datastructures.DivideConquer;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/12/23
 */
public class DivideConquer {

	public static void main(String[] args) {
		System.out.println(new DivideConquer().waysToGetN(12));
		System.out.println(new DivideConquer().maxMoney(new int[] { 6, 7, 1, 30, 8, 2, 4 }));
		System.out.println(new DivideConquer().findMinOperations("table", "tbres"));
		System.out.println(new DivideConquer().zeroKanpSack(new int[] { 31, 26, 17, 72 }, new int[] { 3, 1, 2, 5 }, 7));
		System.out.println(new DivideConquer().longestSubsequence("elephant", "erepat"));
		System.out.println(new DivideConquer().longestPalSubsequence("elrmenmet"));
		System.out.println(new DivideConquer().minCostToReachLastCell(new int[][] {
				{ 4, 7, 8, 6, 4 },
				{ 6, 7, 3, 9, 2 },
				{ 3, 8, 1, 2, 4 },
				{ 7, 1, 7, 3, 7 },
				{ 2, 9, 8, 9, 3 } }));

		int[][] grid = {
				{ 4, 7, 1, 6 },
				{ 5, 7, 3, 9 },
				{ 3, 2, 1, 2 },
				{ 7, 1, 6, 3 }
		};
		System.out.println(new DivideConquer().noOfPathToReachLastCell(grid, 25));
	}

	/*** Question 1 ***/
	public int waysToGetN(int N) {
		if ((N == 0) || (N == 1) || (N == 2)) {
			return 1;
		}

		if (N == 3) {
			return 2;
		}

		int sub1 = waysToGetN(N - 1);
		int sub2 = waysToGetN(N - 3);
		int sub3 = waysToGetN(N - 4);

		return sub1 + sub2 + sub3;
	}

	/*** Question 2 ***/

	public int maxMoneyRecursive(int[] HouseNetWorth, int currentIndex) {
		if (currentIndex >= HouseNetWorth.length) {
			return 0;
		}

		int stealCurrentHouse = HouseNetWorth[currentIndex] + maxMoneyRecursive(HouseNetWorth, currentIndex + 2);
		int skipCurrentHouse = maxMoneyRecursive(HouseNetWorth, currentIndex + 1);

		return Math.max(stealCurrentHouse, skipCurrentHouse);
	}

	public int maxMoney(int[] HouseNetWorth) {
		return maxMoneyRecursive(HouseNetWorth, 0);
	}

	/*** Question 3 ***/
	private int findMinOperations(String s1, String s2, int i1, int i2) {
		if (i1 == s1.length()) {
			return s2.length() - i2;
		}

		if (i2 == s2.length()) {
			return s1.length() - i1;
		}

		if (s1.charAt(i1) == s2.charAt(i2)) {
			return findMinOperations(s1, s2, i1 + 1, i2 + 1);
		}

		int deleteOp = 1 + findMinOperations(s1, s2, i1 + 1, i2);
		int insertOp = 1 + findMinOperations(s1, s2, i1, i2 + 1);
		int replaceOp = 1 + findMinOperations(s1, s2, i1 + 1, i2 + 1);

		return Math.min(deleteOp, Math.min(insertOp, replaceOp));
	}

	public int findMinOperations(String s1, String s2) {
		return findMinOperations(s1, s2, 0, 0);
	}

	/*** Question 4 ***/
	private int zeroKanpSack(int[] profits, int[] weights, int capacity, int currentIndex) {
		if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length) {
			return 0;
		}

		int profit1 = 0;
		if (weights[currentIndex] <= capacity) {
			profit1 = profits[currentIndex] + zeroKanpSack(profits, weights, capacity - weights[currentIndex], currentIndex + 1);
		}
		int profit2 = zeroKanpSack(profits, weights, capacity, currentIndex + 1);

		return Math.max(profit1, profit2);
	}

	public int zeroKanpSack(int[] profits, int[] weights, int capacity) {
		return zeroKanpSack(profits, weights, capacity, 0);
	}

	/*** Question 5 ***/
	private int longestSub(String s1, String s2, int i1, int i2) {
		if (i1 == s1.length() || i2 == s2.length()) {
			return 0;
		}

		int c1 = 0;

		if (s1.charAt(i1) == s2.charAt(i2)) {
			c1 = 1 + longestSub(s1, s2, i1 + 1, i2 + 1);
		}

		int c2 = longestSub(s1, s2, i1, i2 + 1);
		int c3 = longestSub(s1, s2, i1 + 1, i2);

		return Math.max(c1, Math.max(c2, c3));
	}

	public int longestSubsequence(String s1, String s2) {
		return longestSub(s1, s2, 0, 0);
	}

	/*** Question 6 ***/
	private int LPS(String s, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return 0;
		}

		if (startIndex == endIndex) {
			return 1;
		}

		int c1 = 0;
		if (s.charAt(startIndex) == s.charAt(endIndex)) {
			c1 = 2 + LPS(s, startIndex + 1, endIndex - 1);
		}

		int c2 = LPS(s, startIndex, endIndex - 1);
		int c3 = LPS(s, startIndex + 1, endIndex);

		return Math.max(c1, Math.max(c2, c3));
	}

	public int longestPalSubsequence(String s) {
		return LPS(s, 0, s.length() - 1);
	}

	/*** Question 7 ***/
	private int findMinCost(int[][] matrix, int row, int col) {
		if (row == -1 || col == -1) {
			return Integer.MAX_VALUE;
		}
		if (row == 0 && col == 0) {
			return matrix[row][col];
		}

		int c1 = findMinCost(matrix, row - 1, col);
		int c2 = findMinCost(matrix, row, col - 1);

		return Math.min(c1, c2) + matrix[row][col];
	}

	public int minCostToReachLastCell(int[][] matrix) {
		return findMinCost(matrix, matrix.length - 1, matrix[0].length - 1);
	}

	/*** Question 8 ***/
	private int findNumberOfPaths(int[][] matrix, int row, int col, int cost) {
		if (cost < 0) {
			return 0;
		} else if (row == 0 && col == 0) {
			return (matrix[0][0] - cost == 0) ? 1 : 0;
		} else if (row == 0) {
			return findNumberOfPaths(matrix, 0, col - 1, cost - matrix[row][col]);
		} else if (col == 0) {
			return findNumberOfPaths(matrix, row - 1, 0, cost - matrix[row][col]);
		}

		int c1 = findNumberOfPaths(matrix, row - 1, col, cost - matrix[row][col]);
		int c2 = findNumberOfPaths(matrix, row, col - 1, cost - matrix[row][col]);

		return c1 + c2;
	}

	public int noOfPathToReachLastCell(int[][] matrix, int cost) {
		return findNumberOfPaths(matrix, matrix.length - 1, matrix[0].length - 1, cost);
	}

}
