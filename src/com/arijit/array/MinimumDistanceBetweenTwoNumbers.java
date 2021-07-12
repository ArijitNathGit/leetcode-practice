package com.arijit.array;

public class MinimumDistanceBetweenTwoNumbers {

	public static void main(String[] args) {
		System.out.println(new MinimumDistanceBetweenTwoNumbersImpl().minDistance(new int[]{0,2,3,1}, 1, 2));
		System.out.println(new MinimumDistanceBetweenTwoNumbersImpl().minDistance(new int[]{86,39,90,67,84,66,62}, 42, 12));
	}

}

class MinimumDistanceBetweenTwoNumbersImpl {
	public int minDistance(int[] arr, int x, int y) {
		int xIndex = -1;
		int yIndex = -1;
		int minDiff = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if( arr[i] == x ) {
				if( yIndex != -1 ) {
					minDiff = Math.min(minDiff, i - yIndex);
				}
				
				xIndex = i;
			}
			
			if( arr[i] == y ) {
				if( xIndex != -1 ) {
					minDiff = Math.min(minDiff, i - xIndex);
				}
				
				yIndex = i;
			}
		}
		
		return minDiff == Integer.MAX_VALUE ? -1 : minDiff;
	}
}

