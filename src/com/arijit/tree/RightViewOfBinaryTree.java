package com.arijit.tree;

public class RightViewOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		new RightViewOfBinaryTreeImpl().rightView(root);;
	}

}

class RightViewOfBinaryTreeImpl {
	
	private int maxLevel = 0;
	
	public void rightView(Node root) {
		printRightView(root, 1);
	}

	private void printRightView(Node root, int level) {
		if( root == null ) return;
		
		if( maxLevel < level ) {
			System.out.print(root.data + " ");
			maxLevel = level;
		}
		
		printRightView(root.right, level + 1);
		printRightView(root.left, level + 1);
	}
}
