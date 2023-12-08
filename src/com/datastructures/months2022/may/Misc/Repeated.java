package com.datastructures.months2022.may.Misc;

import java.util.HashMap;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public class Repeated {
	public static int firstRepeated(int[] arr, int n) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < n; i++) {

			if (hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
			} else {
				hashMap.put(arr[i], 1);
			}
		}

		for (int i = 0; i < n; i++) {
			if (hashMap.get(arr[i]) != 1) {
				return i + 1;
			}
		}

		return -1;
	}
}
