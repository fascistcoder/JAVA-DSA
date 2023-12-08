package com.datastructures.months2022.may.StackQ;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/06/22
 */
public class Stack1 {

	List<Integer> arrayList = new ArrayList<>();

	public Stack1() {
	}

	public int peek() {

		if (arrayList.size() == 0) {
			throw new EmptyStackException();
		}
		return arrayList.get(arrayList.size() - 1);
	}

	public int pop() {
		if (arrayList.size() == 0) {
			throw new EmptyStackException();
		}

		return arrayList.remove(arrayList.size() - 1);
	}

	public void push(int valueToPush) {

		arrayList.add(valueToPush);
	}

}
