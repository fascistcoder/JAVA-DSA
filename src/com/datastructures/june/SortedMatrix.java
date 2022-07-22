package com.datastructures.june;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 24/06/22
 */
public class SortedMatrix {

	public static int sortedMatrix(int[][] mat, int n, int m, int x) {

		int i = 0;
		int j = m - 1;

		while (i < n && j >= 0) {
			if(mat[i][j] == x){
				return 1;
			} else if (mat[i][j] > x) {
				j--;
			}else {
				i++;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int[][] m = new int[][] {
				{ 1, 5, 9, 11 },
				{ 14, 20, 21, 26 },
				{ 30, 34, 43, 50 } };

		int res = sortedMatrix(m, 3, 4, 34);
		System.out.println(res);
	}
}
