package com.arijit.array;

/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/ */

/**
 * Solution Approach:
 * 
 * 1. The main is we have to find the minimum price at any particular day and after that, find the max price  and calculate the difference.
 * 2. for that we are checking if the price[i] is < minBuy, thus storing the minimum price.
 * 3. If the price is not minimum, then we are checking if the price[i] - minBuy is greater than any previous maxProfit value we already stored. 
 *  
 * */

public class BuySellStock {

	public static void main(String[] args) {
		BuySellStockImpl obj = new BuySellStockImpl();
		System.out.println(obj.maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(obj.maxProfit(new int[] {7,6,4,3,1}));
	}
}

class BuySellStockImpl {
	public int maxProfit(int[] prices) {
		int minBuy = prices[0];
		int maxProfit = 0;
		
		for(int i = 1; i < prices.length; i++) {
			if( minBuy > prices[i] ) {
				minBuy = prices[i];
			}
			else {
				maxProfit = Math.max(maxProfit, prices[i] - minBuy);
			}
		}
		
		return maxProfit;
	}
}
