package com.arijit.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class HousePainting {

	public static void main(String[] args) {
		System.out.println(new HousePaintingImpl().minCostMemo(new int[][] {{17,2,17},{16,16,5},{14,3,19}}));
		System.out.println(new HousePaintingImpl().minCostDP(new int[][] {{17,2,17},{16,16,5},{14,3,19}}));
	}

}

class HousePaintingImpl {
	private int[][] costs;
	private Map<String, Integer> memo;
	
	public int minCostMemo(int[][] cost) {
		if(cost.length == 0) return 0;
		
		this.costs = cost;
		memo = new HashMap<>();
		return Math.min(paintCost(0, 0), Math.min(paintCost(0, 1), paintCost(0, 2)));
	}

	private int paintCost(int n, int color) {
		String key = n + " " + color;
		if(memo.containsKey(key)) return memo.get(key);
		
		int totalCost = costs[n][color];
		
		if(n == costs.length - 1) {}
		
		else if(color == 0) totalCost += Math.min(paintCost(n + 1, 1), paintCost(n + 1, 2));
		else if(color == 1) totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 2));
		else if(color == 2) totalCost += Math.min(paintCost(n + 1, 0), paintCost(n + 1, 1));
		
		memo.put(key, totalCost);
		
		return totalCost;
	}
	
	public int minCostDP(int[][] cost) {
		if(cost.length == 0) return 0;
		
		
		for(int i = cost.length - 2; i >= 0; i--) {
			cost[i][0] += Math.min(cost[i + 1][1], cost[i + 1][2]);
			cost[i][1] += Math.min(cost[i + 1][0], cost[i + 1][2]);
			cost[i][2] += Math.min(cost[i + 1][1], cost[i + 1][1]);
		}
		
		return Math.min(cost[0][0], Math.min(cost[0][1], cost[0][2]));
	}
}
