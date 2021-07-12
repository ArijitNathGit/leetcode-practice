package com.arijit.dynamicprogramming;

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
		System.out.println(new TrappingRainWaterImpl().trap(new int[] {1,1,0,2,1,0,1,3,2,1,2,1}));
	}

}

class TrappingRainWaterImpl {
	
	public int trap(int[] maxWater) {
		int len = maxWater.length;
		int[] leftMaxArr = new int[len];
		int[] rightMaxArr = new int[len];
		int leftMaxIndex = 0, rightMaxIndex = 0, maxWaterStored = 0;
		
		for(int i = 0 ; i < len; i++) {
			if( maxWater[i] > leftMaxIndex ) leftMaxIndex = maxWater[i];			
			leftMaxArr[i] = leftMaxIndex;
		}
		
		for(int i = len - 1; i >= 0; i--) {
			if( maxWater[i] >= rightMaxIndex ) rightMaxIndex = maxWater[i];
			rightMaxArr[i] = rightMaxIndex;
		}
		
		for(int i = 1; i < len -1; i++) {
			maxWaterStored += Math.min(leftMaxArr[i], rightMaxArr[i]) - maxWater[i];
		}
		
		return maxWaterStored;
	}
	
}
