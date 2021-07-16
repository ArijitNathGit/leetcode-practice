package com.arijit.dynamicprogramming;

import java.util.HashMap;

public class GridTraveller {

	public static void main(String[] args) {
		System.out.println(new GridTravellerImpl().travel(18, 18));
	}

}

class GridTravellerImpl {
	public long travel(int m, int n) {
		return travel(m, n, new HashMap<String, Long>());
	}

	private long travel(int m, int n, HashMap<String, Long> memo) {
		String key = m + "," + n;
		
		if(memo.containsKey(key)) return memo.get(key);
		if(m == 1 && n== 1) return 1;
		if(m == 0 || n == 0) return 0;
		
		memo.put(key,  travel(m - 1, n, memo) + travel(m, n - 1, memo));
		
		return memo.get(key);
	}
}
