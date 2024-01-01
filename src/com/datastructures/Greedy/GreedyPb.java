package com.datastructures.Greedy;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 31/12/23
 */
public class GreedyPb {
	public boolean canJump(int[] nums) {
		int furthest = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i > furthest) {
				return false;
			}

			furthest = Math.max(furthest, (nums[i] + i));

			if (furthest >= nums.length) {
				return true;
			}

		}
		return false;
	}
}
