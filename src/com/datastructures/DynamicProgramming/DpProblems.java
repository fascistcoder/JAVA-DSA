package com.datastructures.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 30/12/23
 */
public class DpProblems {

	public static void main(String[] args) {
		System.out.println(new DpProblems().LPSBottomUpApproach("bbbab"));
		System.out.println(new DpProblems().minCostBottomUp(new int[] { 10, 15, 20 }));
		new DpProblems().rob(new int[] { 1, 2, 3, 1 });
	}

	public int rob(int[] nums) {
		int[] arr1 = Arrays.copyOf(nums, nums.length - 1);
		int[] arr2 = new int[nums.length - 1];
		int j = 0;

		for (int i = nums.length - 1; i > 0; i--) {
			arr2[j] = nums[i];
			j++;
		}

		int first = maxMoneyBottomUp(arr1);
		int second = maxMoneyBottomUp(arr2);

		return Math.max(first, second);
	}

	public int maxMoneyBottomUp(int[] wealth) {
		int[] tab = new int[wealth.length + 2];
		tab[wealth.length] = 0;
		for (int i = wealth.length - 1; i >= 0; i--) {
			tab[i] = Math.max((wealth[i] + tab[i + 2]), tab[i + 1]);
		}
		return tab[0];
	}

	public int longestPalSubsequence(String s) {
		int[][] dp = new int[s.length()][s.length()];
		return LPSTopDownApproach(s, 0, s.length() - 1, dp);
	}

	private int LPSTopDownApproach(String s, int startIndex, int endIndex, int[][] mem) {
		if (startIndex > endIndex) {
			return 0;
		}

		if (startIndex == endIndex) {
			return 1;
		}

		int c1 = 0;

		if (s.charAt(startIndex) == s.charAt(endIndex)) {
			c1 = 2 + LPSTopDownApproach(s, startIndex + 1, endIndex - 1, mem);
		}

		if (mem[startIndex][endIndex] == 0) {
			int c2 = LPSTopDownApproach(s, startIndex, endIndex - 1, mem);
			int c3 = LPSTopDownApproach(s, startIndex + 1, endIndex, mem);
			mem[startIndex][endIndex] = Math.max(c1, Math.max(c2, c3));
		}

		return mem[startIndex][endIndex];

	}

	private int LPSBottomUpApproach(String s) {
		int[][] dp = new int[s.length() + 1][s.length() + 1];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}

		for (int i1 = s.length() - 1; i1 >= 0; i1--) {
			for (int i2 = i1 + 1; i2 < s.length(); i2++) {
				if (s.charAt(i1) == s.charAt(i2)) {
					dp[i1][i2] = 2 + dp[i1 + 1][i2 - 1];
				} else {
					dp[i1][i2] = Math.max(dp[i1 + 1][i2], dp[i1][i2 - 1]);
				}
			}
		}

		return dp[0][s.length() - 1];
	}

	public int climbStairs(int n) {
		List<Integer> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(2);

		for (int i = 2; i < n; i++) {
			int c1 = arrayList.get(i - 1);
			int c2 = arrayList.get(i - 2);
			arrayList.add(c1 + c2);
		}

		return arrayList.get(n);
	}

	public int minCostClimbingStairs(int[] cost, int currentIndex) {
		if (currentIndex >= cost.length) {
			return 0;
		}

		int costPrev = cost[currentIndex] + minCostClimbingStairs(cost, currentIndex + 1);
		int costNext = cost[currentIndex] + minCostClimbingStairs(cost, currentIndex + 2);

		return Math.min(costPrev, costNext);
	}

	public int minCostClimbingStairs(int[] cost) {
		int i1 = minCostClimbingStairs(cost, 0);
		int i2 = minCostClimbingStairs(cost, 1);
		return Math.min(i1, i2);
	}

	// Bottom Up

	private int minCostBottomUp(int[] cost) {
		int[] dp = new int[cost.length + 2];
		dp[cost.length] = 0;
		for (int i = cost.length - 1; i >= 0; i--) {
			dp[i] = Math.min((cost[i] + dp[i + 1]), (cost[i] + dp[i + 2]));
		}

		System.out.println(Arrays.toString(dp));

		return Math.min(dp[0], dp[1]);
	}
}
