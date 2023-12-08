package com.datastructures.months2022.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 20/03/23
 */
public class SubArray {
	public static void main(String[] args) {
		char[] a = new char[] { 'a', 'b', 'c', 'x' };
		char[] b = new char[] { 'z', 'y', 'a' };
		//System.out.println(conatinsCommonItems(a,b));

		int[] a1 = new int[] { 1, 3, 4, 5 };
		int[] b1 = new int[] { 2, 4, 6, 8 };

		//System.out.println(MissingNumber(new int[]{2}, 1));

		//moveZeroesff(new int[]{0,1,2,1,2,0});

		//findLongestConseqSubseq(new int[] { 1, 9, 3, 10, 4, 20, 2 }, 7);
		//isSubset(new long[]{11, 1, 13, 21, 3, 7, 11},new long[]{11, 3, 7, 1}, 7, 4);

		//sortA1ByA2(new int[] {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}, 11, new int[] {2,1,8,3}, 4);

//		countDistinct(new int[] {1,2,1,3,4,2,3}, 7, 4);

		//mergeSortedArray(a1, b1);
		//System.out.println(recurringNumber(new int[]{2,5,1}));
		// rearrange(new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}, 10);

	//	findTwoElement(new int[]{1, 3, 3}, 3);

	//	removeDuplicates("geeks");
	//	sumOfUnique(new int[]{1,2,3,2});
	//	countConsistentStrings("ab", new String[]{"ad","bd","aaab","baa","badab"});

	}

//	public static int countKDifference(int[] nums, int k) {
//		int count = 0;
//		for(int i = 0 ; i < nums.length; i++){
//			for (int j = i+1; j<nums.length; j++){
//				if(Math.abs(nums[i] - a=nums[j]) == k){
//					count ++;
//				}
//			}
//		}
//		return count;
//	}

	public static int sumOfUnique(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> distinctNums = new ArrayList<>();

		for (int num : nums) {
			if (!set.contains(num)) {
				distinctNums.add(num);
			}
		}
		int sum =0;

		for(int num : distinctNums){
			sum += num;
		}

		return sum;
		//		HashMap<Integer, Integer> hashMap = new HashMap<>();
//
//		for (int num : nums) {
//			hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
//		}
//
//		List<Integer> keysToRemove = new ArrayList<>();
//
//		for (int num : hashMap.keySet()) {
//			if (hashMap.get(num) != 1) {
//				keysToRemove.add(num);
//			}
//		}
//
//		for (int num : keysToRemove) {
//			hashMap.remove(num);
//		}
//
//		int sum = 0;
//		for(int num : hashMap.keySet()){
//			sum += num;
//		}
//		System.out.println(sum);
//		return sum; "/Users/pulkit.aggarwal/Desktop/Upgrad/lead_management_service/src/main/resources/dir/";
	}

	public static int countConsistentStrings(String allowed, String[] words) {
		HashSet<Character> allowedChars = new HashSet<>();
		for (char ch : allowed.toCharArray()) {
			allowedChars.add(ch);
		}

		int count = 0;
		for (String word : words) {
			boolean consistent = true;
			for (char ch : word.toCharArray()) {
				if (!allowedChars.contains(ch)) {
					consistent = false;
					break;
				}
			}
			if (consistent) {
				count++;
			}
		}

		return count;
	}



	static String removeDuplicates(String str) {
		// code
		Object[] a= new Object[str.length()];
		int j = 0;
		for(int i = 0; i < str.length() ; i++){
			a[j]= str.charAt(i);
			j++;
		}

		Object[] res = Arrays.stream(a).distinct().toArray();
		return Arrays.toString(res).replaceAll("[^A-Za-z0-9]", "");
	}

	static int[] findTwoElement(int arr[], int n) {
		// code here
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int[] ans = new int[2];
		int dup = -1;

		for(int num : arr){
			if(hashMap.containsKey(num)){
				dup = num;
			}else {
				hashMap.put(num, 1);
			}
		}

		ans[0] = dup;

		for(int i = 1 ; i<= arr.length; i++){
			if(!hashMap.containsKey(i)){
				ans[1] = i;
				break;
			}
		}
		System.out.println(Arrays.toString(ans));
		return ans;
	}

