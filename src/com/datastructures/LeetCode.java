package com.datastructures;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode {

	// Q 88
	public void mergeSortedArrayLeeCode(int[] nums1, int m, int[] nums2, int n) {

		// Remove zero in the first Array
		int[] num1Filter = Arrays.stream(nums1).filter(num -> num != 0).toArray();

		// Creating new array object
		int[] mergeArray = new int[m + n];

		// initialize the variables
		int num1Position, num2Position, mergePosition;
		num1Position = num2Position = mergePosition = 0;

		while (num1Position < m && num2Position < n) {
			if (nums1[num1Position] < nums2[num2Position]) {
				mergeArray[mergePosition++] = nums1[num1Position++];
			} else {
				mergeArray[mergePosition++] = nums2[num2Position++];
			}
		}

		while (num1Position < m) {
			mergeArray[mergePosition++] = nums1[num1Position++];
		}

		while (num2Position < n) {
			mergeArray[mergePosition++] = nums2[num2Position++];
		}

		System.arraycopy(mergeArray, 0, nums1, 0, mergeArray.length);

		System.out.println(Arrays.toString(nums1));

	}

	// Q 977
	// Brute Force
	public static void sortedSquares(int[] nums) {

		int numsLength = nums.length;

		int[] sortedSquaresArray = new int[numsLength];

		for (int j = 0; j < nums.length; j++) {
			sortedSquaresArray[j] = nums[j] * nums[j];
		}

		Arrays.sort(sortedSquaresArray);

		System.out.println(Arrays.toString(sortedSquaresArray));
	}

	// Optimized Method
	public static void sortedSquaresOptimized(int[] nums) {

		int[] sortedSquaresArray = Arrays.stream(nums).map(x -> x * x).sorted().toArray();

		System.out.println(Arrays.toString(sortedSquaresArray));
	}

	// Q26
	public static void removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			System.out.println(nums.length);
		}
		int i = 0;
		for (int j = 1; j < nums.length; j++) {     // you can also start j from 0 also .
			if (nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}

		System.out.println(i + 1);
	}

	// Q35
	public static void searchInsert(int[] nums, int target) {
		int k = Arrays.binarySearch(nums, target);
		if (k < 0) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] < target) {
					k = i + 1;
				} else if (nums[0] > target) {
					k = 0;
					break;
				}

			}
		}
		System.out.println(k);
	}

	// Q66
	// for small numbers
	public static void plusOne(int[] digits) {
		long res = 0;
		for (int digit = 0; digit < digits.length; digit++) {
			res = (res * 10) + digits[digit];
			System.out.println(res + " " + digit);
		}
		long convertedNo = res + 1;

		String temp = Long.toString(convertedNo);

		int[] convertedArray = new int[temp.length()];

		for (int i = 0; i < temp.length(); i++) {
			convertedArray[i] = temp.charAt(i) - '0';
		}
		System.out.println(Arrays.toString(convertedArray));
	}

	// Q1
	// Brute force
	public static void twoSum(int[] a, int target) {
		int[] result = new int[2];
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length - 1; j++) {
				if (a[i] + a[j + 1] == target) {
					result[0] = i;
					result[1] = j + 1;
					break;
				}
			}

		}

		System.out.println(Arrays.toString(result));
	}

	// Q1
	// optimized
	public static void twoSumOptimized(int[] a, int target) {
		int[] copiedArray = Arrays.copyOf(a, a.length);
		Arrays.sort(copiedArray);
		int i = 0;
		int j = copiedArray.length - 1;
		int[] result = new int[2];
		result[0] = -1;
		for (int k = 0; k < copiedArray.length; k++) {
			if (copiedArray[i] + copiedArray[j] == target) {
				break;
			} else if (copiedArray[i] + copiedArray[j] < target) {
				i++;
			} else {
				j--;
			}
		}

		for (int k = 0; k < a.length; k++) {
			if (result[0] == -1 && a[k] == copiedArray[i]) {
				result[0] = k;
			} else if (a[k] == copiedArray[j]) {
				result[1] = k;
			}
		}
		System.out.println(Arrays.toString(result));
	}

	public static void containsDuplicate(int[] nums) {
		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == nums[i + 1]) {
				System.out.println("true");
				break;
			}
		}
		System.out.println("false");
	}

	public static void moveZeros(int[] nums) {
		//Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				int temp = nums[count];
				nums[count] = nums[i];
				nums[i] = temp;
				count++;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void LongestWord(String sen) {

		String regex = "[^A-Za-z0-9]";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(sen);

		String words1 = matcher.replaceAll(" ");

		//String[] words = words1.split(" ");

		String[] words = sen.split("[^A-Za-z0-9]");

		int l = 0;

		String res = null;

		for (String word : words) {
			if (l < word.length()) {
				res = word;
				l = word.length();
			}
		}

		System.out.println(res);

	}

	public static void main(String[] args) {
		int[] a = new int[] { -4, -1, 0, 3, 10 };
		int[] b = new int[] { 0, 1, 0, 3, 12 };
		int[] x = new int[] { 1, 1, 0, 7, 6, 5, 4, 3, 2, 1, 1 };
		//	sortedSquares(a);
		//	sortedSquaresOptimized(a);
		//removeDuplicates(b);
		//searchInsert(x, 0);
		//plusOne(x);

		//twoSumOptimized(b, 10);
		//containsDuplicate(x);
		// moveZeros(b);

		//LongestWord("fun&!! time");}

	}
}
