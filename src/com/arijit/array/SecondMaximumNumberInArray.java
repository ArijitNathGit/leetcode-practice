package com.arijit.array;

public class SecondMaximumNumberInArray {

	public static void main(String[] args) {
		System.out.println(new SecondMaximumNumberInArrayImpl().find(new int[] {100,5,2,5,9,8,7,6,5,3,2,6,5,4,1,20}));
	}

}

class SecondMaximumNumberInArrayImpl {
	public int find(int[] arr) {
		int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if( arr[i] > max ) {
				secondMax = max;
				max = arr[i];	
			}
			
			if( arr[i] > secondMax && arr[i] != max ) secondMax = arr[i];
		}
		
		return secondMax;
	}
}
