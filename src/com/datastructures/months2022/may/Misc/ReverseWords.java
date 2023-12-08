package com.datastructures.months2022.may.Misc;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 29/05/22
 */
public class ReverseWords {

	public static String reverseWords(String S){

		String[] r = S.split("\\.");
		String[] r1 = new String[r.length];

		int j = 0;

		for (int i = r.length - 1; i >= 0; i--){
			r1[i] = r[j];
			j++;
		}

		String res = Arrays.toString(r1).replaceAll("[,]", ".");

		return res.replaceAll("[\\[\\]' ']", "");

	}

	public static void main(String[] args) {
		System.out.println(reverseWords("i.like.this.program.very.much"));
	}
}
