package com.datastructures.months2022.june.misc;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 13/06/22
 */
public class KadaneAlgorithm {
	public long maxSubarraySum(int[] arr, int n) {

		// Your code here
		long currSum = 0;
		long maxSum = Integer.MIN_VALUE;

		for (int num : arr) {
			currSum += num;

			maxSum = Math.max(maxSum, currSum);

			if(currSum < 0){
				currSum = 0;
			}

		}
		return maxSum;


	}
}
