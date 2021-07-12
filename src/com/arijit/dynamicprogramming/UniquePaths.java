package com.arijit.dynamicprogramming;

import java.util.Arrays;

/* https://leetcode.com/problems/unique-paths/ */

public class UniquePaths {

	public static void main(String[] args) {
		System.out.println(new UniquePathsImpl().find(3, 7));
		System.out.println(new UniquePathsImpl().find(3, 3));
	}

}

class UniquePathsImpl {
	public int find(int m, int n) {
		if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        
		int [][] dp = new int[m][n];
		
		for(int i = 0; i < m ; i++) Arrays.fill(dp[i], 1);
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n ; j++ ) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[m - 1][n - 1];
	}
}
