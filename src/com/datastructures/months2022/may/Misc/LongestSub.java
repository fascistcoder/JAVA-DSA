package com.datastructures.months2022.may.Misc;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 02/06/22
 */
public class LongestSub {
	public static int findLongestConseqSubseq(int[] arr, int N) {
		if (N == 1) {
			return 1;
		}
		int[] newA = Arrays.stream(arr).distinct().sorted().toArray();

		HashSet<Integer> hashSet = new HashSet<>();

		int c = 1;
		int max = 0;

		hashSet.add(newA[0]);

		for (int i = 1; i < arr.length; i++) {
			if (hashSet.contains(newA[i] - 1)) {
				c++;
			} else {
				c = 1;
			}
			max = Math.max(max, c);
			hashSet.add(newA[i]);
		}

		return max;
	}

}
