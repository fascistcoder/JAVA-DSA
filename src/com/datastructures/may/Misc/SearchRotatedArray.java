package com.datastructures.may.Misc;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 27/05/22
 */
public class SearchRotatedArray {

	public static void main(String[] args) {
		int[] n = new int[] { 1, 3, 5 };

		System.out.println(search(n, n.length));
	}

	public static int search(int[] nums, int key) {
		// Complete this function
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (key == nums[mid]) {
				return mid;
			}

			if (nums[left] <= nums[mid]) {
				if (nums[left] <= key && key < nums[mid]) {
					right = mid -1;
				}else{
					left = mid + 1;
				}
			} else {
				if (nums[right] >= key && key > nums[mid]) {
					left = mid + 1;
				}else{
					right = mid -1;
				}
			}
		}

		return -1;
	}
}
