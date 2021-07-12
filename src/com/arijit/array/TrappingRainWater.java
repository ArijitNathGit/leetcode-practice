package com.arijit.array;

/* https://leetcode.com/problems/trapping-rain-water/ */

/**
 * Solution:
 * 
 * For any building i, the max water trapped will be lower of the max height either on the left or the right minus the height of the building itself
 * Thus, at first we have to compute for every building, what the left max and the right max building 
 * Then we have to compute Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i] as the water stored on top of every building.
 * 
 * */

public class TrappingRainWater {
	public static void main(String[] args) {
		TrappingRainWaterImpl obj = new TrappingRainWaterImpl();
		System.out.println(obj.find(new int[] {1,1,0,2,1,0,1,3,2,1,2,1}));
	}
}

class TrappingRainWaterImpl {
	public int find(int[] height) {
		int size = height.length;
		
		int[] leftMaxArr = new int[size];
		int[] rightMaxArr = new int[size];
		
		int leftMax = 0, rightMax = 0, waterStored = 0;
		
		for(int i = 0; i < size; i++) {
			if( height[i] > leftMax ) {
				leftMax = height[i];
			}
			
			leftMaxArr[i] = leftMax;
		}
		
		for(int i = size - 1; i >= 0; i--) {
			if( height[i] > rightMax ) {
				rightMax = height[i];
			}
			
			rightMaxArr[i] = rightMax;
		}
		
		for(int i = 0; i < size; i++) {
			waterStored += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
		}
		
		return waterStored;
	}
}
