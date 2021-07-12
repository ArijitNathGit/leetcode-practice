package com.arijit.math;

public class RepetitiveSumOfDigits {

	public static void main(String[] args) {
		System.out.println(new RepetitiveSumOfDigitsImpl().find(123456));
		System.out.println(new RepetitiveSumOfDigitsImpl().findEfficient(123456));
	}
	
}

class RepetitiveSumOfDigitsImpl {
	public int find(int num) {
		while (num > 9) {
			int sum = 0;
			while( num > 0 ) {
				int digit = num % 10;
				sum += digit;
				num /= 10;
			}
			
			num = sum;
		}
		
		return num;
	}
	
	public int findEfficient(int num) {
		if(num == 0) return 0;
		return (num % 9 == 0) ? 9 : (num % 9);
	}
}