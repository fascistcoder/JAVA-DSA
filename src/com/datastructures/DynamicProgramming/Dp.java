package com.datastructures.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 29/12/23
 */
public class Dp {

	public static void main(String[] args) {
		System.out.println(new Dp().fibMemo(1000, new HashMap<>()));
		System.out.println(new Dp().fibTab(1000));
		System.out.println(new Dp().findMinOperations("table", "tbres"));

	}

	/*** Top Down Memorization ***/
	private int fibMemo(int n, HashMap<Integer, Integer> hashMap) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (!hashMap.containsKey(n)) {
			hashMap.put(n, (fibMemo(n - 1, hashMap) + fibMemo(n - 2, hashMap)));
		}

		return hashMap.get(n);
	}

	/*** Bottom up Tabulation ***/
	private int fibTab(int n) {
		ArrayList<Integer> tb = new ArrayList<>();
		tb.add(0);
		tb.add(1);

		for (int i = 2; i <= n; i++) {
			int n1 = tb.get(i - 1);
			int n2 = tb.get(i - 2);
			tb.add(n1 + n2);
		}

		return tb.get(n - 1);
	}

	/*** Question 1 Number Factor

	 /*** Top Down Memorization ***/
	private static int waysToGetNTopDown(int n, HashMap<Integer, Integer> hashMap) {
		if (n == 1 || n == 0 || n == 2) {
			return 1;
		}

		if (n == 3) {
			return 2;
		}

		if (!hashMap.containsKey(n)) {
			hashMap.put(n, waysToGetNTopDown(n - 1, hashMap) + waysToGetNTopDown(n - 3, hashMap) + waysToGetNTopDown(n - 4, hashMap));
		}

		return hashMap.get(n);
	}

	/*** Bottom Up Memorization ***/
	private int waysToGetNBottomUp(int n) {
		ArrayList<Integer> tb = new ArrayList<>();
		tb.add(1);
		tb.add(1);
		tb.add(1);
		tb.add(2);

		for (int i = 4; i <= n; i++) {
			int c1 = tb.get(i - 1);
			int c2 = tb.get(i - 3);
			int c3 = tb.get(i - 4);
			tb.add(c1 + c2 + c3);
		}

		return tb.get(n);
	}

	/***
	 * Question 2 House Rubber
	 * 	Top Down Memorization
	 ***/

	private int maxMoneyTopDown(int[] HouseNetWorth, int[] mem, int currentIndex) {
		if (currentIndex >= HouseNetWorth.length) {
			return 0;
		}

		if (mem[currentIndex] == 0) {
			int stealFirstHouse = HouseNetWorth[currentIndex] + maxMoneyTopDown(HouseNetWorth, mem, currentIndex + 2);
			int skipFirstHouse = maxMoneyTopDown(HouseNetWorth, mem, currentIndex + 1);
			mem[currentIndex] = Math.max(stealFirstHouse, skipFirstHouse);
		}

		return mem[currentIndex];
	}

	/*** Bottom Up Memorization ***/
	public int maxMoneyBottomUp(int[] wealth) {
		int[] tab = new int[wealth.length + 2];
		tab[wealth.length] = 0;
		for (int i = wealth.length - 1; i >= 0; i--) {
			tab[i] = Math.max((wealth[i] + tab[i + 2]), tab[i + 1]);
		}
		return tab[0];
	}

	/***
	 * Question 3 Convert one string to another
	 * 	Top Down Memorization
	 ***/

	public int findMinOperations(String s1, String s2) {
		int[] dp = new int[s1.length() + s2.length()];
		return findMinOperations(s1, s2, 0, 0, dp);
	}

	private int findMinOperations(String s1, String s2, int i1, int i2, int[] dp) {
		if (i1 == s1.length()) {
			return s2.length() - i2;
		}

		if (i2 == s2.length()) {
			return s1.length() - i1;
		}

		if (s1.charAt(i1) == s2.charAt(i2)) {
			return findMinOperations(s1, s2, i1 + 1, i2 + 1, dp);
		}

		int index = i1 + i2;
		if (dp[index] == 0) {
			int deleteOp = 1 + findMinOperations(s1, s2, i1 + 1, i2, dp);
			int insertOp = 1 + findMinOperations(s1, s2, i1, i2 + 1, dp);
			int replaceOp = 1 + findMinOperations(s1, s2, i1 + 1, i2 + 1, dp);

			dp[index] = Math.min(deleteOp, Math.min(insertOp, replaceOp));
		}

		return dp[index];
	}

	/*** Bottom Up Memorization ***/
	public int findMinOperationsBU(String s1, String s2) {
		// TODO
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i1 = 0; i1 <= s1.length(); i1++) {
			dp[i1][0] = i1;
		}

		for (int i2 = 0; i2 <= s2.length(); i2++) {
			dp[0][i2] = i2;
		}

		for (int i1 = 1; i1 <= s1.length(); i1++) {
			for (int i2 = 1; i2 <= s2.length(); i2++) {
				if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
					dp[i1][i2] = dp[i1 - 1][i2 - 1];
				} else {
					dp[i1][i2] = 1 + Math.min((dp[i1 - 1][i2]), Math.min((dp[i1][i2 - 1]), dp[i1 - 1][i2 - 1]));
				}
			}
		}

		return dp[s1.length()][s2.length()];
	}

}
