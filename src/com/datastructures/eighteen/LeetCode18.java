package com.datastructures.eighteen;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 18/05/22
 */
public class LeetCode18 {
	public static void main(String[] args) {
		int[] b = new int[] {1,2 };
	//	majorityElement(b);
	}

	// Q169
	public static void majorityElement(int[] nums) {

//		int value = 0;
//		int count  = 0;
//
//		for(int num : nums){
//			if(count == 0){
//				value = num;
//			}if(num == value){
//				count++;
//			}else {
//				count--;
//			}
//		}

		Arrays.sort(nums);

		System.out.println(nums[nums.length/2]);
	}
}
