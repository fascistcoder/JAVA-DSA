package com.datastructures.Arrays;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/11/23
 */
public class SingleDimensionArray {
	int[] arr = null;

	public static void main(String[] args) {
		int[] intArray = new int[3];
		intArray[0] = 1;
		intArray[2] = 3;
		intArray[1] = 2;

		System.out.println(Arrays.toString(intArray));

		SingleDimensionArray singleDimensionArray = new SingleDimensionArray(3);
		singleDimensionArray.insert(2, 20);
		singleDimensionArray.insert(1, 20);
		singleDimensionArray.insert(0, 30);

		System.out.println("first element " + singleDimensionArray.arr[0]);

		singleDimensionArray.traverseArray();

		singleDimensionArray.searchAnElement(3);
		singleDimensionArray.searchAnElement(20);
	}

	public SingleDimensionArray(int sizeOfArray) {
		arr = new int[sizeOfArray];

		for (int i = 0; i < sizeOfArray; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
	}

	public void insert(int location, int value) {
		try {
			if (arr[location] == Integer.MIN_VALUE) {
				arr[location] = value;
				System.out.println("Successfully Inserted");
			} else {
				System.out.println("This cell is already occupied");
			}
		} catch (Exception e) {
			System.out.println("Exception inserting the code " + e.getMessage());
		}
	}

	public void traverseArray() {
		for (int j : arr) {
			System.out.println(j + " ");
		}
	}

	public void searchAnElement(int value) {
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == value) {
				System.out.println("Value is found at the index " + j);
				return;
			}
		}
		System.out.println("Value is not found");

	}

	public void deleteAnElement(int value){
		try{
			arr[value] = Integer.MIN_VALUE;
			System.out.println("Element is deleted successfully");
		}catch (Exception e){
			System.out.println("Exception deleting the value " + e.getMessage());
		}
	}
}
