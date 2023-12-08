package com.datastructures.Sorting;

import com.datastructures.Tree.BinaryHeap.BinaryHeap;

import java.util.ArrayList;
import java.util.Collections;

import static com.datastructures.months2022.june.sorting.MergeSort.*;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 05/12/23
 */
public class Sorting {
	int[] a = null;

	public Sorting(int[] a) {
		this.a = a;
	}

	public static void main(String[] args) {
		int[] a = new int[]{2, 4, 5, 7, 1, 3, 6, 8, 9};
		Sorting sorting = new Sorting(a);
		int[] arr = new int[] { 10, 5, 15, 50, 0, 2 };
		int[] arr1 = new int[] { 10, 5, 15, 50, 0 };
		int[] arr2 = new int[] { 2, 4, 5, 7, 1, 3, 6, 8, 9 };
		int[] arr3 = new int[] { 2, 4, 5, 7, 1, 3, 6, 8, 9 };
		int[] arr4 = new int[] { 2, 4, 5, 7, 1, 3, 6, 8, 9 };
		int[] arr5 = new int[] { 2, 4, 5, 7, 1, 3, 6, 8, 9 };

		sorting.bubbleSorting(arr1);
		sorting.printArray(arr1);
		sorting.selectionSorting(arr);
		sorting.printArray(arr);
		sorting.insertionSorting(arr2);
		sorting.printArray(arr2);
		sorting.bubbleSorting(arr3);
		sorting.printArray(arr3);
		sorting.mergeSorting(arr4, 0, arr4.length - 1);
		sorting.printArray(arr4);
		sorting.quickSorting(arr5, 0, arr5.length - 1);
		sorting.printArray(arr5);
		sorting.heapSorting();
		sorting.printArray(a);
	}

	void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	//Bubble Sort
	public void bubbleSorting(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// Selection Sort
	public void selectionSorting(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
	}

	// Insertion Sort
	public void insertionSorting(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int temp = arr[i], j = i;
			while (j > 0 && arr[j - 1] > temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}

	// Bucket Sort
	public void bucketSorting(int[] arr) {
		int noOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
		int maxValue = Integer.MIN_VALUE;
		for (int val : arr) {
			if (val > maxValue) {
				maxValue = val;
			}
		}

		ArrayList[] buckets = new ArrayList[noOfBuckets];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}

		for (int val : arr) {
			int bucketNo = (int) Math.ceil(((float) val * noOfBuckets) / (float) maxValue);
			buckets[bucketNo - 1].add(val);
		}

		for (ArrayList bucket : buckets) {
			Collections.sort(bucket);
		}

		int index = 0;
		for (ArrayList bucket : buckets) {
			for (Object value : bucket) {
				arr[index] = (int) value;
				index++;
			}
		}
	}

	// Merge Sort
	void mergeSorting(int[] a, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(a, left, mid);
			mergeSort(a, mid + 1, right);

			merge(a, left, mid, right);
		}
	}

	void merge(int[] a, int left, int mid, int right) {
		int leftArraySize = mid - left + 1;
		int rightArraySize = right - mid;

		int[] leftArr = new int[leftArraySize];
		int[] rightArr = new int[rightArraySize];

		for (int i = 0; i < leftArraySize; i++) {
			leftArr[i] = a[left + i];
		}

		for (int i = 0; i < rightArraySize; i++) {
			rightArr[i] = a[mid + 1 + i];
		}

		int i = 0, j = 0, k = left;

		while (i < leftArraySize && j < rightArraySize) {
			if (leftArr[i] < rightArr[j]) {
				a[k++] = leftArr[i++];
			} else {
				a[k++] = rightArr[j++];
			}
		}

		while (i < leftArraySize) {
			a[k++] = leftArr[i++];
		}

		while (j < rightArraySize) {
			a[k++] = rightArr[j++];
		}
	}

	// Quick Sort

	void quickSorting(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			quickSorting(arr, start, pivot - 1);
			quickSorting(arr, pivot + 1, end);
		}
	}

	int partition(int[] arr, int start, int end) {
		int i = start - 1;

		for (int j = start; j <= end; j++) {
			if (arr[j] <= arr[end]) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		return i;
	}

	// Heap Sort
	void heapSorting() {
		BinaryHeap binaryHeap = new BinaryHeap(a.length);
		for (int j : a) {
			binaryHeap.insert(j, "Min");
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = binaryHeap.extractHeadOfBH("Min");
		}
	}

}
