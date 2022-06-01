package com.datastructures.may.StackQ;

import java.util.Stack;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/06/22
 */
public class SortStack {
	public static Stack<Integer> sort(Stack<Integer> s) {
		//add code here.
		int[] a = new int[s.size()];

		int size = s.size();

		int m = 0;

		while (!s.empty()) {
			a[m++] = s.peek();
			s.pop();
		}

		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}

		for (int i = size - 1; i >= 0; i--) {
			s.push(a[i]);
		}

		return s;
	}
}
