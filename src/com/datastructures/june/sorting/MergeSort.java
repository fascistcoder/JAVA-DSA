package com.datastructures.june.sorting;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/06/22
 */
public class MergeSort {
	public static void mergeSort(int[] a, int left, int right) {

		if (a.length == 1) {
			System.out.println(Arrays.toString(a));
			return;
		}

		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);

			mergeArray(a, left, mid, right);
		}

	}

	public static void mergeArray(int[] a, int left, int mid, int right) {
		int leftArraySize = mid - left + 1;
		int rightArraySize = right - mid;

		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];

		for (int i = 0; i < leftArraySize; i++) {
			leftArray[i] = a[left + i];
		}

		for (int j = 0; j < rightArraySize; j++) {
			rightArray[j] = a[mid + 1 + j];
		}

		int i = 0, j = 0, k = left;

		while (i < leftArraySize && j < rightArraySize) {
			if (leftArray[i] < rightArray[j]) {
				a[k++] = leftArray[i++];
			} else {
				a[k++] = rightArray[j++];
			}
		}

		while (i < leftArraySize) {
			a[k++] = leftArray[i++];
		}

		while (j < rightArraySize) {
			a[k++] = rightArray[j++];
		}

	}
}
