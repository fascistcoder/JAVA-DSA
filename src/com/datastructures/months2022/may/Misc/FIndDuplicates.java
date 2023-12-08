package com.datastructures.months2022.may.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/06/22
 */
public class FIndDuplicates {
	public static List<Integer> duplicates(int[] arr) {
		// code

		//		Arrays.sort(arr);
		//
		//		HashSet<Integer> hashSet = new HashSet<>();
		//
		//		ArrayList<Integer> arrayList = new ArrayList<>();
		//
		//		for (int num : arr){
		//
		//			if(hashSet.contains(num)){
		//				if(!arrayList.contains(num)){
		//					arrayList.add(num);
		//				}
		//			}
		//
		//			hashSet.add(num);
		//		}
		//
		//		if(arrayList.isEmpty()){
		//			arrayList.add(-1);
		//		}
		//
		//		return arrayList;

		Arrays.sort(arr);

		ArrayList<Integer> arrayList = new ArrayList<>();

		int lastOccurrence = -1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1] && lastOccurrence != arr[i]) {
				arrayList.add(arr[i]);
				lastOccurrence = arr[i];
			}
		}

		if (arrayList.isEmpty()) {
			arrayList.add(-1);
			return arrayList;
		}

		return arrayList;
	}

	public static void main(String[] args) {

		int[] a = new int[] { 17, 17, 13, 13, 9, 25, 25, 10, 3, 15, 11, 19, 20, 2, 4, 25 };

		System.out.println(duplicates(a));
	}
}
