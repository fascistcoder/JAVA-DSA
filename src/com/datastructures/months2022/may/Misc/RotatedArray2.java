package com.datastructures.months2022.may.Misc;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 26/05/22
 */
public class RotatedArray2 {
	public static boolean search(int[] nums, int target) {

		Arrays.sort(nums);

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				return true;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return false;
	}

	public static boolean searchDiff(int[] nums, int target) {

		HashSet<Integer> hashSet = new HashSet<>();

		for (int num : nums){
			hashSet.add(num);
		}

		return hashSet.contains(target);
	}
}
