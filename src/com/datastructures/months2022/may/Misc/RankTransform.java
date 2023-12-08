package com.datastructures.months2022.may.Misc;

import java.util.Arrays;
import java.util.Hashtable;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 26/05/22
 */
public class RankTransform {
	public static void arrayRankTransform(int[] arr) {

		int[] newArr = Arrays.copyOf(arr, arr.length);

		int[] result = new int[arr.length];

		Arrays.sort(arr);

		Hashtable<Integer, Integer> hashMap = new Hashtable<>();

		for (int i = 0; i < arr.length; i++) {

			if (!hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], hashMap.size() + 1);
			}
		}
		System.out.println(hashMap);

		System.out.println(hashMap.keySet());

		for (int i = 0; i < newArr.length; i++) {
			if (hashMap.containsKey(newArr[i])) {
				result[i] = hashMap.get(newArr[i]);
			}
		}

		System.out.println(Arrays.toString(result));

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 40, 10, 20, 30 };

		int[] arr1 = new int[] { 37, 12, 28, 9, 100, 56, 80, 5, 12 };

		//arrayRankTransform(arr);

		arrayRankTransform(arr1);
	}
}
