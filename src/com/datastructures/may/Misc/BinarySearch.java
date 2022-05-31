package com.datastructures.may.Misc;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/05/22
 */
public class BinarySearch {
	public static int binarysearch(int arr[], int n, int k) {
		// code here
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (arr[mid] == k) {
				return mid;
			} else if (k < arr[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
