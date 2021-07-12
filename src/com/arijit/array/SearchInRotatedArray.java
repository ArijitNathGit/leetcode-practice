package com.arijit.array;

/* https://leetcode.com/problems/search-in-rotated-sorted-array/ */

public class SearchInRotatedArray {

	public static void main(String[] args) {
		SearchInRotatedArrayImpl obj = new SearchInRotatedArrayImpl();
		
		System.out.println(obj.search(new int[] {4,5,6,7,0,1,2}, 0));
		System.out.println(obj.search(new int[] {4,5,6,7,0,1,2}, 3));
		System.out.println(obj.search(new int[] {1}, 0));
	}

}

class SearchInRotatedArrayImpl {
	public int search(int[] nums, int target) {
		if( nums.length == 0 ) return -1;
		
		return search(nums, 0, nums.length - 1, target);
	}

	private int search(int[] nums, int left, int right, int target) {
		if( left > right ) return -1;
		
		int mid = (left + right) / 2;
		
		if( nums[mid] == target ) return mid; 
		
		if( nums[mid] < nums[right] ) {
			if( target >= nums[mid] && target <= nums[right] ) {
				return search(nums, mid + 1, right, target);
			}
			else {
				return search(nums, left, mid - 1, target);
			}
		}
		else {
			if( target <= nums[mid] && target >= nums[left]) {
				return search(nums, left, mid - 1, target);
			}
			else {
				return search(nums, mid + 1, right, target);
			}
		}		
	}
}
