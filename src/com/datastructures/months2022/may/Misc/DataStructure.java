package com.datastructures.months2022.may.Misc;

import java.util.Map;
import java.util.TreeMap;

public class DataStructure {

	public void palindromicNo(int s) {

		int rem, sum = 0, temp;
		temp = s;
		while (s > 0) {
			rem = s % 10;
			sum = (sum * 10) + rem;
			s = s / 10;
		}
		if (temp == sum) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public void mySqrt(int x) {
		int result = (int) Math.sqrt(x);
		System.out.println(result);
	}

	public void reverseString(String s) {
		char[] c = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(c[i]);
		}
	}

	public void reverseStringInBuiltFunction(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		System.out.println(stringBuilder.append(str).reverse().toString());
	}

	// remove duplicates by array because map does not store duplicates
	public void mergeTwoArrayByMap(int[] a, int[] b) {
		Map<Integer, Boolean> map = new TreeMap<Integer, Boolean>();
		for (int j : a) {
			map.put(j, true);
		}
		for (int i : b) {
			map.put(b[i], true);
		}

		for (Map.Entry<Integer, Boolean> me : map.entrySet()) {
			System.out.println(me.getKey() + " ");
		}
	}

}
