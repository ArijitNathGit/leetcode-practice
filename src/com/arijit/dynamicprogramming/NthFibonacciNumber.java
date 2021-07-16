package com.arijit.dynamicprogramming;

import java.util.HashMap;

public class NthFibonacciNumber {

	public static void main(String[] args) {
		System.out.println(new NthFibonacciNumberImpl().find(10));
	}

}

class NthFibonacciNumberImpl {
	public int find(int n) {
		return find(n, new HashMap<Integer, Integer>());
	}

	private int find(int n, HashMap<Integer, Integer> memo) {
		if(memo.containsKey(n)) return memo.get(n);
		if(n <= 2) return 1;
		
		memo.put(n, find(n - 1, memo) + find(n-2, memo));
		return memo.get(n);
	}
	
}
