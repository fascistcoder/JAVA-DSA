package com.datastructures.may;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */
public class Hackerearth {

	public static void main(String[] args) {

	}
	public int minSubArrayLen(int s, int[] nums) {
		int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
		while (right < nums.length) {
			sum += nums[right];
			right++;

			while (sum >= s) {
				sum -= nums[left];
				min = Math.min(min, right - left);
				left++;
			}
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

}
