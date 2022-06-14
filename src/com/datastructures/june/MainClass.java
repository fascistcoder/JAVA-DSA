package com.datastructures.june;

import com.datastructures.june.misc.MaxSumSubarray;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 13/06/22
 */
public class MainClass {
	public static void main(String[] args) {

		int[] a = new int[] { 1, 2, 1, 3, 4, 2, 3 };

		//		KadaneAlgorithm kadaneAlgorithm = new KadaneAlgorithm();
		//		System.out.println(kadaneAlgorithm.maxSubarraySum(a, a.length));

		MaxSumSubarray maxSumSubarray = new MaxSumSubarray();
		System.out.println(maxSumSubarray.countDistinct(a, a.length, 4));
	}
}
