package com.datastructures.months2022.may.Misc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 03/06/22
 */
public class Misc {
	static boolean isIsogram(String data) {
		//Your code here
		HashSet<Character> hashSet = new HashSet<>();

		for (int i = 0; i < data.length(); i++) {
			if (hashSet.contains(data.charAt(i))) {
				return false;
			}
			hashSet.add(data.charAt(i));
		}

		return true;
	}

	class Node {
		int data;
		Node next;

		public Node() {
		}

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static long multiplyTwoLists(Node l1, Node l2) {
		//add code here.

		ArrayList<Integer> L1 = new ArrayList<>();
		ArrayList<Integer> L2 = new ArrayList<>();

		Node current = l1;
		Node current1 = l2;

		while (current != null) {
			L1.add(current.data);
			current = current.next;
		}

		while (current1 != null) {
			L2.add(current1.data);
			current1 = current1.next;
		}

		String s1 = L1.toString().replaceAll("[^A-Za-z0-9]", "");
		String s2 = L2.toString().replaceAll("[^A-Za-z0-9]", "");

		BigInteger b1 = new BigInteger(s1);
		BigInteger b2 = new BigInteger(s2);

		BigInteger ans = b1.multiply(b2);

		return ans.longValue();

	}

	public static void main(String[] args) {
		//		ArrayList<Integer> L1 = new ArrayList<>();
		//		ArrayList<Integer> L2 = new ArrayList<>();
		//
		//		L1.add(3);
		//		L1.add(2);
		//		L2.add(2);
		//
		//		String s1 = L1.toString().replaceAll("[^A-Za-z0-9]", "");
		//		String s2 = L2.toString().replaceAll("[^A-Za-z0-9]", "");
		//
		//		System.out.println(s1);
		//		System.out.println(s2);
		//
		//		long ans = (long) Long.parseLong(s1) * Long.parseLong(s2);
		//
		//		System.out.println(ans);

		int[] a = new int[] { 1, 2, 3 };
		System.out.println(Arrays.toString(Smallestonleft(a, a.length)));

	}

	public static int[] Smallestonleft(int arr[], int n) {
		// Complete the function
		int[] ans = new int[n];

		int j = 1;

		int min = Integer.MAX_VALUE;

		ans[0] = -1;

		for (int i = 1; i < n; i++) {
			min = Math.min(min, ans[i-1]);
			if (arr[i] > min) {
				ans[j] = min;
			} else {
				ans[j] = -1;
			}
			j++;
		}

		//System.out.println(Arrays.toString(ans));

		return ans;
	}

}
