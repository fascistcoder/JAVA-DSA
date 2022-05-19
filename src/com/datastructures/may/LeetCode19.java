package com.datastructures.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 19/05/22
 */
public class LeetCode19 {

	public static void main(String[] args) {
		int[] b = new int[] { 4,1,2,1,2 };
		//majorityElement(b);
		//singleNumber(b);
		findDuplicate(b);
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

	public static void singleNumber(int[] nums) {
		//		Arrays.sort(nums);
		//
		//		int valueOfArray = nums[0];
		//		int frequencyOfArray = 1;
		//
		//		Map<Integer, Integer> result = new HashMap<>();
		//
		//		final int[] result1 = new int[1];
		//
		//		if (nums.length == 1) {
		//			System.out.println(valueOfArray);
		//		}
		//
		//		for (int i = 1; i < nums.length; i++) {
		//
		//			if (valueOfArray != nums[i]) {
		//				result.put(valueOfArray, frequencyOfArray);
		//				valueOfArray = nums[i];
		//				frequencyOfArray = 1;
		//			} else {
		//				frequencyOfArray++;
		//			}
		//		}
		//
		//		if (nums.length != 1 && valueOfArray == nums[nums.length - 1]) {
		//			result.put(valueOfArray, frequencyOfArray);
		//		}
		//
		//		result.forEach((k, v) -> {
		//			if (v == 1) {
		//				result1[0] = k;
		//			}
		//		});
		//
		//		return result1[0];

		Arrays.sort(nums);

		if (nums.length == 1) {
			System.out.println(nums[0]);
		}

		List<Integer> integerList = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			if (integerList.contains(nums[i])) {
				integerList.remove(integerList.size() - 1);
			} else {
				integerList.add(nums[i]);
			}
		}

		System.out.println(integerList);

		Object[] re = integerList.toArray();

		System.out.println(re[0]);

	}
	public static void findDuplicate(int[] nums) {

		Arrays.sort(nums);

		for(int i=1; i< nums.length; i++){
			if(nums[i] == nums[i-1]){
				System.out.println(nums[i]);
				break;
			}
		}
	}
}
