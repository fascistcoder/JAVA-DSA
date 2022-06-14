package com.datastructures.june.misc;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 14/06/22
 */
public class MaxSumSubarray {
	public static long maximumSumSubarray(int K, ArrayList<Integer> Arr, int N) {
		// code here
		int i = 0;
		int j = 0;

		long currSum = 0;
		long maxSum = Integer.MIN_VALUE;

		while (j < N) {
			currSum += Arr.get(j);

			if (j - i + 1 == K) {
				maxSum = Math.max(maxSum, currSum);
				currSum -= Arr.get(i);
				i++;
			}
			j++;
		}

		return maxSum;
	}

	public ArrayList<Integer> countDistinct(int A[], int n, int k) {
		// code here

		int i = 0;
		int j = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		ArrayList<Integer> arrayList = new ArrayList<>();

		while (j < n) {

			hashMap.put(A[j], hashMap.getOrDefault(A[j], 0) + 1);

			if (j - i + 1 == k) {
				arrayList.add(hashMap.size());
				hashMap.put(A[i], hashMap.get(A[i])-1);
				if(hashMap.get(A[i]) == 0){
					hashMap.remove(A[i]);
				}
				i++;
			}

			System.out.println(hashMap);

			j++;
		}

		return arrayList;
	}
}
