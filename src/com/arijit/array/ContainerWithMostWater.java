package com.arijit.array;

/* https://leetcode.com/problems/container-with-most-water/ */

/**
 * Solution:
 * 
 * 1. Between any two points, the amount of water that can be conatined is equal to the (minimum of the two tower * space between the two tower) 
 * 2. Keep the maximum water stored at any point in a variable 
 * 3. Always stick to the maximum tower at any end and navigate from the other end containing min towers
 * 
 * */

public class ContainerWithMostWater {

	public static void main(String[] args) {
		ContainerWithMostWaterImpl obj = new ContainerWithMostWaterImpl();
		System.out.println(obj.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}

}

class ContainerWithMostWaterImpl {
	public int maxArea(int[] height) {
		int size = height.length;
		
		int minTower = 0, left = 0, right = size - 1;
		int waterStored = 0;
		
		while( left < right ) {
			minTower = Math.min(height[left], height[right]);
			waterStored = Math.max(waterStored, (right - left) * minTower);
			
			if(height[left] >= height[right]) right--;
			else left++;
		}
		
		return waterStored;
	}
}