	static void rearrange(int arr[], int n) {
		// code here
		int[] pos = Arrays.stream(arr).filter(value -> value >= 0).toArray();
		int[] neg = Arrays.stream(arr).filter(value -> value < 0).toArray();

		int i = 0 ,j = 0, k = 0;

		while (i < pos.length && j < neg.length) {
			if (k%2==0) {
				arr[k++] = pos[i++];
			} else {
				arr[k++] = neg[j++];
			}
		}

		while (i < pos.length) {
			arr[k++] = pos[i++];
		}

		while (j < neg.length) {
			arr[k++] = neg[j++];
		}

		System.out.println(Arrays.toString(arr));
	}

	public static boolean conatinsCommonItems(char[] a, char[] b) {

		HashSet<Character> hashSet = new HashSet<>();

		for (char j : a) {
			hashSet.add(j);
		}

		for (char i : b) {
			if (hashSet.contains(i)) {
				return true;
			}
		}

		return false;

	}

	public static void mergeSortedArray(int[] a, int[] b) {
		// navie approach
		//		int[] c = new int[a.length + b.length];
		//		for (int i =0 ; i<a.length ; i++){
		//			c[i] = a[i];
		//		}
		//
		//		System.out.println(Arrays.toString(c));
		//
		//		int k = a.length;
		//
		//		for (int j=0 ; j<b.length ; j++){
		//			c[k] = b[j];
		//			k++;
		//		}
		//
		//		Arrays.sort(c);

		// Insertion Sort
		int i = 0, j = 0, k = 0;
		int[] c = new int[a.length + b.length];

		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}

		while (i < a.length) {
			c[k++] = a[i++];
		}

		while (j < b.length) {
			c[k++] = b[j++];
		}

		System.out.println(Arrays.toString(c));
	}

	public static void arraysEqual(int[] a, int[] b) {
		if (a.length != b.length) {
			System.out.println(0);
		}

		Arrays.sort(a);
		Arrays.sort(b);

		if (Arrays.equals(a, b)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static void binarySearch(int[] a, int n, int k) {
		int res = Arrays.binarySearch(a, k);
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		int[] res = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = i;
				res[i] = map.get(target - nums[i]);
			}
			map.put(nums[i], i);
		}

		return res;
	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int num : nums) {
			if (hashSet.contains(num)) {
				return false;
			}
			hashSet.add(num);
		}
		return true;
	}

	public void moveZeroes(int[] nums) {
		int lastNo = 0;

		for (int num : nums) {
			if (num != 0) {
				nums[lastNo++] = num;
			}
		}

		for (int i = lastNo; i < nums.length; i++) {
			nums[lastNo++] = 0;
		}
	}

	public static void moveZeroesff(int[] nums) {
		int lastNo = 0;
		int k = nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int temp = nums[lastNo++];
				nums[lastNo++] = nums[k];
				nums[lastNo++] = 0;
				nums[k] = temp;
			}
			k--;
		}

		for (int i = lastNo; i < nums.length; i++) {
			if (nums[i] == 1) {
				nums[lastNo++] = 1;
			}
		}

		for (int i = lastNo; i < nums.length; i++) {
			if (nums[i] == 2) {
				nums[lastNo++] = 2;
			}
		}
	}

	public void rotate(int arr[], int n)
	{
		int temp = arr[0];
		arr[0] = arr[n-1];
		for(int i =1 ; i<arr.length ; i++){
			int t1 = arr[i];
			arr[i]= temp;
			temp  = t1;
		}
	}
