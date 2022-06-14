package com.datastructures.june.sorting;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 14/06/22
 */
public class SelectionSort {
	public static void selectionSort(int[] a) {

		for (int i = 0; i < a.length; i++) {
			int smallest = a[i];
			int smallestIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (smallest > a[j]) {
					smallest = a[j];
					smallestIndex = j;
				}
			}
			int temp = a[i];
			a[i] = smallest;
			a[smallestIndex] = temp;
		}

		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {

		int[] a = new int[] { 4, 2, 8, 81, 1 };

		selectionSort(a);
	}
}
