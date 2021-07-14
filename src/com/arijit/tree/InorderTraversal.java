package com.arijit.tree;

import java.util.Stack;

public class InorderTraversal {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		new InorderTraversalImpl().inorderRecursion(root);
		System.out.println();
		new InorderTraversalImpl().inorderIteration(root);
	}

}

class InorderTraversalImpl {
	public void inorderRecursion(Node root) {
		if( root == null ) return;
		
		inorderRecursion(root.left);
		System.out.print(root.data + " ");
		inorderRecursion(root.right);
	}
	
	public void inorderIteration(Node root) {
		
		if( root == null ) return;
		
		Stack<Node> stack = new Stack<>();
		Node current = root;
		
		while(current != null || !stack.isEmpty()) {
			while(current != null) {
				stack.push(current);
				current = current.left;
			}
			
			current = stack.pop();
			System.out.print(current.data + " ");
			
			current = current.right;
		}
	}
}
