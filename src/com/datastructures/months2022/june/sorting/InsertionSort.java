package com.datastructures.months2022.june.sorting;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 14/06/22
 */
public class InsertionSort {
	public static void insertionSort(int[] a) {

		if(a.length < 2){
			System.out.println(Arrays.toString(a));
			return;
		}

		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
			}
		}

		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {

		int[] a = new int[] { 4, 2, 8, 81, 1 };

		insertionSort(a);
	}
}