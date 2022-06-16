package com.datastructures.june.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 16/06/22
 */
public class SortAnArray {
	public static int[] sortA1ByA2(int[] A1, int N, int[] A2, int M) {

		SortedMap<Integer, Integer> hashMap = new TreeMap<>();

		for (int i = 0; i < N; i++) {

			if (hashMap.containsKey(A1[i])) {
				hashMap.put(A1[i], hashMap.get(A1[i]) + 1);
			} else {
				hashMap.put(A1[i], 1);
			}

		}

		ArrayList<Integer> arrayList1 = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			if (hashMap.containsKey(A2[i])) {
				if (hashMap.get(A2[i]) > 1) {
					int j = hashMap.get(A2[i]);
					while (j != 0) {
						arrayList1.add(A2[i]);
						j--;
					}
				} else {
					arrayList1.add(A2[i]);
				}
			}

			hashMap.remove(A2[i]);

		}

		for (int num : hashMap.keySet()) {

			if (hashMap.get(num) > 1) {
				int j = hashMap.get(num);
				while (j != 0) {
					arrayList1.add(num);
					j--;
				}
			} else {
				arrayList1.add(num);
			}

		}

		System.out.println(hashMap);
		System.out.println(arrayList1);

		return arrayList1.stream().mapToInt(Integer::intValue).toArray();

	}

	public static void main(String[] args) {

		int[] a1 = new int[] { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int[] a2 = new int[] { 36,363};

		System.out.println(Arrays.toString(sortA1ByA2(a1, a1.length, a2, a2.length)));
	}
}
