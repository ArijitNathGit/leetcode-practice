package com.arijit.tree;

public class HeightOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		System.out.println(new HeightOfBinaryTreeImpl().height(root));
	}

}

class HeightOfBinaryTreeImpl {
	public int height(Node root) {
		if( root == null ) return -1;
		return Math.max(height(root.left), height(root.right)) + 1;
	}
}