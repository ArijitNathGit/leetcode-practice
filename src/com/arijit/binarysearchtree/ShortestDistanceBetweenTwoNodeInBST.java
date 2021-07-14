package com.arijit.binarysearchtree;

public class ShortestDistanceBetweenTwoNodeInBST {

	public static void main(String[] args) {
		
	}

}

class ShortestDistanceBetweenTwoNodeInBSTImpl {
	public int find(Node root, Node a, Node b) { 
		if(root == null) return 0;
		
		if(a.data <= root.data && b.data <= root.data) return find(root.left, a, b);
		else if( a.data > root.data && b.data > root.data ) return find(root.right, a, b);
		else return distanceFromRoot(root, a) + distanceFromRoot(root, b);
	}

	private int distanceFromRoot(Node root, Node node) {
		if(root.data == node.data ) return 0;
		else if( node.data <= root.data ) return distanceFromRoot(root.left, node) + 1;
		else return distanceFromRoot(root.right, node) + 1;
	}
}
