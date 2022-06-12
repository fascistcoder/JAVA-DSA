package com.datastructures.june.misc;

import java.util.Stack;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 12/06/22
 */
public class DeleteMiddleElement {
	//Function to delete middle element of a stack.
	public void deleteMid(Stack<Integer> s, int sizeOfStack) {
		// code here

		int mid = s.size() / 2;
		if (s.size() % 2 == 0) {
			s.removeElementAt(mid - 1);
		} else {

			s.removeElementAt(mid);
		}

	}
}
