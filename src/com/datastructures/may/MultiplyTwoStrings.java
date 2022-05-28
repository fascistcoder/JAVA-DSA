package com.datastructures.may;

import java.math.BigInteger;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 27/05/22
 */
public class MultiplyTwoStrings {

	public static String multiplyTwoString(String s1, String s2) {

		BigInteger a = new BigInteger(s1);
		BigInteger b = new BigInteger(s2);
		BigInteger result = b.multiply(a);

		return String.valueOf(result);

	}

	public static void main(String[] args) {
		System.out.println(multiplyTwoString("11", "22"));
	}
}
