package com.datastructures.months2022.june.misc;

import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 15/06/22
 */
public class Triplet {
	public boolean findTriplets(int arr[], int n) {
		//add code here

		HashSet<Integer> hashSet = new HashSet<>();

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				sum = arr[i] + arr[j];
				if (hashSet.contains(-sum)) {
					return true;
				}
			}
			hashSet.add(arr[i]);

		}

		return false;
	}

}
