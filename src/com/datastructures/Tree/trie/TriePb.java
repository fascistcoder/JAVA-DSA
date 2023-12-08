package com.datastructures.Tree.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 04/12/23
 */
public class TriePb {
	public static void main(String[] args) {
		//	largestGoodInteger("4818042931906802860005960222213336669500011846936171709111");
		//System.out.println(largestOddNumber("511213572"));
		strStr("sadbutsad","sad");

	}

	static String largestGoodInteger(String num) {
		Map<Character, Integer> map = new HashMap<>();
		List<Character> list = new ArrayList<>();
		int currentCount = 0;
		for (int i = 0; i < num.length(); i++) {
			char currentChar = num.charAt(i);
			if (i > 0 && num.charAt(i) != num.charAt(i - 1)) {
				currentCount = 1;
			} else {
				currentCount++;
			}
			if (currentCount >= 3) {
				map.put(num.charAt(i), currentCount);
			}
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= 3) {
				list.add(entry.getKey());
			}
		}

		System.out.println(map);
		System.out.println(list);
		if (list.isEmpty()) {
			return "";
		}
		String res = String.valueOf(list.get(list.size() - 1)).repeat(3);
		System.out.println(res);
		return res;
	}

	public static String largestOddNumber(String num) {

		String res = num;
		for (int i = num.length() - 1; i >= 0; i--) {
			if (num.charAt(i) % 2 == 0) {
				res = res.substring(0, res.length() - 1);
			} else {
				return res;
			}
		}

		return "";
	}

	public static int strStr(String haystack, String needle) {
		if(haystack.contains(needle)){
			System.out.println(haystack.indexOf(needle, 0));
			return -1;
		}
		return -1;
	}
}
