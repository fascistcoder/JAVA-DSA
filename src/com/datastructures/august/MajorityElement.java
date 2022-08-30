package com.datastructures.august;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 01/08/22
 */
public class MajorityElement {
	static int majorityElement(int[] nums, int size)
	{
		// your code here

		Map<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (Map.Entry<Integer, Integer>entry: map.entrySet()){
			if(entry.getValue() > size/2){
				return entry.getKey();
			}
		}
		return  -1;
	}
}
