package com.arijit.tree;

public class InvertBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		System.out.println("Before Inversion");
		new TreeTraversalsImpl().levelOrder(root);
		System.out.println();
		System.out.println("After Inversion");
		new TreeTraversalsImpl().levelOrder(new InvertBinaryTreeImpl().invertTree(root));
	}
	
}

class InvertBinaryTreeImpl {
	public Node invertTree(Node root) {
		if( root == null ) return null;
		
		Node left = invertTree(root.left);
		Node right = invertTree(root.right);
		
		root.left = right;
		root.right = left;
		
		return root;
	}
}
