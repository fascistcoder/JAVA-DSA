package com.datastructures.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
public class LeetCode19 {

	public static void main(String[] args) {
		int[] b = new int[] {3,2,3};
		majorityElement(b);
	}

	// Q229
	public static void majorityElement(int[] nums) {
		Arrays.sort(nums);
		int frequencyOfArray = 1;
		int valueOfArray = nums[0];

		List<Integer> result = new ArrayList<>();

		if (nums.length == 1) {
			result.add(nums[0]);
		}

		for (int i = 1; i < nums.length; i++) {

			if (valueOfArray != nums[i]) {
				if (frequencyOfArray > nums.length / 3) {
					result.add(valueOfArray);
				}

				valueOfArray = nums[i];
				frequencyOfArray = 1;
			} else {
				frequencyOfArray = frequencyOfArray + 1;
			}
		}


		if ((frequencyOfArray > nums.length / 3) && nums.length != 1) {
			valueOfArray = nums[nums.length - 1];
			result.add(valueOfArray);
		}

		System.out.println(result);
	}
}
