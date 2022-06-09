package com.datastructures.june.misc;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 09/06/22
 */
public class ConsecOnes {
	public static int findMaxConsecutiveOnes(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}

		int c = 0;

		int res = 0;

		for (int num : nums) {
			if (num == 1) {
				c++;
			} else {
				c = 0;
			}

			res = Math.max(c, res);
		}

		return res;
	}
}