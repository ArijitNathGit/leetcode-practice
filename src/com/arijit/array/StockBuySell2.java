package com.arijit.array;
/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/ */

public class StockBuySell2 {
    public static void main(String[] args) {
        System.out.println(new StockBuySell2Impl().find(new int[] {7,1,5,3,6,4}));
        System.out.println(new StockBuySell2Impl().find(new int[] {7,6,4,3,1}));

        System.out.println(new StockBuySell2Impl().find_simple(new int[] {7,1,5,3,6,4}));
        System.out.println(new StockBuySell2Impl().find_simple(new int[] {7,6,4,3,1}));
    }
}

class StockBuySell2Impl {
    public int find(int[] arr) {
        int minBuy = arr[0], maxProfit = 0, totalProfit = 0;

        for(int i = 1; i < arr.length; i++) {
            minBuy = Math.min(minBuy, arr[i]);
            if( (arr[i] - minBuy) < maxProfit ) {
                minBuy = arr[i];
                totalProfit += maxProfit;
                maxProfit = 0;
            }
            maxProfit = Math.max(maxProfit, arr[i] - minBuy);
        }

        totalProfit += maxProfit;

        return totalProfit;
    }

    public int find_simple(int[] arr) {
        int maxProfit = 0;

        for(int i = 1 ; i < arr.length; i++) {
            if( arr[i] > arr[i-1] ) maxProfit += arr[i] - arr[i-1];
        }

        return maxProfit;
    }
}