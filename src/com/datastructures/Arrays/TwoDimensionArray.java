package com.datastructures.Arrays;

import java.util.Arrays;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/11/23
 */
public class TwoDimensionArray {

	int[][] arr = null;

	public static void main(String[] args) {
		int[][] int2DArray = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Arrays.deepToString(int2DArray));

		TwoDimensionArray twoDimensionArray = new TwoDimensionArray(3, 3);
		twoDimensionArray.insertionValue(0, 0, 1);
		twoDimensionArray.insertionValue(0, 1, 2);
		twoDimensionArray.insertionValue(0, 2, 3);
		twoDimensionArray.insertionValue(1, 0, 4);
		twoDimensionArray.insertionValue(1, 1, 5);
		twoDimensionArray.insertionValue(1, 2, 6);
		twoDimensionArray.insertionValue(2, 0, 7);
		twoDimensionArray.insertionValue(2, 1, 8);
		twoDimensionArray.insertionValue(2, 2, 9);

		//		twoDimensionArray.insertionValue(0,0,4);
		System.out.println(Arrays.deepToString(twoDimensionArray.arr));

		//		twoDimensionArray.accessValue(0, 1);
		//		twoDimensionArray.traverse2DArray();
		//
		//		twoDimensionArray.searchArrayValue(9);
		//
		//		twoDimensionArray.deleteAnElementIn2DArray(1,1);
		//
		//		twoDimensionArray.traverse2DArray();

		System.out.println(twoDimensionArray.sumDiagonalElements(int2DArray));
	}

	public TwoDimensionArray(int numOfRows, int numOfColumns) {
		this.arr = new int[numOfRows][numOfColumns];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				arr[row][col] = Integer.MIN_VALUE;
			}
		}
	}

	public void insertionValue(int row, int col, int value) {
		try {
			if (arr[row][col] == Integer.MIN_VALUE) {
				arr[row][col] = value;
				System.out.println("Value successfully Inserted");
			} else {
				System.out.println("This cell is already occupied");
			}
		} catch (Exception e) {
			System.out.println("Error inserting value " + e.getMessage());
		}
	}

	public void accessValue(int row, int col) {
		System.out.println("Accessing row " + row + ", Col " + col);
		try {
			System.out.println("Cell value is " + arr[row][col]);
		} catch (Exception e) {
			System.out.println("Invalid index for 2D array");
		}
	}

	public void traverse2DArray() {
		for (int[] row : arr) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(row[col] + " ");
			}
			System.out.println();

		}
	}

	public void searchArrayValue(int val) {
		try {
			for (int row = 0; row < arr.length; row++) {
				for (int col = 0; col < arr[0].length; col++) {
					if (arr[row][col] == val) {
						System.out.println("This element we are searching row : " + row + " col: " + col);
						return;
					} else {
						System.out.println("Value is not found in the array");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error searching in the array " + e.getMessage());
		}
	}

	public void deleteAnElementIn2DArray(int row, int col) {
		try {
			arr[row][col] = Integer.MIN_VALUE;
			System.out.println("Element is deleted successfully");
		} catch (Exception e) {
			System.out.println("Exception deleting the value " + e.getMessage());
		}
	}

	public int sumDiagonalElements(int[][] array) {
		int sum = 0;
		for (int row = 0; row < array.length; row++) {

			sum += array[row][row];
		}

		return sum;
	}

}
