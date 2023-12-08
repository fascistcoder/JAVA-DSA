package com.datastructures.months2022.may.Misc;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 27/05/22
 */
public class MinimumRotatedArray2 {
	public static int findMin(int[] nums) {

		if(nums.length == 1){
			return nums[0];
		}

		int left = 0;
		int right = nums.length - 1;

		int min = 0;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[left] < nums[mid]) {
				min = Math.min(nums[mid], nums[left]);
				right = mid - 1;
			} else if(nums[left] > nums[mid]) {
				min = Math.min(nums[mid], nums[right]);
				left = mid + 1;
			}
		}

		return min;
	}

	public static void main(String[] args) {
		int[] n = new int[] { 1,3,5 };

		System.out.println(findMin(n));
	}
}
