package com.datastructures.may;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

		while (sPtr<s.length() && tPtr<t.length()) {
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

		while(firstPtr< numbers.length && secondPtr < numbers.length){
			if(numbers[firstPtr] + numbers[secondPtr] > target ){
				secondPtr--;
			}else if(numbers[firstPtr] + numbers[secondPtr] < target){
				firstPtr++;
			}else {
				res[0] = firstPtr + 1;
				res[1] = secondPtr  + 1;
				break;
			}
		}

		return res;
	}

	public static boolean isPalindrome(String s) {

		String newStr = s.replaceAll(" ","");

		StringBuilder stringBuilder = new StringBuilder();

		String reverse = String.valueOf(stringBuilder.append(newStr).reverse());

		if(newStr.equalsIgnoreCase(reverse)){
			return true;
		};

		return false;
	}

	public static void main(String[] args) {
		//System.out.println(lengthOfLastWord("\"   fly me   to   the moon  "));

		//isAnagram("anaaagram","nagaram");

		//isSubsequence("dd", "");

		int[] a = new int[]{
				2,7,11,15
		};
		//System.out.println(Arrays.toString(twoSum(a, 9)));
		isPalindrome("race a car");
	}
}
