package com.datastructures.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 26/05/22
 */
public class findTargetIndices {
	public static List<Integer> targetIndices(int[] nums, int target) {

		// O(n logn) solution
/*
		Arrays.sort(nums);

		List<Integer> resList = new ArrayList<>();

		int j =0;

		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == target){
				resList.add(i);
			}
		}

		return resList;*/

		Arrays.sort(nums);

		List<Integer> resList = new ArrayList<>();

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (nums[mid] == target) {
				resList.add(mid);

			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return  resList;
	}

	public static void main(String[] args) {
		int[] testCase = new int[] { 1, 2, 5, 2, 3 };

		System.out.println(targetIndices(testCase, 2));
	}
}
