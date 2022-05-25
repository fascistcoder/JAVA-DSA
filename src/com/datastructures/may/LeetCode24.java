package com.datastructures.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */

public class LeetCode24 {
	public LeetCode24() {
	}

	public static int lengthOfLongestSubString(String s) {
		Set<Character> map = new HashSet();
		int max = 0;
		int i = 0;

		for (int j = 0; j < s.length(); ++j) {
			if (!map.contains(s.charAt(j))) {
				map.add(s.charAt(j++));
				max = Math.max(max, map.size());
			} else {
				map.remove(s.charAt(i++));
			}
		}

		System.out.println(map);
		return max;
	}

	public static int longestConsecutive(int[] nums) {
		int ans = 0;
		if (nums.length != 1 && nums.length != 0) {
			HashSet<Integer> integerHashSet = new HashSet();
			int[] var3 = nums;
			int var4 = nums.length;

			int var5;
			int num;
			for (var5 = 0; var5 < var4; ++var5) {
				num = var3[var5];
				integerHashSet.add(num);
			}

			var3 = nums;
			var4 = nums.length;

			for (var5 = 0; var5 < var4; ++var5) {
				num = var3[var5];
				if (!integerHashSet.contains(num - 1)) {
					int j;
					for (j = num; integerHashSet.contains(j); ++j) {
					}

					ans = Math.max(ans, j - num);
				}
			}

			return ans;
		} else {
			return nums.length;
		}
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList();
		HashSet<Integer> hashSet = new HashSet();
		int[] var3 = nums;
		int var4 = nums.length;

		for (int var5 = 0; var5 < var4; ++var5) {
			int num = var3[var5];
			if (hashSet.contains(num)) {
				list.add(num);
			} else {
				hashSet.add(num);
			}
		}

		return list;
	}

	public static int firstMissingPositive(int[] nums) {
		int[] filteredArray = Arrays.stream(nums).filter((num) -> num > 0).distinct().sorted().toArray();
		int res = 0;
		int c = 0;

		for (int i = 0; i < filteredArray.length; ++i) {
			if (filteredArray[i] != i + 1) {
				res = c;
				break;
			}

			++c;
		}

		if (c == filteredArray.length) {
			res = c + 1;
			return res;
		} else {
			return res + 1;
		}
	}

	public static void firstRecurringElement(int[] nums){

		if(nums.length == 0 || nums.length ==1){
			System.out.println(-1);
		}

		HashSet<Integer> hashSet = new HashSet<>();

		int result = 0;

		for(int num : nums){
			if(hashSet.contains(num)){
				result = num;
				break;
			}
			hashSet.add(num);
		}

		if(result == 0){
			System.out.println(-1);
		}else{
			System.out.println(result);
		}

		List<String> result1 = new LinkedList<>();

	}

	public static void main(String[] args) {
		int[] a = new int[] { 2,5,5,3,4,5 };
		//System.out.println(firstMissingPositive(a));

		firstRecurringElement(a);
	}
}


