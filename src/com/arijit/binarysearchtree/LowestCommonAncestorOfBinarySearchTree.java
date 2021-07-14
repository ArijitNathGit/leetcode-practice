package com.arijit.binarysearchtree;

public class LowestCommonAncestorOfBinarySearchTree {

	public static void main(String[] args) {
		
	}

}

class LowestCommonAncestorOfBinarySearchTreeImpl {
	public int find(Node root, Node a, Node b) {
		if ( a.data <= root.data && b.data <= root.data ) {
			return find(root.left, a, b);
		}
		else if( a.data >= root.data && b.data >= root.data ) {
			return find(root.right, a, b);
		}
		else {
			return root.data;
		}
	}
}