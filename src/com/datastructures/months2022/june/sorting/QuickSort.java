package com.datastructures.months2022.june.sorting;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/06/22
 */
public class QuickSort {

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static int partition(int[] arr, int low, int high) {
		int start = low;
		int end = high;
		int pivot = arr[low];

		while (start < end) {
			while (arr[start] <= pivot && start <= high - 1) {
				start++;
			}
			while (arr[end] > pivot && end >= low) {
				end--;
			}
			if (start < end) {
				swap(arr, start, end);
			}
		}
		swap(arr, low, end);

		return end;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int paritionPos = partition(arr, low, high);

			quickSort(arr, low, paritionPos - 1);
			quickSort(arr, paritionPos + 1, high);
		}
	}
}
