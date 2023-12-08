package com.datastructures.months2022.may.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 09/06/22
 */
public class MaxSubsequence {
	public static int[] maxSubsequence(int[] nums, int k) {
		Arrays.sort(nums);

		int[] res = new int[k];

		int len = nums.length;

		for (int i = 0; i < k; i++) {
			res[i] = nums[len - 1];
			len--;
		}

		return res;
	}

	public int findClosestNumber(int[] nums) {
		List<Integer> negative = new ArrayList<>();
		List<Integer> positive = new ArrayList<>();

		for (int num : nums) {
			if (num < 0) {
				negative.add(num);
			} else {
				positive.add(num);
			}
		}

		Collections.sort(positive);
		negative.sort(Collections.reverseOrder());

		if(positive.isEmpty()){
			return negative.get(0);
		}

		if(negative.isEmpty()){
			return positive.get(0);
		}

		if (Math.abs(negative.get(0)) >= positive.get(0)) {
			return positive.get(0);
		} else {
			return negative.get(0);
		}
	}
}
