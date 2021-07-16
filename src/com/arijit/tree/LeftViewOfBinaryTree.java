package com.arijit.tree;

public class LeftViewOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		new LeftViewOfBinaryTreeImpl().leftView(root);;
	}

}

class LeftViewOfBinaryTreeImpl {
	
	private int maxLevel = 0;
	
	public void leftView(Node root) {
		printLeftView(root, 1);
	}

	private void printLeftView(Node root, int level) {
		if( root == null ) return;
		
		if( maxLevel < level ) {
			System.out.print(root.data + " ");
			maxLevel = level;
		}
		
		printLeftView(root.left, level + 1);
		printLeftView(root.right, level + 1);
	}
}
