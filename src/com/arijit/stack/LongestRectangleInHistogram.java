package com.arijit.stack;

import java.util.Stack;

public class LongestRectangleInHistogram {

	public static void main(String[] args) {
		System.out.println(new LongestRectangleInHistogramImpl().largestRectangleArea(new int[] {2,1,5,6,2,3}));
	}

}

class LongestRectangleInHistogramImpl {
	public int largestRectangleArea(int[] heights) {
        
        if(heights.length == 0) return -1;
        if(heights.length == 1) return heights[0];
        
        int len = heights.length;        
        int left[] = new int[len];
        int right[] = new int[len];
        int maxArea = 0;
        Stack<Integer> stackLeft = new Stack<>();
        Stack<Integer> stackRight = new Stack<>();
        
        for(int i = 0, j = len - 1; i < len && j >= 0; i++, j--) {
            if( stackLeft.isEmpty() ) {
                left[i] = 0;
                stackLeft.push(i);
            }
            else {
                while( !stackLeft.isEmpty() && heights[stackLeft.peek()] >= heights[i] ) {
                    stackLeft.pop();
                }
                
                left[i] = stackLeft.isEmpty() ? 0 : stackLeft.peek() + 1;
                stackLeft.push(i);
            }
            
            if(stackRight.isEmpty()) {
                right[j] = len - 1;
                stackRight.push(j);
            }
            else {
                while( !stackRight.isEmpty() && heights[stackRight.peek()] >= heights[j] ) {
                    stackRight.pop();
                }  
                
                right[j] = stackRight.isEmpty() ? len - 1 : stackRight.peek() - 1;
                stackRight.push(j);
            }            
        }        
        
        for(int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] + 1) * heights[i]);
        }
        
        return maxArea;
    }
}
