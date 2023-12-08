package com.datastructures.months2022.may.Misc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/05/22
 */
public class ReverseArraysInGroup {

	private static void  reverse(ArrayList<Integer> arr, int n, int k){

		ArrayList<Integer> list = new ArrayList<>();

		for(int i=n; i<=k;i++){
			list.add(arr.get(i));
		}

		Collections.reverse(list);

	}
	public static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
		// code here

		for (int i = 0; i < arr.size(); i+=k) {
			if (i + k < n) {
				reverse(arr, i, i + k - 1);
			} else {
				reverse(arr, i, n - 1);
			}
		}

	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		reverseInGroups(a, 6, 3);
	}
}
