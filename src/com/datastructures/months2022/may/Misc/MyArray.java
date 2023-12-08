package com.datastructures.months2022.may.Misc;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/05/22
 */
public class MyArray {
	int length;
	Object[] data;
	int capacity;

	public MyArray() {
		length = 0;
		data = new Object[1];
		capacity = 1;
	}

	public Object get(int index) {
		return data[index];
	}

	public void push(Object obj) {
		if (capacity == length) {
			data = Arrays.copyOf(data, capacity * 2);
			capacity *= 2;
		}
		data[length] = obj;
		length++;
	}

	public void pop() {
		data[length - 1] = null;
		length--;
	}

	public void delete(int index) {
		if (length - 1 - index >= 0) {
			System.arraycopy(data, index + 1, data, index, length - 1 - index);
		}
		data[length - 1] = null;
		length--;
	}

}
