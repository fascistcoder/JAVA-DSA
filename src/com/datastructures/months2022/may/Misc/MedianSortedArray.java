package com.datastructures.months2022.may.Misc;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 26/05/22
 */
public class MedianSortedArray {
	public static void findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i, j, k;
		i = j = k = 0;

		int[] res = new int[nums1.length + nums2.length];

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				res[k++] = nums1[i++];
			} else {
				res[k++] = nums2[j++];
			}
		}

		while (i < nums1.length) {
			res[k++] = nums1[i++];
		}

		while (j < nums2.length) {
			res[k++] = nums2[j++];
		}

		double median = 0;

		if (res.length % 2 == 0) {
			int firstPos = res[(res.length - 1)/2];
			int secondPos = res[res.length / 2];

			median = (double) (firstPos + secondPos) / 2;

		} else {
			int firstPos = res[res.length / 2];
			median = (double) firstPos;

		}
		System.out.println(Arrays.toString(res));
		System.out.println(median);

	}

	public static void main(String[] args) {
		int[] a = new int[] { 0, 0, 0, 0, 0 };
		int[] b = new int[] { -1, 0, 0, 0, 0, 0, 1 };

		int[] c = new int[] { 1,3 };
		int[] d = new int[] { 2,7 };

		//findMedianSortedArrays(a, b);

			findMedianSortedArrays(c,d);
	}
}
