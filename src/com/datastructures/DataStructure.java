package com.datastructures;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DataStructure {

	public void palindromicNo(int s) {

		int rem, sum = 0, temp;
		temp = s;
		while (s > 0) {
			rem = s % 10;
			sum = (sum * 10) + rem;
			s = s / 10;
		}
		if (temp == sum) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

	public void mySqrt(int x) {
		int result = (int) Math.sqrt(x);
		System.out.println(result);
	}

	public void reverseString(String s) {
		char[] c = s.toCharArray();
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(c[i]);
		}
	}

	public void reverseStringInBuiltFunction(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		System.out.println(stringBuilder.append(str).reverse().toString());
	}


	// remove duplicates by array because map does not store duplicates
	public void mergeTwoArrayByMap(int[] a, int[] b) {
		Map<Integer, Boolean> map = new TreeMap<Integer, Boolean>();
		for (int j : a) {
			map.put(j, true);
		}
		for (int i : b) {
			map.put(b[i], true);
		}

		for (Map.Entry<Integer, Boolean> me : map.entrySet()) {
			System.out.println(me.getKey() + " ");
		}
	}


}

class MyArray {
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
