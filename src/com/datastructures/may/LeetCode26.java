package com.datastructures.may;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 26/05/22
 */
public class LeetCode26 {
	public static int search(int[] nums, int target) {

		int left = 0;
		int right = nums.length - 1;
		int mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return -1;

	}

	//	public static int guessNumber(int n) {
	//
	//		int lessNo = 1;
	//		int greaterNo = n;
	//
	//		while (lessNo <= greaterNo) {
	//
	//			int midNo = lessNo + (greaterNo - lessNo)/2;
	//
	//			if (guess(midNo) == 0) {
	//				return midNo;
	//			} else if (guess(midNo) == -1) {
	//				greaterNo = midNo - 1;
	//			} else {
	//				lessNo = midNo + 1;
	//			}
	//		}
	//
	//		return -1;
	//	}

	public static int search1(int[] nums, int target) {

		// O(n)
		/* for(int i=0; i< nums.length; i++){
			if(nums[i] == target){
				return i;
			}
		}

		return -1; */

		// O(logn)

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[left] <= nums[mid]) {
				if (target <= nums[mid] && target >= nums[left]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}else {
				if (target >= nums[mid] && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;

	}

	public static void main(String[] args) {

		int[] a = new int[] {
				4,5,6,7,0,1,2
		};

		//System.out.println(search(a, 9));

		System.out.println(search1(a, 1));
	}

}
