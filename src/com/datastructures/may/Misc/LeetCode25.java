package com.datastructures.may.Misc;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/05/22
 */
public class LeetCode25 {
	public static int lengthOfLastWord(String s) {

		String res;

		int count = 0;

		System.out.println(s.charAt(s.length() - 1));

		res = s.trim();

		for (int i = res.length() - 1; i >= 0; i--) {

			if (res.charAt(i) != ' ') {
				count++;
			} else {
				break;
			}
		}

		return count;
	}

	public static boolean isAnagram(String s, String t) {

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		Arrays.sort(sArray);
		Arrays.sort(tArray);

		return Arrays.equals(sArray, tArray);
	}

	public static boolean isSubsequence(String s, String t) {

		//		char[] sArray = s.toCharArray();
		//		char[] tArray = t.toCharArray();
		//
		//		Arrays.sort(sArray);
		//		Arrays.sort(tArray);
		//
		//		for (int i = 0; i < sArray.length; i++) {
		//			if (tArray[i] != sArray[i]) {
		//				System.out.println("false");
		//				return false;
		//			}
		//		}
		//
		//		System.out.println("true");
		//		return true;

		int sPtr = 0;
		int tPtr = 0;

		while (sPtr < s.length() && tPtr < t.length()) {
			if (s.charAt(sPtr) == t.charAt(tPtr)) {
				sPtr++;
			}
			tPtr++;
		}

		return sPtr == s.length();

	}

	public static int[] twoSum(int[] numbers, int target) {

		int firstPtr = 0;
		int secondPtr = numbers.length - 1;

		int[] res = new int[2];

		while (firstPtr < numbers.length && secondPtr < numbers.length) {
			if (numbers[firstPtr] + numbers[secondPtr] > target) {
				secondPtr--;
			} else if (numbers[firstPtr] + numbers[secondPtr] < target) {
				firstPtr++;
			} else {
				res[0] = firstPtr + 1;
				res[1] = secondPtr + 1;
				break;
			}
		}

		return res;
	}

	public static boolean isPalindrome(String s) {

		String newStr = s.replaceAll(" ", "");

		StringBuilder stringBuilder = new StringBuilder();

		String reverse = String.valueOf(stringBuilder.append(newStr).reverse());

		if (newStr.equalsIgnoreCase(reverse)) {
			return true;
		}
		;

		return false;
	}

	public static int[] reverse(int[] a) {
		int n = a.length;
		int t;
		for (int i = 0; i < n / 2; i++) {
			t = a[i];
			a[i] = a[n - i - 1];
			a[n - i - 1] = t;
		}

		return a;

	}

	public static int[] fn(int[] nums, int k) {

		int[] a = Arrays.copyOfRange(nums, 0, k + 1);

		int[] b = Arrays.copyOfRange(nums, k + 1, nums.length);

		int[] result = new int[a.length + b.length];

		System.arraycopy(b, 0, result, 0, b.length);
		System.arraycopy(a, 0, result, b.length, a.length);

		return result;
	}

	public static void rotate(int[] nums, int k) {

		if (nums.length == 0) {
			return;
		}

		nums = fn(nums, k);

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
		}

		System.out.println(nums);

	}

	public static void reverseString(char[] s) {

		char[] s1 = new char[s.length];

		int j = 0;

		for (int i = s1.length - 1; i >= 0; i--) {
			s1[j] = s[i];
			j++;
		}

		System.out.println(Arrays.toString(s1));
	}

	public static void reverseStr(String s, int k) {
		String n = s.substring(0, k);
		String j = s.substring(k);

		System.out.println(n);
		System.out.println(j);

		StringBuilder stringBuilder = new StringBuilder();
		n = stringBuilder.append(n).reverse().toString();

		System.out.println(n);

		String res = n.concat(j);
		System.out.println(res);
	}

	public static double findMaxAverage(int[] nums, int k) {
		double max_av = 0;

		int max_sum = 0;

		for (int i = 0; i < k; i++) {
			max_sum += nums[i];
		}

		int window_sum = max_sum;

		for(int i=k ; i < nums.length; i++){
			window_sum += nums[i] - nums[i-k];

			max_sum = Math.max(max_sum, window_sum);
		}

		System.out.println(max_sum);

		max_av = (double) max_sum / k;
		return max_av;
	}



	public static void main(String[] args) {
		//System.out.println(lengthOfLastWord("\"   fly me   to   the moon  "));

		//isAnagram("anaaagram","nagaram");

		//isSubsequence("dd", "");

		int[] a = new int[] {
				1,12,-5,-6,50,3
		};
		//System.out.println(Arrays.toString(twoSum(a, 9)));
		//isPalindrome("race a car");

		//rotate(a, 3);

		char[] c = new char[] {
				'h', 'e', 'l', 'l', 'o'
		};
		//reverseString(c);

		//reverseStr("abcdefg", 2);

		System.out.println(findMaxAverage(a,4));
	}
}
