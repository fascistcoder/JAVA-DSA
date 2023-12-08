package com.datastructures.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 10/11/23
 */
public class ArrayCodingExercise {
	public static void main(String[] args) {
		//		Scanner scanner = new Scanner(System.in);
		//		int length = scanner.nextInt();
		//		int[] arr = new int[length];
		//
		//		for (int i = 0; i<length ; i++){
		//			arr[i] = scanner.nextInt();
		//		}
		//
		//		System.out.println(Arrays.toString(middle(arr)));

		int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] nums2 = new int[] { 2, 5, 6 };
		merge(nums1, 3, nums2, 3);
	}

	public static int[] middle(int[] arr) {
		int j = 0;
		int[] newArr = new int[arr.length - 2];

		for (int i = 1; i < arr.length - 1; i++) {
			newArr[j] = arr[i];
			j++;
		}

		return newArr;
	}

	public static int[] optimizeSolMiddle(int[] arr) {
		return Arrays.copyOfRange(arr, 1, arr.length - 1);
	}

	public static int[] findTopTwoScores(int[] array) {
		if (array.length < 2) {
			return array;
		}
		int[] newArr = Arrays.stream(array).distinct().toArray();
		Arrays.sort(newArr);

		int[] bestScore = new int[2];
		bestScore[0] = newArr[newArr.length - 1];
		bestScore[1] = newArr[newArr.length - 2];

		return bestScore;
	}

	static int findMissingNumberInArray(int[] arr, int n) {
		// TODO
		int expectedSum = (n * (n + 1)) / 2;
		int actualSum = 0;

		for (int val : arr) {
			actualSum += val;
		}

		return expectedSum - actualSum;
	}

	public static int[] removeDuplicates(int[] arr) {
		//return Arrays.stream(arr).distinct().toArray()
		return new int[3];

	}

	public static int sumDiagonalElements(int[][] array) {
		int sum = 0;
		for (int row = 0; row < array.length; row++) {
			sum += array[row][row];
		}
		return sum;
	}

	public static int maxProfit(int[] prices) {
		int max = 0;

		// O(n^2)
		for (int t = 0; t < prices.length - 1; t++) {
			for (int i = t + 1; i < prices.length; i++) {
				if ((prices[i] - prices[t]) > 0) {
					int diff = prices[i] - prices[t];
					max = Math.max(max, diff);
				}
			}
		}

		// O(n)
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int price : prices) {
			if (price < minPrice) {
				minPrice = price;
			} else if (price - minPrice > maxProfit) {
				maxProfit = price - minPrice;
			}
		}

		return maxProfit;
	}

	public static int[] twoSum(int[] nums, int target) {
		// TODO
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};
	}

	public static int searchInArray(int[] arr, int value) {
		// TODO
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == value) {
				return j;
			}
		}
		return -1;
	}

	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();

		for (int num : nums) {
			if (hashSet.contains(num)) {
				return true;
			}
			hashSet.add(num);
		}

		return false;
	}

	public String maxProduct(int[] intArray) {
		// TODO
		Arrays.sort(intArray);

		int[] ans = new int[] { intArray[intArray.length - 1], intArray[intArray.length - 2] };

		return Arrays.toString(ans).replaceAll("[\\[\\]' ']", "");
	}

	public boolean permutation(int[] array1, int[] array2) {
		// TODO
		Arrays.sort(array1);
		Arrays.sort(array2);
		return Arrays.equals(array1, array2);
	}

	public boolean rotate(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) {
			return false;
		}

		int row = matrix.length;
		for (int layer = 0; layer < row / 2; layer++) {
			int first = layer;
			int last = row - 1 - layer;
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last - offset][first];
				matrix[last - offset][first] = matrix[last][last - offset];
				matrix[last][last - offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		return true;

	}

	public void rotateMatrix(int[][] matrix) {
		int temp = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix.length; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			int start = 0;
			int end = matrix.length - 1;
			while (start < end) {
				temp = matrix[i][start];
				matrix[i][start] = matrix[i][end];
				matrix[i][end] = temp;
				start++;
				end--;
			}
		}
	}

	public boolean findRotation(int[][] mat, int[][] target) {
		int n = mat.length;
		for (int r = 0; r < 4; r++) {
			int[][] temp = new int[n][n];

			for (int i = 0; i < mat.length; i++) {
				for (int j = 1 + 1; j < mat.length; j++) {
					temp[i][n - j - 1] = mat[i][j];
				}
			}
			if (Arrays.deepEquals(target, temp)) {
				return true;
			}

			mat = temp;
		}
		return false;
	}

	public int search(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		System.out.println(map);

		for (int num : nums) {
			if (map.get(num) > nums.length / 2) {
				return num;
			}
		}

		return -1;
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		if (m == 1 && n == 0) {
			return;
		}

		if (m == 0 && n == 1) {
			nums1[0] = nums2[0];
			return;
		}

		int i = 0;
		int j = 0;
		int k = 0;
		int[] res = new int[m + n];

		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				res[k++] = nums1[i];
				i++;
			} else {
				res[k++] = nums2[j];
				j++;
			}
		}
		while (i < m) {
			res[k++] = nums1[i++];
		}

		while (j < n) {
			res[k++] = nums2[j++];
		}

		int l = 0;

		for (int num : res) {
			nums1[l] = num;
			l++;
		}

	}

	public int[] sortedSquares(int[] nums) {
		int[] res = new int[nums.length];
		int i = 0;

		for (int num : nums) {
			res[i] = num * num;
			i++;
		}

		Arrays.sort(res);
		return res;
	}

}