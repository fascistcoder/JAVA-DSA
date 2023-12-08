package com.datastructures.months2022.may.Misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 05/06/22
 */
public class ArrayPermutation {
	public static int[] buildArray(int[] nums) {

		if (nums.length == 0 || nums.length == 1) {
			return nums;
		}

		int[] newArr = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			newArr[i] = nums[nums[i]];
		}

		return newArr;
	}

	public static boolean canBeIncreasing(int[] nums) {

		int count = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= nums[i - 1]) {
				if (count == 1) {
					return false;
				}
				count++;
				if (i > 1 && nums[i] <= nums[i - 2]) {
					nums[i] = nums[i - 1];
				}
			}
		}

		System.out.println(Arrays.toString(nums));

		return true;
	}

	public static int totalSteps(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		}
		List<Integer> list = new java.util.ArrayList<>(IntStream.of(nums).boxed().distinct().toList());

		if (list.size() == 1) {
			return list.get(0);
		}

		if (list.size() == 2) {
			return Math.max(list.get(0), list.get(1));
		}

		list.sort(Collections.reverseOrder());

		return list.get(2);
	}

	public static boolean hasGroupsSizeX(int[] deck) {
		if (deck.length == 0 || deck.length == 1) {
			return false;
		}

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int j : deck) {

			if (hashMap.containsKey(j)) {
				hashMap.put(j, hashMap.get(j) + 1);
			} else {
				hashMap.put(j, 1);
			}

		}

		int res = 0;

		for (int i : hashMap.values()) {
			res = gcd(i, res);
		}

		return res > 1;
	}

	public static int gcd(int a, int b) {
		return b > 0 ? gcd(b, a % b) : a;
	}

	public static int[] getConcatenation(int[] nums) {
		int[] ans = new int[nums.length + nums.length];

		for (int i=0; i< nums.length;i++){
			ans[i] = nums[i] = ans[i + nums.length];
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 1 };
		//	System.out.println(canBeIncreasing(a));

		//totalSteps(a);

		//System.out.println(hasGroupsSizeX(a));

		getConcatenation(a);
	}

}