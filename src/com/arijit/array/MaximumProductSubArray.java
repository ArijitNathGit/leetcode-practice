package com.arijit.array;

/* https://leetcode.com/problems/maximum-product-subarray/ */

public class MaximumProductSubArray {

	public static void main(String[] args) {
		MaximumProductSubArrayImpl obj = new MaximumProductSubArrayImpl();
		System.out.println(obj.find(new int[] {2,-5,3,1,-4,0,-10,2,8}));
		System.out.println(obj.find(new int[] {2,3,-2,4}));
		System.out.println(obj.find(new int[] {-2,0,-1}));
	}
}

class MaximumProductSubArrayImpl {
	public int find(int[] nums) {
		int maxProduct = nums[0], minProduct = nums[0], maxStore = maxProduct;
		
		for(int i = 1; i < nums.length; i++) {
			if( nums[i] < 0 ) {
				int temp = maxProduct;
				maxProduct = minProduct;
				minProduct = temp;
			}
			
			maxProduct = Math.max(nums[i], maxProduct * nums[i]);
			minProduct = Math.min(nums[i], minProduct * nums[i]);
			
			maxStore = Math.max(maxProduct, maxStore);
		}
		
		return maxStore;
	}
}
