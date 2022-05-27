package com.datastructures.may;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 27/05/22
 */
public class MinimumRotatedSortedArray {
	// O(nLogn)
	public static int findMin(int[] nums) {
		Arrays.sort(nums);

		return nums[0];
	}

	// O(logn)
	public static int findMinOptimized(int[] nums) {
		int i = 0;
		int j = nums.length - 1;

		int first = nums[i];
		int last = nums[j];

		int res = Math.min(first, last);

		int k = 0;

		while (k < nums.length) {
			if (last < first) {
				first = nums[i++];
			} else {
				last = nums[j--];
			}
			res = Math.min(last, first);
			k++;
		}

		return res;
	}

	public static int findMinOptimized2(int[] nums) {
		int start = 0, end = nums.length - 1, last = nums[nums.length - 1];

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < last) {
				end = mid;
			} else {
				start = mid;
			}
		}

		return Math.min(nums[start], nums[end]);
	}

	public static void main(String[] args) {
		int[] n = new int[] { 11 };

		System.out.println(findMinOptimized(n));
	}
}
