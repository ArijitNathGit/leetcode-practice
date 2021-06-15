package com.arijit.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/two-sum/ */

/**
 * Solution Approach:
 * 
 * 1. Create an empty map<int, int> and a result array of size 2
 * 2. If two numbers add up to the target, that means target - nums[i] should be present in the map to get the pair of numbers
 * 3. Thus, we check if target-nums[i] is present in the map. If present, then we get the index in the map and the current index and return it.
 * 4. Else we add the value and index into the map.
 *  
 * */

public class TwoSum {

	public static void main(String[] args) {
		TwoSumImpl obj = new TwoSumImpl();
		System.out.println(Arrays.toString(obj.twoSum(new int[] {2,7,11,15}, 9)));
		System.out.println(Arrays.toString(obj.twoSum(new int[] {3,2,4}, 6)));
		System.out.println(Arrays.toString(obj.twoSum(new int[] {3,3}, 6)));
		System.out.println(Arrays.toString(obj.twoSum(new int[] {3,3}, 20)));
	}
}

class TwoSumImpl {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> data = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if( data.containsKey(target - nums[i]) ) {
				return new int[]{data.get(target - nums[i]), i};
			}
			else {
				data.put(nums[i], i);
			}
		}
		
		throw new IllegalArgumentException("No two number found to fit the target");
	}
}
