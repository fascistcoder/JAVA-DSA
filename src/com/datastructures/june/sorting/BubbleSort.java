package com.datastructures.june.sorting;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 13/06/22
 */
public class BubbleSort {
	public static void bubbleSort(int[] a){

		int temp = 0;

		for(int i=0; i<a.length; i++){
			for(int j=0; j<a.length-1; j++){
				if(a[j] > a[j+1]){
					temp = a[i];
					a[i] = a[j+1];
					a[j+1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(a));
	}

	public static void main(String[] args) {

		int[] a = new int[] {4,2,8,81,1};

		bubbleSort(a);
	}
}
