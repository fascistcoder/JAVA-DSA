package com.datastructures.may.Misc;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/05/22
 */
public class CompareTwoArrays {
	public static boolean check(long A[],long B[],int N)
	{
		//Your code here
		Arrays.sort(A);
		Arrays.sort(B);

		return Arrays.equals(A, B);
	}
}
