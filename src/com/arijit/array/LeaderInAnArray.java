package com.arijit.array;

public class LeaderInAnArray {

	public static void main(String[] args) {
		new LeaderInAnArrayImpl().find(new int[] {16,17,4,3,5,2});
		new LeaderInAnArrayImpl().find(new int[] {1,2,3,4,0});
	}

}

class LeaderInAnArrayImpl {
	public void find(int[] arr) {
		int leader = Integer.MIN_VALUE;
		
		for(int i = arr.length - 1; i >= 0; i--) {
			if( arr[i] > leader ) {
				leader = arr[i];
				System.out.println(leader);
			}
		}
	}
}
