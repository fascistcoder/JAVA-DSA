package com.datastructures.may.Misc;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public class FreqCount {
	public static void frequencyCount(int[] arr, int N, int P) {
		// code here

		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for (int j : arr) {
			if (hashMap.containsKey(j)) {
				hashMap.put(j, 1 + hashMap.get(j));
			} else {
				hashMap.put(j, 1);
			}
		}

		for (int i = 0; i < N; i++) {
			arr[i] = hashMap.get(i + 1) != null ? hashMap.get(i + 1) : 0;
		}

		System.out.println(Arrays.toString(arr));
	}
}
