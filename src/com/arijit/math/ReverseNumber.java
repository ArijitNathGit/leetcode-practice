package com.arijit.math;

public class ReverseNumber {

	public static void main(String[] args) {
		System.out.println(new ReverseNumberImpl().normal(12345));
		System.out.println(new ReverseNumberImpl().recursive(12345));
	}

}

class ReverseNumberImpl {
	public int normal(int num) {
		int reverse = 0;
		
		while(num > 0) {
			int digit = num % 10;
			reverse = reverse * 10 + digit;
			num /= 10;
		}
		
		return reverse;
	}
	
	public int recursive(int num) {
		return recursiveUtil(num, 0);
	}
	
	private int recursiveUtil(int num, int reverse) {
		if( num == 0 ) return reverse;
		
		return recursiveUtil(num/10, reverse * 10 + (num % 10));
	}
}
