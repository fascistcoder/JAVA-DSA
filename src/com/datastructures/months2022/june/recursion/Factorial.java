package com.datastructures.months2022.june.recursion;

import java.util.Objects;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 12/06/22
 */
public class Factorial {

	// Identify the base case
	// Identify the recursive case
	// Get closer and closer and return when needed. Usually you have 2 returns

	private static int findFactorialNumberRecursive(int n) {

		if (n == 0 || n == 1) {
			return 1;
		}

		return n * findFactorialNumberRecursive(n - 1);
	}

	private static int findFactorialNumberIterative(int n) {
		int fact = 1;

		for (int i = 1; i <= n; i++) {
			fact *= i;
		}

		return fact;
	}

	private static void fibonacciIterative(int n) {
		int first = 0;
		int second = 1;
		int c = 0;

		while (c < n) {
			System.out.println(first + " ");

			int third = first + second;
			first = second;
			second = third;
			c++;
		}
	}

	private static int fibonacciRecursive(int n) {
		if (n <= 1) {
			return n;
		}

		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	private static String reverseStringRecursiverly(String s) {
		if (Objects.equals(s, "")) {
			return "";
		}
		return reverseStringRecursiverly(s.substring(1)) + s.charAt(0);
	}

	public static void main(String[] args) {
		//System.out.println(findFactorialNumberRecursive(5));
		//System.out.println(findFactorialNumberIterative(4));
		System.out.println(reverseStringRecursiverly("pulkit"));
	}
}
