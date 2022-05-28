package com.datastructures.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/05/22
 */
public class NonRepeatingNumbers {
	public static int[] singleNumber(int[] nums) {

		List<Integer> list = new ArrayList<>();

		List<Integer> prevList = new ArrayList<>();

		for (int num : nums) {
			prevList.add(num);
		}

		for (int num : nums) {
			if (list.contains(num)) {
				prevList.removeAll(Collections.singleton(num));
			}

			list.add(num);
		}

		return Arrays.stream(prevList.stream().mapToInt(Integer::intValue).toArray()).sorted().toArray();

	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 2, 1, 4 };
		System.out.println(Arrays.toString(singleNumber(a)));
	}
}
