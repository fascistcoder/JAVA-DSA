package com.datastructures.may.Misc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/05/22
 */
public class MyHashTable {

	private static int length;
	private static List<Integer> data;

	public MyHashTable(int size) {
		length = size;
		data = new ArrayList(length);
	}

	public static int hashFn(String key) {
		int hash = 0;

		for (int i = 0; i < key.length(); ++i) {
			hash = (hash + key.charAt(i) * i) % length;
		}

		return hash;
	}

	public static void set(String key, int value) {
		if (data.get(hashFn(key)) == null) {
		}

		data.add(hashFn(key));
	}

	public static void main(String[] args) {
		new MyHashTable(50);
		hashFn("grapes");
	}
}
