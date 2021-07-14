package com.arijit.tree;

public class CountLeaveNodesInBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		System.out.println(new CountLeaveNodesInBinaryTreeImpl().countLeafNodes(root));
	}

}

class CountLeaveNodesInBinaryTreeImpl {
	public int countLeafNodes(Node root) {
		if (root == null) return 0;
		
		if(root.left == null && root.right == null) return 1;
		return countLeafNodes(root.left) + countLeafNodes(root.right);
	}
}
