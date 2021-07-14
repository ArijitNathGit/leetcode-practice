package com.arijit.tree;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		new LevelOrderTraversalImpl().levelOrder(root);
	}

}

class LevelOrderTraversalImpl {
	public void levelOrder(Node root) {
		int height = new HeightOfBinaryTreeImpl().height(root);
		
		for(int i = 0; i <= height; i++) {
			printLevelOrder(root, i);
		}
	}

	private void printLevelOrder(Node root, int level) {
		if(root == null) return;
		if( level == 0 ) System.out.print(root.data + " ");
		printLevelOrder(root.left, level-1);
		printLevelOrder(root.right, level-1);
	}	
	
}
