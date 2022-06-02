package com.datastructures.may.Misc;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/06/22
 */
public class KSmallestElement {
	public static int kthSmallest(int[] arr, int l, int r, int k) {
		//Your code here

		Arrays.sort(arr);

		k = k - 1;

		return arr[k];
	}

	public static void main(String[] args) {
		int[] a = new int[]{7, 10, 4, 20, 15};
		System.out.println(kthSmallest(a,0,5,4));
	}
}
