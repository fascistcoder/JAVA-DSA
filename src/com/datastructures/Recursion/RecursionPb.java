package com.datastructures.Recursion;

import java.math.BigInteger;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/11/23
 */
public class RecursionPb {
	public static void main(String[] args) {
		System.out.println(Fibonacci(6));
		//		System.out.println(sumOfDigits(479));
		// System.out.println(power(2, 1));
		// System.out.println(dToB(7));
	}

	public int factorial(int num) {
		if (num == 0 || num == 1) {
			return 1;
		}

		return num * factorial(num - 1);
	}

	public static int Fibonacci(int n) {

		if (n < 0) {
			return 1;
		}

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}


		return Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	public static int sumOfDigits(int n) {

		if (n < 10) {
			return n;
		}

		return n % 10 + sumOfDigits(n / 10);
	}

	public static BigInteger power(int base, int exp) {

		if (exp == 0) {
			return BigInteger.valueOf(1);
		}
		BigInteger result = BigInteger.valueOf(base);

		return result.multiply(power(base, exp - 1));
	}

	public static int gcd(int n1, int n2) {

		if (n2 == 0) {
			return n1;
		}

		return gcd(n1, n1 % n2);
	}

	public static int dToB(int n) {

		if(n == 0){
			return 0;
		}

		return (n % 2) + (10 * dToB(n / 2));
	}

	public static int productofArray(int A[], int N)
	{
		int res  = 1;
		for(int num : A){
			res *= num;
		}
		return res;
	}

	public int recursiveRange(int num) {
		if(num == 0){
			return 0;
		}

		return num + recursiveRange(num - 1);
	}

	public String reverse(String str)
	{
		// TODO
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}
	static char first(String str) {
		//   TODO
		for(char c : str.toCharArray()){
			if(Character.isUpperCase(c)){
				return c;
			}
		}

		return '\0';
	}

	public static String capitalizeWord(String str){
		//   TODO
		if (str == null || str.isEmpty()) {
			return str; // Handle null or empty string
		}

		String[] words = str.split(" ");
		StringBuilder result = new StringBuilder();

		for (String word : words) {
			if (!word.isEmpty()) {
				char firstChar = Character.toUpperCase(word.charAt(0));
				result.append(firstChar).append(word.substring(1)).append(" ");
			}
		}

		// Remove the trailing space
		if (result.length() > 0) {
			result.setLength(result.length() - 1);
		}

		return result.toString();
	}

}
