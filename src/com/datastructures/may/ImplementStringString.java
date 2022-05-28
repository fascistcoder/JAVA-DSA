package com.datastructures.may;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 28/05/22
 */
public class ImplementStringString {

	public static int strstr(String s, String x)
	{
		// Your code here

		if(s.contains(x)){
			int res = s.indexOf(x);
			System.out.println(true);
			return res;
		}

		return 1;
	}

	public static void main(String[] args) {
		System.out.println(strstr("GeeksForGeeks", "For"));
	}
}
