package com.datastructures.Hashing;

import java.util.ArrayList;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 25/11/23
 */
public class QuadraticProbing {
	String[] hashTable;
	int usedCellNumber;

	QuadraticProbing(int size) {
		hashTable = new String[size];
		usedCellNumber = 0;
	}

	public static void main(String[] args) {
		QuadraticProbing quadraticProbing = new QuadraticProbing(13);
		quadraticProbing.insertInHashtable("the");
		quadraticProbing.insertInHashtable("quick");
		quadraticProbing.insertInHashtable("brown");
		quadraticProbing.insertInHashtable("fox");
		quadraticProbing.insertInHashtable("over");
		quadraticProbing.displayHashTable();
		quadraticProbing.searchHashTable("over");
		quadraticProbing.searchHashTable("pp");
	}

	public int modASCIIHashFunction(String word, int M) {
		char[] ch;
		ch = word.toCharArray();
		int i, sum;

		for (sum = 0, i = 0; i < word.length(); i++) {
			sum += ch[i];
		}
		return sum % M;
	}

	public Double getLoadFactor() {
		return usedCellNumber * 1.0 / hashTable.length;
	}

	//rehash
	public void rehashKey(String word) {
		ArrayList<String> data = new ArrayList<>();
		for (String s : hashTable) {
			if (s != null) {
				data.add(s);
			}

			data.add(word);
			hashTable = new String[hashTable.length * 2];

			for (String s1 : data) {
				insertInHashtable(s1);
			}

		}
	}

	public void insertInHashtable(String word) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			rehashKey(word);
		} else {
			int index = modASCIIHashFunction(word, hashTable.length);
			int counter = 0;
			for (int i = index; i < index + hashTable.length; i++) {
				int newIndex = (index + (counter * counter)) % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("the " + word + " successfully inserted at location " + newIndex);
					break;
				} else {
					System.out.println(newIndex + " is already occupied. Trying next empty cell ");
				}
				counter++;
			}
		}
		usedCellNumber++;

	}

	public void displayHashTable() {
		if (hashTable == null) {
			System.out.println("\n Hashtable does not exists");
		} else {
			System.out.println("Loading-----Hashtable--------");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("index " + i + ", key: " + hashTable[i]);
			}
		}
	}

	public boolean searchHashTable(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				System.out.println(word + " found at location " + newIndex);
				return true;
			}
		}
		System.out.println(word + " not found in hashtable");
		return false;
	}

	public void deleteKeyHashTable(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;
			if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
				hashTable[newIndex] = null;
				System.out.println(word + " has been deleted successfully");
				return;
			}
		}
		System.out.println(word + " not found in hash table");
	}

	public void insertInHashtableDoubleHashing(String word) {
		double loadFactor = getLoadFactor();
		if (loadFactor >= 0.75) {
			rehashKey(word);
		} else {
			int index = modASCIIHashFunction(word, hashTable.length);
			int y = secondHashFunction(word, hashTable.length);
			for (int i = index; i < index + hashTable.length; i++) {
				int newIndex = (index + index * y) % hashTable.length;
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println("the " + word + " successfully inserted at location " + newIndex);
					break;
				} else {
					System.out.println(newIndex + " is already occupied. Trying next empty cell ");
				}
			}
		}
		usedCellNumber++;

	}

	private int addAllDigitsTogether(int sum) {
		int value = 0;
		while (sum > 0) {
			value = sum * 10;
			sum = sum / 10;
		}
		return value;
	}

	public int secondHashFunction(String x, int M) {
		char[] ch;
		ch = x.toCharArray();
		int i, sum;
		for (sum = 0, i = 0; i < x.length(); i++) {
			sum += ch[i];
		}

		while (sum > hashTable.length) {
			sum = addAllDigitsTogether(sum);
		}

		return sum % M;
	}
}
