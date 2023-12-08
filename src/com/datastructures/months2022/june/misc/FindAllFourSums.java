package com.datastructures.months2022.june.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 14/06/22
 */
public class FindAllFourSums {
	public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
		// code here

		if (arr.length < 4) {
			return null;
		}

		ArrayList<Integer> list1 = new ArrayList<>();

		Set<ArrayList<Integer>> set = new LinkedHashSet<>();

		Arrays.sort(arr);

		int length = arr.length;
		int sum = 0;

		for (int i = 0; i < length - 3; i++) {
			int firstElement = arr[0];
			for (int j = i + 1; j < length - 2; j++) {
				int secondElement = arr[j];
				int left = j + 2;
				int right = length - 1;

				while (left < right) {
					sum = firstElement + secondElement + arr[left] + arr[right];

					if(sum == k){
						list1.add(firstElement);
						list1.add(secondElement);
						list1.add(arr[left]);
						list1.add(arr[right]);
						set.add(list1);
						right--;
					} else if (sum < k) {
						left++;
					}else {
						right--;
					}
				}
			}
		}

		return new ArrayList<>(set);
	}
}