//
//	ArrayList<Long> find(long arr[], int n, int x)
//	{
//		// code here
//		long firstOccur = Arrays.binarySearch(arr, x);
//
//		for (int i = 0; i < n / 2; i++) {
//			arr[i] = arr[n - i - 1];
//			arr[n - i - 1] = t;
//		}
//
//		long lastOccur = n - Arrays.binarySearch(arr, x);
//		ArrayList<Long> a = new ArrayList<>();
//		a.add(firstOccur);
//		a.add(lastOccur);
//
//		return a;
//	}

	long maxSum(long arr[] ,int n)
	{
		Arrays.sort(arr);
		long[] r = new long[n];
		int l = 0 ;
		int righ  = n-1;
		for (int i = 0;  i<n; i++){
			if(i % 2 == 0){
				r[i] = arr[l++];
			}else {
				r[i] = arr[righ --];
			}
		}

		long sum  = 0;

		for(int i=0; i<n; i++){
			int j = (i+1) % n;
			sum += Math.abs(r[i]  - r[j]);
		}

		return sum;

	}

	long findMinSum(int[] A,int[] B,int N) {
		Arrays.sort(A);
		Arrays.sort(B);

		long diff  = 0;

		for(int i =0 ; i<A.length; i++){
			diff += Math.abs(A[i] - B[i]);
		}
		return diff;
	}

	public static int recurringNumber(int[] nums) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int num : nums) {
			if (hashSet.contains(num)) {
				return num;
			}
			hashSet.add(num);
		}

		return -1;
	}

	static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
		// code here
		for (int i = 0; i < n; i += k) {
			if (i + k < n) {
				reverse(arr, i, i + k - 1);
			} else {
				reverse(arr, i, n - 1);
			}
		}
	}

	static void reverse(ArrayList<Integer> arr, int start, int end) {
		while (start < end) {
			Collections.swap(arr, start, end);
			start++;
			end--;
		}
	}

	public static int firstElementKTime(int[] a, int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : a) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}

			if (map.get(num) == k) {
				return num;
			}
		}
		return -1;
	}

	static void zigZag(int arr[], int n) {
		// code here
		int temp = 0;
		for (int i = 1; i < n; i += 2) {
			if (arr[i - 1] > arr[i]) {
				temp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = temp;
			}
			if (i + 1 < n && arr[i + 1] > arr[i]) {
				temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
	}

	static int MissingNumber(int array[], int n) {
		if (array.length == 1) {
			return array[0] - 1;
		}
		// Your Code Here
		Arrays.sort(array);
		// Your Code Here
		for (int i = 0; i < array.length; i++) {
			if (i != array[i] - 1) {
				return array[i] - 1;
			}
		}
		return -1;
	}

	static ArrayList<Integer> leaders(int arr[], int n) {
		// Your code here;
		Stack<Integer> s = new Stack<>();
		s.add(arr[arr.length - 1]);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > s.peek()) {
				s.add(arr[i]);
			}
		}
		ArrayList<Integer> arrayList = new ArrayList<>(s.size());
		arrayList.addAll(s);
		Collections.reverse(arrayList);
		return arrayList;
	}

	public long minValue(long a[], long b[], long n) {
		// Your code goes here
		Arrays.sort(a);
		Arrays.sort(b);

		long sum = 0;

		long j = n - 1;

		for (long i = 0; i < n; i++) {
			sum += a[(int) i] * b[(int) j];
			j--;
		}
		return sum;
	}

	long maxSubarraySum(int arr[], int n) {

		// Your code here
		long currSum = 0;

		long res = Integer.MIN_VALUE;

		for (int num : arr) {
			currSum += num;
			if (currSum < 0) {
				currSum = 0;
			}
			res = Math.max(res, currSum);
		}
		return res;
	}

	public static int kthSmallest(int[] arr, int l, int r, int k) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for (int num : arr) {
			priorityQueue.add(num);
		}

		while (k != 1) {
			priorityQueue.remove();
			k--;
		}

		return priorityQueue.peek();
	}

	public static int equilibriumPoint(long arr[], int n) {

		// Your code here
		long sum = 0;
		long rsum = 0;
		int i = 0;
		for (long num : arr) {
			sum += num;
		}

		for (long num : arr) {
			sum -= num;
			if (rsum == sum) {
				return i + 1;
			}
			rsum += num;
			i++;
		}
		return -1;
	}

	static int findLongestConseqSubseq(int arr[], int N) {
		// add your code here
		if (N == 1) {
			return 1;
		}

		int[] a2 = new int[] { 34 ,2, 7, 23, 31, 38, 13, 11, 37, 19, 45, 6 };
		int max = Integer.MIN_VALUE;

		HashSet<Integer> hashSet = new HashSet<>();

		for (int num : a2) {
			hashSet.add(num);
		}

		for (int i=0; i<hashSet.size(); i++) {
			if (!hashSet.contains(a2[i]- 1)) {
				int c = 1;
				while (hashSet.contains(a2[i] + c)) {
					c++;
				}
				max = Math.max(max, c);
			}
		}
		return max;
	}

	public static String isSubset( long a1[], long a2[], long n, long m) {
		HashMap<Long, Integer> hashMap = new HashMap<>();
		for(long num : a1){
			if(hashMap.containsKey(num)){
				hashMap.put(num,hashMap.get(num)+1);
			}else{
				hashMap.put(num, 1);
			}

		}
		HashMap<Long, Integer> hashMap2 = new HashMap<>();
		for(long num : a2){
			if(hashMap2.containsKey(num)){
				hashMap2.put(num,hashMap2.get(num)+1);
			}else{
				hashMap2.put(num, 1);
			}

		}
		int c = 0;
		for(long num : a2){
			if(!hashMap.containsKey(num)){
				return "No";
			}else {
				if(!Objects.equals(hashMap.get(num), hashMap2.get(num))){
					return "No";
				}
			}
			return "Yes";
		}

		System.out.println(hashMap);

//		for(long num : a2){
//			if(!hashSet.contains(num)){
//				return "No";
//			}
//		}
		return "Yes";
	}

	String printLargest(String[] arr) {
		// code here
		Arrays.sort(arr, (x,y) -> (y+x).compareTo(x+y));

		return Arrays.toString(arr).replaceAll("[^A-Za-z0-9]", "");
	}

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
	{
		// Your code here
		ArrayList<Integer> arrayList = new ArrayList<>();

		int start = 0;
		int end = 0;
		int currSum = arr[0];

		while (end < n){
			if(currSum < s){
				end += 1;
				currSum += arr[end];
			}else if(currSum > s){
				currSum -= arr[start];
				start += 1;
			}else {
				arrayList.add(start + 1);
				arrayList.add(end + 1);
				return arrayList;
			}
		}
		arrayList.add(-1);
		return arrayList;
	}

	public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
	{
		//Your code here
		Map<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[N];

		for (int num : A1) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int i = 0;

		for(int num : A2) {
			if (map.containsKey(num)) {
				if(map.get(num) > 1){
					while (map.get(num) != 0) {
						ans[i] = num;
						i++;
						map.put(num, map.get(num) - 1);
					}
				}else{
					ans[i] = num;
					i++;
					map.put(num, map.get(num) - 1);
				}

			}
		}

			Arrays.sort(A1);

			for(int k=0 ; k<N; k++){
				if(map.get(A1[k]) != 0){
					ans[i] = A1[k];
					i++;
				}
			}
		return ans;
	}

	static ArrayList<Integer> countDistinct(int arr[], int n, int k)
	{
		// code here
		// brutte force
		/*
		ArrayList<Integer> arrayList = new ArrayList<>();
		HashSet<Integer> hashSet = new HashSet<>();


		for(int j=0; j <= n-k ; j++){
			int  c = 0;
			for(int i = j ; i < j+k ; i++){
				if(!hashSet.contains(A[i])){
					hashSet.add(A[i]);
					c++;
				}
			}
			arrayList.add(c);
			hashSet.clear();
		}
		return arrayList; */

		ArrayList<Integer> arrayList = new ArrayList<>();
		HashMap<Integer, Integer> countMap = new HashMap<>();
		int distinctCount = 0;

		for(int i =0 ; i<k ; i++){
			countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
			if(countMap.get(arr[i]) == 1){
				distinctCount++;
			}
		}
		arrayList.add(distinctCount);

		for(int i = k ; i< n ; i++){
			int incomingEle = arr[i];
			int outgoingEle = arr[i-k];

			countMap.put(outgoingEle, countMap.get(outgoingEle) - 1);
			if(countMap.get(outgoingEle) == 0){
				countMap.remove(outgoingEle);
				distinctCount--;
			}


			countMap.put(incomingEle, countMap.getOrDefault(incomingEle, 0) + 1);
			if(countMap.get(incomingEle) == 1){
				distinctCount++;
			}
			arrayList.add(distinctCount);
		}

		return arrayList;
	}

}

