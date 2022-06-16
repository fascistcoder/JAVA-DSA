package com.datastructures.june.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 16/06/22
 */
public class FindElementApperasOnce {
	public static int findOnce(int arr[], int n1) {
		// Complete this function
		if (n1 == 1) {
			return arr[0];
		}

		Set<Integer> set = new HashSet<>();

		for (int num : arr) {
			if (set.contains(num)) {
				set.remove(num);
			}else {
				set.add(num);
			}
		}

		Object[] res = set.toArray();

		return (int) res[0];

	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 1, 2, 2, 3, 3, 4, 50, 50, 65, 65 };
		System.out.println(findOnce(a, a.length));
	}
}
