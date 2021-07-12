package com.arijit.stack;

import java.util.Stack;

public class SortStackWithRecursion {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(30);
		stack.push(-5);
		stack.push(18);
		stack.push(14);
		stack.push(-3);
		
		new SortStackWithRecursionImpl().sortStack(stack);
		
		stack.forEach(System.out::println);
	}

}

class SortStackWithRecursionImpl {
	public void sortStack(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			int data = stack.pop();
			sortStack(stack);
			
			sortedInsert(stack, data);
		}
	}

	private void sortedInsert(Stack<Integer> stack, int data) {
		if( stack.isEmpty() || data > stack.peek()) {
			stack.push(data);
			return;
		}
		
		int temp = stack.pop();
		sortedInsert(stack, data);
		
		stack.push(temp);
	}
}
