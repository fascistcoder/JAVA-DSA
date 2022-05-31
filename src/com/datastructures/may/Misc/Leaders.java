package com.datastructures.may.Misc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/05/22
 */
public class Leaders {
	public static ArrayList<Integer> leaders(int arr[], int n){
		// Your code here
		ArrayList<Integer> a = new ArrayList<>();

		int max = arr[n-1];

		a.add(max);

		for (int i=n-2; i>0;i--){
			if(arr[i] > max){
				a.add(arr[i]);
				max = arr[i];
			}
		}

		Collections.reverse(a);
		return a;

	}

	public static void main(String[] args) {
		int[] a= new int[]{16,17,4,3,5,2};
		System.out.println(leaders(a, a.length));
	}
}
