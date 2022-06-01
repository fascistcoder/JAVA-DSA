package com.datastructures.may.StackQ;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/06/22
 */
public class ReverseStack {
	public static ArrayList<Integer> reverse(Stack<Integer> s) {
		// add your code here
		ArrayList<Integer> newList = new ArrayList<>();

		int size = s.size();

		for (int i = 0; i < size; i++) {
			newList.add(s.peek());
			s.pop();
		}

		return newList;
	}
}
