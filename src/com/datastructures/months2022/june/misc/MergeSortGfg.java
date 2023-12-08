package com.datastructures.months2022.june.misc;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/06/22
 */
public class MergeSortGfg {
	void merge(int arr[], int l, int m, int r) {
		// Your code here

		// Size of the both array
		int lArrSize = m - l + 1;
		int rArrSize = r - m;

		//Arrays
		int[] lArr = new int[lArrSize];
		int[] rArr = new int[rArrSize];

		//copyingArray
		for (int i = 0; i < lArrSize; i++) {
			lArr[i] = arr[i + l];
		}

		for (int i = 0; i < rArrSize; i++) {
			rArr[i] = arr[i + m + 1];
		}

		// merging array
		int i = 0, j = 0, k = l;
		while (i < lArrSize && j < rArrSize) {
			if (lArr[i] < rArr[j]) {
				arr[k++] = lArr[i++];
			} else {
				arr[k++] = rArr[j++];
			}
		}

		while (i < lArrSize) {
			arr[k++] = lArr[i++];
		}

		while (j < rArrSize) {
			arr[k++] = rArr[j++];
		}

	}

	void mergeSort(int arr[], int l, int r) {
		//code here
		if (l < r) {
			int mid = l + (r - l) / 2;

			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);

			merge(arr, l, mid, r);
		}
	}
}
