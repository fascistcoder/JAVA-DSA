package com.datastructures.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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

		int[] nums1 = new int[] {};
		int[] nums2 = new int[] { 2 };
		//new ArrayCodingExercise().findMedianSortedArrays(nums1, nums2);
		//System.out.println(numMatchingSubseq("abcde", new String[] { "a", "bb", "acd", "ace" }));
		//		canConstruct("aa", "ab");
		//		System.out.println(makeEqual(new String[] { "a", "b" }));
		System.out.println(findLHS(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 }));
	}

	public static int findLHS(int[] nums) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int num : nums) {
			hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
		}

		int res = 0;

		for (int num : nums) {
			int l = 0;
			if (hashMap.containsKey(num + 1)) {
				l += hashMap.get(num) + hashMap.get(num + 1);
			}
			res = Math.max(res, l);
		}

		return res;
	}

	public static boolean makeEqual(String[] words) {
		HashMap<Character, Integer> hashMap = new HashMap<>();

		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				hashMap.put(word.charAt(i), hashMap.getOrDefault(word.charAt(i), 0) + 1);
			}
		}

		int l = words.length;

		for (int length : hashMap.values()) {
			if (length % l != 0) {
				return false;
			}
		}

		return true;

	}

	public static boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : magazine.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (char c : ransomNote.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.getOrDefault(c, 0) - 1);
				if (map.get(c) < -1) {
					return false;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	public int[] twoSumD(int[] numbers, int target) {
		int[] disArray = Arrays.stream(numbers).distinct().toArray();
		int[] res = new int[2];

		int i = 0;
		int j = disArray.length - 1;

		while (i < j) {
			int sum = numbers[i] + numbers[j];

			if (sum == target) {
				res[0] = i + 1;
				res[1] = j + 1;
				return res;
			} else if (sum < 0) {
				i++;
			} else {
				j--;
			}
		}
		return res;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 1; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					while (j < k && nums[j] == nums[j + 1]) {
						j++;
					}
					while (j < k && nums[k] == nums[k - 1]) {
						k--;
					}
					j++;
					k--;
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
			res.add(list);
		}
		return res;
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

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] median = merge(nums1, nums1.length, nums2, nums2.length);
		double ans = 0;

		if (median == null) {
			return 0.0;
		}

		if (median.length % 2 != 0) {
			ans = (double) median[median.length / 2];
		} else {
			int ele1 = (median.length) / 2;
			int ele2 = (median.length) / 2 - 1;
			ans = (double) (median[ele1] + median[ele2]) / 2;
		}
		return ans;
	}

	public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

		if (m == 1 && n == 0) {
			return nums1;
		}

		if (m == 0 && n == 1) {
			return nums2;
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

		return res;
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

	public static int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];

		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		slow = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return slow;
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		for (int num : nums) {
			priorityQueue.add(num);
		}

		System.out.println(priorityQueue);

		int ele = 0;
		int l = priorityQueue.size() - k + 1;

		while (l != 0) {
			ele = priorityQueue.poll();
			l--;
		}

		System.out.println(ele);

		return 1;
	}

	public static int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] res = new int[k];

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		maxHeap.addAll(map.entrySet());

		for (int i = 0; i < k; i++) {
			res[i] = maxHeap.remove().getKey();
		}

		System.out.println(Arrays.toString(res));
		return res;
	}

	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		maxHeap.addAll(map.entrySet());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < map.size(); i++) {
			int val = maxHeap.peek().getValue();
			while (val != 0) {
				sb.append(maxHeap.peek().getKey());
				val--;
			}
			maxHeap.remove();
		}

		return sb.toString();

	}

	public static int percentageLetter(String s, char letter) {
		Map<Character, Double> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0.0) + 1);
		}

		if (map.containsKey(letter)) {
			double val = map.get(letter);
			double per = val / s.length();
			return (int) ((val / s.length()) * 100);
		} else {
			return 0;
		}
	}

	public static int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		HashSet<Integer> hashSet = new HashSet<>();

		for (int num : nums) {
			hashSet.add(num);
		}

		System.out.println(hashSet);

		int lenght = 1;
		int res = Integer.MIN_VALUE;

		for (int num : nums) {
			if (!hashSet.contains(num - 1)) {
				int currSum = num;
				while (hashSet.contains(currSum + 1)) {
					currSum++;
					lenght++;
				}
				res = Math.max(res, lenght);
				lenght = 1;
			}
		}

		System.out.println(lenght);
		System.out.println(res);

		return res;
	}

	public static int countZeroes(int[] array) {
		//   TODO
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : array) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		return map.get(0);
	}

	public static int findRotatedIndex(int[] arr, int num) {
		int left = 0;
		int right = arr.length - 1;
		int middle = 0;
		if (right > 0 && arr[left] >= arr[right]) {
			middle = (int) Math.floor((left + right) / 2);
			while (arr[middle] <= arr[middle + 1]) {
				if (arr[left] <= arr[middle]) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
				middle = (int) Math.floor((left + right) / 2);
				if (middle + 1 > arr.length - 1) {
					break;
				}

			}
			if (num >= arr[0] && num <= arr[middle]) {
				left = 0;
				right = middle;
			} else {
				left = middle + 1;
				right = arr.length - 1;
			}

		}
		while (left <= right) {
			middle = (int) Math.floor((left + right) / 2);
			if (num == arr[middle]) {
				return middle;
			}
			if (num > arr[middle]) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		return -1;
	}

	public static boolean isSubsequence(String s, String t) {
		int sPointer = 0;
		int tPointer = 0;

		while (sPointer < s.length() && tPointer < t.length()) {
			if (s.charAt(sPointer) == t.charAt(tPointer)) {
				sPointer++;
			}
			tPointer++;
		}

		return sPointer == s.length();
	}

	public static int appendCharacters(String s, String t) {
		if (t.length() == 1 && s.contains(t)) {
			return 0;
		}

		int sPointer = 0;
		int tPointer = 0;
		int len = 0;

		while (sPointer < s.length() && tPointer < t.length()) {
			if (s.charAt(sPointer) == t.charAt(tPointer)) {
				sPointer++;
				tPointer++;
			} else {
				len = t.length() - tPointer;
				break;
			}
		}

		return len;
	}

	public static int numMatchingSubseq(String s, String[] words) {
		Map<String, Integer> hashMap = new HashMap<>();
		int count = 0;

		for (String word : words) {
			hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
		}

		System.out.println(hashMap);

		for (String word : hashMap.keySet()) {
			if (isSubsequence(word, s)) {
				count += hashMap.get(word);
			}
		}

		return count;
	}
}