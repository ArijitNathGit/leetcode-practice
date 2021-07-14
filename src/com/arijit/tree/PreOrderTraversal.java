package com.arijit.tree;

import java.util.Stack;

public class PreOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		new PreOrderTraversalImpl().preOrderRecursion(root);
		System.out.println();
		new PreOrderTraversalImpl().preOrderIteration(root);
	}

}

class PreOrderTraversalImpl {
	public void preOrderRecursion(Node root) {
		if (root == null) return;
		
		System.out.print(root.data + " ");
		preOrderRecursion(root.left);
		preOrderRecursion(root.right);
	}
	
	public void preOrderIteration(Node root) {
		if(root == null) return;
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.print(current.data + " ");
			
			if( current.right != null ) stack.push(current.right);
			if( current.left != null ) stack.push(current.left);
		}
	}
}
