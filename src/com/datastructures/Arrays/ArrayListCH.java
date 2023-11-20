package com.datastructures.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 13/11/23
 */
public class ArrayListCH {
	public static void main(String[] args) {
		//		ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		//		numberList.add(7);
		//
		//		int i = 0;
		//		while (numberList.iterator().hasNext()){
		//			if(numberList.get(i) == 5){
		//				System.out.println("Number has found");
		//			}
		//			numberList.iterator().next();
		//			i++;
		//		}

		int[] nums = new int[] {1,0,1,1,1};
		//		System.out.println(maxSum(nums));
	//	System.out.println(removeDuplicates(nums));
	//	System.out.println(Arrays.toString(applyOperations(nums)));
		System.out.println(search(nums, 0));
	}

	public static int maxSum(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int i = 0;
		int max = -1;
		for (int num : nums) {
			if (map.containsKey(reverse(num))) {
				max = Math.max(max, num + reverse(num));
			}

			map.put(num, i);
			i++;
		}

		return max;
	}

	public static int reverse(int num) {
		String numStr = Integer.toString(num);

		String reversedStr = new StringBuilder(numStr).reverse().toString();

		return Integer.parseInt(reversedStr);
	}

	public static int removeDuplicates(int[] nums) {

		int slow = 1;

		for (int fast = 1; fast < nums.length; fast++) {
			if (nums[fast] != nums[fast - 1]) {
				nums[slow++] = nums[fast];
			}
		}

		return slow + 1;

	}

	public static int removeDuplicatesTwice(int[] nums) {

		int n = nums.length;
		if (n <= 2) {
			return n;
		}

		int slow = 2;

		for (int fast = 2; fast < n; fast++) {
			if (nums[fast] != nums[slow - 2]) {
				nums[slow++] = nums[fast];
			}

		}

		return slow;

	}


	public static int[] applyOperations(int[] nums) {

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				nums[i - 1] = nums[i - 1] * 2;
				nums[i] = 0;
			}
		}

		int nonZeroIndexed = 0;

		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0 ){
				nums[nonZeroIndexed++]= nums[i];
			}
		}

		for(int i = nonZeroIndexed ; i <nums.length; i++){
			nums[i] = 0;
		}

		return nums;
	}

	public static int removeElement(int[] nums, int val) {
		int valIndexed = 0;
		int count = 0;

		for(int i = 0; i < nums.length; i++){
			if(nums[i] != val ){
				nums[valIndexed++]= nums[i];
				count++;
			}
		}

		for(int i = valIndexed ; i <nums.length; i++){
			nums[i] = val;
		}

		return count;
	}

	public static boolean search(int[] nums, int target) {
		Arrays.sort(nums);
		int val  = Arrays.binarySearch(nums, target);
		System.out.println(val);
		return val >= 0;
	}

}
