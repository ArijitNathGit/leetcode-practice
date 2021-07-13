package com.arijit.stack;

import java.util.Stack;

public class MaxDiffNearestLeftRightSmallerElement {

	public static void main(String[] args) {
		System.out.println(new MaxDiffNearestLeftRightSmallerElementImpl().find(new int[] {2, 1, 8}));
		System.out.println(new MaxDiffNearestLeftRightSmallerElementImpl().find(new int[] {2, 4, 8, 7, 7, 9, 3}));
		System.out.println(new MaxDiffNearestLeftRightSmallerElementImpl().find(new int[] {5, 1, 9, 2, 5, 1, 7}));
	}

}

class MaxDiffNearestLeftRightSmallerElementImpl {
	public int find(int[] arr) {
		int len = arr.length;
		int left[] = new int[len];
		int right[] = new int[len];
		Stack<Integer> stack = new Stack<>();
		int maxDiff = 0;
		
		for(int i = 0; i < len; i++) {
			while( !stack.isEmpty() && stack.peek() >= arr[i] ) stack.pop();
			
			if( stack.isEmpty()  ) {
				left[i] = 0;
			}
			else {
				left[i] = stack.peek();
			}
			
			stack.push(arr[i]);
		}

		stack.clear();
		
		for(int i = len - 1; i >= 0; i--) {
			while( !stack.isEmpty() && stack.peek() >= arr[i] ) stack.pop();
			
			if( stack.isEmpty()  ) {
				right[i] = 0;
			}
			else {
				right[i] = stack.peek();
			}
			
			stack.push(arr[i]);
		}
		
		for(int i = 0; i < len; i++) {
			maxDiff = Math.max(maxDiff, (Math.abs(left[i] - right[i])));
		}
		
		return maxDiff;
	}
}
