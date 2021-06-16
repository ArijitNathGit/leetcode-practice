package com.arijit.array;

import java.util.Arrays;

/* https://leetcode.com/problems/product-of-array-except-self/ */

/**
 * The problem states two criteria:
 * 1. Has to be in O(1) space complexity ( the answer array does not count as extra space )
 * 2. Cannot use division operation
 * 
 * Solution 1:
 * 
 * Like trapping Rain water problem, we will take two arrays, L and R. 
 * Then we will calculate the product of the elements left and right of the ith index respectively into the arrays
 * 
 * Once done, the answer of ith index = L[i] * R[i]
 * 
 * Drawback of Solution 1: We need to use O(n) space complexity
 * 
 * Solution 2:
 * 
 * It is similar to solution 1 but we will not be using the L and R arrays
 * Instead, we will be computing the left array in the asnwer array and compute the right array on the fly .
 * 
 * */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		ProductOfArrayExceptSelfImpl obj = new ProductOfArrayExceptSelfImpl();
		System.out.println(Arrays.toString(obj.solution1(new int[]{1,2,3,4})));
		System.out.println(Arrays.toString(obj.solution1(new int[]{-1,1,0,-3,3})));
		System.out.println();
		System.out.println(Arrays.toString(obj.solution2(new int[]{1,2,3,4})));
		System.out.println(Arrays.toString(obj.solution2(new int[]{-1,1,0,-3,3})));
	}
}

class ProductOfArrayExceptSelfImpl {
	
	/* Solution 1 */	
	public int[] solution1(int[] nums) {
		int len = nums.length;
        
        int[] L = new int[len];
        int[] R = new int[len];
        
        int[] answer = new int[len];
        
        L[0] = 1;
        R[len - 1] = 1;
        
        for(int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        
        for(int i = len - 2; i >=0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        
        for(int i = 0; i <len; i++) {
            answer[i] = L[i] * R[i];
        }
        
        return answer;
	}
	
	/* Solution2 */	
	public int[] solution2(int[] nums) {
		int len = nums.length;
        int R = 1;
        
        int[] answer = new int[len];
        
        answer[0] = 1;
        
        for(int i = 1; i < len; i++) {
        	answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        for(int i = len - 1; i >= 0; i--) {
            answer[i] = answer[i] * R;
            R = R * nums[i];
        }
        
        return answer;
	}
}
