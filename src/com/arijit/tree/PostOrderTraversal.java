package com.arijit.tree;

import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		new PostOrderTraversalImpl().postOrderRecursion(root);
		System.out.println();
		new PostOrderTraversalImpl().postOrderIteration(root);
	}

}

class PostOrderTraversalImpl {
	public void postOrderRecursion(Node root) {
		if (root == null) return;
		
		postOrderRecursion(root.left);
		postOrderRecursion(root.right);
		System.out.print(root.data + " ");
	}
	
	public void postOrderIteration(Node root) {
		if(root == null) return;
		
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		
		stack1.push(root);
		
		while(!stack1.isEmpty()) {
			Node current = stack1.pop();
			stack2.push(current);
			
			if( current.left != null ) stack1.push(current.left);
			if( current.right != null ) stack1.push(current.right);
		}
		
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().data + " ");
		}
	}
}
