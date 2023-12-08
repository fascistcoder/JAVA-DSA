package com.datastructures.months2022.may.Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 07/06/22
 */
public class SetMismatch {
	public int[] findErrorNums(int[] nums) {

		HashMap<Integer, Integer> hashSet = new HashMap<>();

		int dup = -1;
		int missing = 1;

		int[] res = new int[2];

		for (int num : nums) {
			hashSet.put(num, hashSet.getOrDefault(num, 0) + 1);
		}

		for (int i = 1; i <= nums.length; i++) {
			if (hashSet.containsKey(i)) {
				if (hashSet.get(i) == 2) {
					dup = i;
				}
			} else {
				missing = i;
			}
		}

		res[0] = dup;
		res[1] = missing;

		return res;

	}

	public int[] maxSubsequence(int[] nums, int k) {

		int maxSum = 0;

		int[] res = new int[k];

		for (int i = 0; i < k; i++) {
			maxSum += nums[i];
		}

		int windowSum = 0;

		for (int i = k; i < nums.length; i++) {
			windowSum += nums[i] - nums[i - k];

			if (maxSum > windowSum) {

			}

			maxSum = Math.max(maxSum, windowSum);
		}


		return res;
	}

	public static int maxSubArray(final List<Integer> A) {
//		int max_so_far = Integer.MIN_VALUE;
//		int max_ending_here = 0;
//		int max_element = Integer.MIN_VALUE;
//
//		for (Integer integer : A) {
//			max_ending_here = Math.max(max_ending_here + integer, 0);
//			max_so_far = Math.max(max_ending_here, max_so_far);
//			max_element = Math.max(max_element, integer);
//		}
//
//		if(max_so_far == 0){
//			max_so_far = max_element;
//		}
//
//		return max_so_far;


		int maxSum = 0;

		int maxElement = A.get(0);

		int currSum = A.get(0);

		for (int i = 1; i < A.size(); i++) {
			currSum += A.get(i);
			if (currSum < 0) {
				currSum = 0;
			} else {
				maxSum = Math.max(maxSum, currSum);
			}

			maxElement = Math.max(maxElement, A.get(i));

		}

		if(maxSum == 0){
			maxSum = maxElement;
		}

		return maxSum;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(-10);

		System.out.println(maxSubArray(list));
	}
}
