package com.datastructures.months2022.may.Misc;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/05/22
 */
public class PrintLargest {
	public static String printLargest(String[] arr) {
		// code here

		Arrays.sort(arr, (x,y) -> (y+x).compareTo(x+y));

		return Arrays.toString(arr).replaceAll("[^A-Za-z0-9]", "");
	}

	public static void main(String[] args) {
		String[] str = new String[]{"3", "30", "34", "5", "9"};
		System.out.println(printLargest(str));
	}
}
