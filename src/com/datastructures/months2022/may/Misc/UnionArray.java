package com.datastructures.months2022.may.Misc;

import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public class UnionArray {

	public static int doUnion(int a[], int n, int b[], int m) {
		//Your code here
		HashSet<Integer> hashSet = new HashSet<>();

		for (int num : a) {
			hashSet.add(num);
		}

		for (int num : b) {
			hashSet.add(num);
		}

		return hashSet.size();
	}
}
