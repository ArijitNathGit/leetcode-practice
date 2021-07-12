package com.arijit.stack;

import java.util.Stack;

public class LengthOfLongestValidSubstring {

	public static void main(String[] args) {
		System.out.println(new LengthOfLongestValidSubstringImpl().find("()(())))"));
	}

}

class LengthOfLongestValidSubstringImpl {
	public int find(String str) {
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		
		stack.push(-1);
		
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			if( ch == '(' ) {
				stack.push(i);
			}
			else if( ch == ')' ) {
				stack.pop();
				if(stack.isEmpty()) stack.push(i);
				else max = Math.max(max, i - stack.peek());
			}
		}
		
		return max;
	}
}
