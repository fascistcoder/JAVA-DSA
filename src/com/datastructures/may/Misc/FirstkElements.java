package com.datastructures.may.Misc;

import java.util.HashMap;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/05/22
 */
public class FirstkElements {
	public static int firstElementKTime(int[] a, int n, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();

		for(int num : a){

			if(hashMap.containsKey(num)){
				hashMap.put(num, hashMap.get(num)+1);
			}else{
				hashMap.put(num, 1);
			}
			if(hashMap.get(num) == k){
				return num;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] a= new int[]{1, 7, 4, 3, 4, 8, 7,7};
		System.out.println(firstElementKTime(a, a.length, 3));
	}
}
