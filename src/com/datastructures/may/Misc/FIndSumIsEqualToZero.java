package com.datastructures.may.Misc;

import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/06/22
 */
public class FIndSumIsEqualToZero {


	public static boolean findsum(int[] arr, int n) {
		//Your code here

		int currSum = 0;

		HashSet<Integer> hashSet = new HashSet<>();

		for (int i = 0; i < n; i++) {

			currSum = currSum + arr[i];

			if (currSum == 0 || hashSet.contains(currSum)) {
				return true;
			}

			hashSet.add(currSum);
		}

		return false;
	}
}
