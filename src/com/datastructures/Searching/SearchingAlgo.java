package com.datastructures.Searching;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 29/11/23
 */
public class SearchingAlgo {
	public static void main(String[] args) {
		linearSearch(new int[] { 1, 2, 3, 4 }, 4);
		System.out.println(binarySearch(new int[] { 1 }, 4));
	}

	public static void linearSearch(int[] arr, int val) {
		int i = 0;
		for (int num : arr) {
			if (num == val) {
				System.out.println("the element " + val + " is found at index " + i);
				return;
			}
			i++;
		}
		System.out.println("the element " + val + " not founs");
	}

	public static int binarySearch(int[] arr, int val) {
		int start = 0;
		int end = arr.length - 1;
		int mid = (end + start) / 2;

		while (arr[mid] != val && start <= end) {
			if (val < arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			mid = (start + end) / 2;
		}
		if (arr[mid] == val) {
			return mid;
		}

		return -1;
	}

}
