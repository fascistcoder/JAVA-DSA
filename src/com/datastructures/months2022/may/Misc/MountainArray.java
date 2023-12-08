package com.datastructures.months2022.may.Misc;

import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 06/06/22
 */
public class MountainArray {
	public static boolean validMountainArray(int[] arr) {

		if (arr.length < 3) {
			return false;
		}

		int indexGreaterVal = 0;

		if (arr[1] < arr[0]) {
			return false;
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				indexGreaterVal = i;
				break;
			} else if (arr[i] == arr[i - 1]) {
				return false;
			}
		}

		for (int i = indexGreaterVal + 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1] || arr[i] == arr[i - 1]) {
				return false;
			}
		}

		return true;
	}

	public static boolean checkIfExist(int[] arr) {

		if (arr.length == 0) {
			return false;
		}

		HashSet<Integer> hashSet = new HashSet<>();

		int count = 0;

		for (int num : arr) {
			hashSet.add(num);

			if (num == 0) {
				count++;
			}

		}

		for (int num : arr) {

			if (num != 0 && hashSet.contains(num * 2)) {
				return true;
			} else if (num == 0 && count > 1) {
				return true;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		int[] a = new int[] { -2, 0, 10, -19, 4, 6, -8 };

		System.out.println(checkIfExist(a));
	}
}
