package com.arijit.tree;

public class IsBinaryTreeBalanced {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		System.out.println(new IsBinaryTreeBalancedImpl().isBalanced(root));
		
		Node root1 = new Node(3);
		root1.left = new Node(1);
		root1.right = new Node(4);
		root1.left.left = new Node(3);
		root1.right.left = new Node(1);
		root1.right.right = new Node(5);	
		root1.right.right.right = new Node(10);
		root1.right.right.right.right = new Node(15);
		
		System.out.println(new IsBinaryTreeBalancedImpl().isBalanced(root1));
	}

}

class IsBinaryTreeBalancedImpl {
	public boolean isBalanced(Node root) {
		if( root == null ) return true;
		
		int lh = new HeightOfBinaryTreeImpl().height(root.left);
		int rh = new HeightOfBinaryTreeImpl().height(root.right);
		
		if( Math.abs(rh - lh) <= 1 && isBalanced(root.left) && isBalanced(root.right) ) return true;
		return false;
	}
}
