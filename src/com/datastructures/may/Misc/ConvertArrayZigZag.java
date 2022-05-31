package com.datastructures.may.Misc;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/05/22
 */
public class ConvertArrayZigZag {

	public static void zigZag(int arr[], int n) {
		// code here
		int temp = 0;
		for (int i = 1; i < n; i += 2) {
			if (arr[i - 1] > arr[i]) {
				temp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = temp;
			}
			if (i + 1 < n && arr[i + 1] > arr[i]) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
	}

}
