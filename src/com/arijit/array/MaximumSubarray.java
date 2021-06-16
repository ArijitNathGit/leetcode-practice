package com.arijit.array;

/* https://leetcode.com/problems/maximum-subarray/ */
/* Also known as Kadane's Algorithm */

/**
 * Solution:
 * 
 * For this problem, we need to consider two situations:
 * 1. we need to store the maximum sum till any location in a variable and that value has to be returned at the end
 * 2. In an array having [-1 -2 -3 -4] the answer is -1. This means that, we we have negative numbers, if highest of the negatives will be considered. 
 * 	  In case, negative and positive are mixed, we will never consider the sum to be less that 0. If true, we will change it back to 0.	
 * 
 * */

public class MaximumSubarray {

	public static void main(String[] args) {
		MaximumSubarrayImpl obj = new MaximumSubarrayImpl();
		
		System.out.println(obj.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(obj.maxSubArray(new int[] {1}));
		System.out.println(obj.maxSubArray(new int[] {5,4,-1,7,8}));
	}
}

class MaximumSubarrayImpl {
	public int maxSubArray(int[] nums) {
		int max_store = Integer.MIN_VALUE, max_sum = 0;
		
		for(int num : nums) {
			max_sum += num;
			
			if( max_sum > max_store ) {
				max_store = max_sum;
			}
			
			if( max_sum < 0 )
				max_sum = 0;
		}
		
		return max_store;
	}
}
