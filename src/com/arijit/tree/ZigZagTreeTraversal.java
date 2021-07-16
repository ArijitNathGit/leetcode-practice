package com.arijit.tree;


import java.util.Stack;

public class ZigZagTreeTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		
		new ZigZagTreeTraversalImpl().print(root);
	}

}

class ZigZagTreeTraversalImpl {
	public void print(Node root) {
		if( root == null ) return;
		
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();
		currentLevel.add(root);
		boolean isLR = true;
		
		while(!currentLevel.isEmpty()) {
			Node current = currentLevel.pop();
			System.out.print(current.data + " ");
			
			
			if(isLR) {
				if( current.left != null )
					nextLevel.add(current.left);
				
				if(current.right != null)
					nextLevel.add(current.right);
			}
			else {
				if(current.right != null)
					nextLevel.add(current.right);

				if( current.left != null )
					nextLevel.add(current.left);				
			}			
			
			if( currentLevel.isEmpty() ) {
				isLR = !isLR;
				currentLevel = (Stack<Node>) nextLevel.clone();
				nextLevel.clear();
			}
		}
	}
}