package com.datastructures.june;

import com.datastructures.june.misc.KadaneAlgorithm;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 13/06/22
 */
public class MainClass {
	public static void main(String[] args) {

		int[] a = new int[] { -47, 43, 94, -94, -93, -59, 31, -86 };

		KadaneAlgorithm kadaneAlgorithm = new KadaneAlgorithm();
		System.out.println(kadaneAlgorithm.maxSubarraySum(a, a.length));
	}
}
