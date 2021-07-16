package com.arijit.tree;

import java.util.Stack;

public class CountLeaveNodesInBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		System.out.println(new CountLeaveNodesInBinaryTreeImpl().countLeafNodes(root));
		System.out.println(new CountLeaveNodesInBinaryTreeImpl().countLeafNodesStack(root));
	}

}

class CountLeaveNodesInBinaryTreeImpl {
	public int countLeafNodes(Node root) {
		if (root == null) return 0;
		
		if(root.left == null && root.right == null) return 1;
		return countLeafNodes(root.left) + countLeafNodes(root.right);
	}
	
	public int countLeafNodesStack(Node root) {
		if(root == null) return 0;
		
		int count = 0;
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			if( stack.peek().left == null && stack.peek().right == null) {
				count ++;
			}
			
			Node current = stack.pop();
			if( current.left != null ) stack.push(current.left);
			if( current.right != null ) stack.push(current.right);
		}
		
		return count;
	}
}
