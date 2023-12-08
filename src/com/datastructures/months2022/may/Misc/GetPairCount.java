package com.datastructures.months2022.may.Misc;

import java.util.HashMap;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public class GetPairCount {
	public static int getPairsCount(int[] arr, int n, int k) {
		// code here

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		int ans = 0;

		for (int i = 0; i < n; i++) {

			if (hashMap.containsKey(k - arr[i])) {
				ans += hashMap.get(k - arr[i]);
			}

			hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
		}

		return ans;
	}
}
