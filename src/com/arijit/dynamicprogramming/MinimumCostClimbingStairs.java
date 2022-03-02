package com.arijit.dynamicprogramming;

/* https://leetcode.com/problems/min-cost-climbing-stairs/ */

public class MinimumCostClimbingStairs {

	public static void main(String[] args) {
		System.out.println(new MinimumCostClimbingStairsImpl().minCost(new int[] {10,15,20}));
		System.out.println(new MinimumCostClimbingStairsImpl().minCost(new int[] {1,100,1,1,1,100,1,1,100,1}));
	}

}

class MinimumCostClimbingStairsImpl {
	public int minCost(int[] costs) {
		int[] dp = new int[costs.length + 1];
		dp[0] = 0;
		dp[1] = 0;
		
		for(int i = 2; i < dp.length; i++) {
			dp[i] = Math.min(dp[i - 1] + costs[i - 1], dp[i - 2] + costs[i - 2]);
		}
		
		return dp[dp.length - 1];
	}
}
