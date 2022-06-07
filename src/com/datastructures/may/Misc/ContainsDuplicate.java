package com.datastructures.may.Misc;

import java.util.HashMap;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 07/06/22
 */
public class ContainsDuplicate {
	public  static boolean containsNearbyDuplicate(int[] nums, int k) {

		if(nums.length == 0){
			return false;
		}

		if(nums.length == 1){
			return k == 0;
		}

		HashMap<Integer, Integer> hashSet = new HashMap<>();

		int first = 0;
		int second  =0;

		for (int i = 0; i < nums.length; i++ ){

			if(hashSet.containsKey(nums[i])){
				first = hashSet.get(nums[i]);
				second = i;
				int res = Math.abs(second - first);
				if(res <= k){
					return true;
				}
			}

			hashSet.put(nums[i], i);
		}

		System.out.println(first);
		System.out.println(second);



		return false;

	}

	public static void main(String[] args) {

		int a[] = new int[] {1,0,1,1};

		System.out.println(containsNearbyDuplicate(a, 1));
	}

}
