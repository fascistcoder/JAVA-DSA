package com.datastructures.june.misc;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 12/06/22
 */
public class SubarrayLengthWithSumZero {

	public static int maxLen(int arr[], int n) {
		// Your code here
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		int maxLen = 0;
		int sum = 0;
		int i = -1;

		hashMap.put(sum, i);

		while (i < arr.length-1) {
			i++;

			sum += arr[i];
			if (!hashMap.containsKey(sum)) {
				hashMap.put(sum, i);
			}else {
				int length = i - hashMap.get(sum);
				maxLen = Math.max(length, maxLen);
			}
		}

		return maxLen;
	}

	public String isSubset( long a1[], long a2[], long n, long m) {

		HashSet<Long> hashSet = new HashSet<>();

		for(long num : a1){
			hashSet.add(num);
		}

		for(long num : a2){
			if(!hashSet.contains(num)){
				return "No";
			}
		}

		return "Yes";
	}
}
