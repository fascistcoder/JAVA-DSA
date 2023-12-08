package com.datastructures.months2022.may.Misc;

import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public class ArrayIntersection {

	public static int NumberofElementsInIntersection(int a[], int b[]) {
		// Your code here
		HashSet<Integer> hashSet1 = new HashSet<>();

		for (int num : a) {
			hashSet1.add(num);
		}

		int c = 0;

		for (int num : b) {
			if (hashSet1.contains(num)) {
				c++;
			}

			hashSet1.remove(num);
		}

		System.out.println(hashSet1);

		System.out.println(c);

		return c;
	}
}
