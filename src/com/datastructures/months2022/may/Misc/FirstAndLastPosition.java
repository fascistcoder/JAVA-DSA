package com.datastructures.months2022.may.Misc;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 26/05/22
 */
public class FirstAndLastPosition {

	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[2];

		int firstPosition = firstPositionIndex(nums, target);
		int lastPosition = lastPositionIndex(nums, target);

		res[0] = firstPosition;
		res[1] = lastPosition;
		return res;
	}

	private static int firstPositionIndex(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;
		int res = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				res = mid;
				end = mid - 1;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return res;
	}

	private static int lastPositionIndex(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;
		int res = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				res = mid;
				start = mid + 1;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] testCase = new int[] { 5,7,7,8,8,10 };

		System.out.println(Arrays.toString(searchRange(testCase, 8)));
	}

}
