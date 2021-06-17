package com.arijit.array;

public class MinimumInRotatedArray {

	public static void main(String[] args) {
		MinimumInRotatedArrayImpl obj = new MinimumInRotatedArrayImpl();
		System.out.println(obj.findMin(new int[] {4,5,6,7,0,1,2}));
		System.out.println(obj.findMin(new int[] {3,4,5,1,2}));
		System.out.println(obj.findMin(new int[] {11,13,15,17}));

	}

}

class MinimumInRotatedArrayImpl {
	
	public int findMin(int[] nums) {
		if( nums.length == 1 ) return nums[0];
		if( nums[nums.length - 1] > nums[0] ) return nums[0];
		
		return findMinimum(nums, 0, nums.length - 1);
	}
	
	private int findMinimum(int[] nums, int left, int right) {
		int mid = (left + right) / 2;
		
		if( nums[mid] > nums[mid + 1] ) return nums[mid + 1];
		
		if( nums[mid] < nums[mid - 1] ) return nums[mid];
		
		if( nums[mid] < nums[right] ) return findMinimum(nums, left, mid - 1);
		
		else if( nums[mid] > nums[right] ) return findMinimum(nums, mid + 1, right);
		
		else return nums[mid];
	}
}
