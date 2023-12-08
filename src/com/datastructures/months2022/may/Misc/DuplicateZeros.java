package com.datastructures.months2022.may.Misc;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 26/05/22
 */
public class DuplicateZeros {
	public static void duplicateZeros(int[] arr) {
		int[] newArr =new int[arr.length];
		int j = 0;
		for(int i=0; i< arr.length;i++){
			if(j == arr.length){
				break;
			}
			newArr[j] = arr[i];
			if(arr[i] == 0){
				newArr[j+1] = 0;
				j++;
			}
			j++;
		}

		System.out.println(Arrays.toString(newArr));
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,0,2,3,0,4,5,0};

		duplicateZeros(a);
	}
}
