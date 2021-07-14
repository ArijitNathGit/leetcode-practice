package com.arijit.tree;

public class SymmetricTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(1);
		root.left.left = new Node(3);
		root.right.right = new Node(3);	
		
		System.out.println(new SymmetricTreeImpl().isSymmetric(root));
	}

}

class SymmetricTreeImpl {
	public boolean isSymmetric(Node root) {
		return isMirror(root, root);
	}

	private boolean isMirror(Node root1, Node root2) {
		if( root1 == null && root2 == null ) return true;
		if( root1 == null || root2 == null ) return false;
		
		return (root1.data == root2.data) &&
			   isMirror(root1.left, root2.right) &&
			   isMirror(root1.right, root2.left);
	}
}