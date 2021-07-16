package com.arijit.tree;

public class IsTreeBST {

	public static void main(String[] args) {
		Node tree = new Node(4);
        tree.left = new Node(2);
        tree.right = new Node(5);
        tree.left.left = new Node(1);
        tree.left.right = new Node(3);
        
        System.out.println(new IsTreeBSTImpl().isTreeBST(tree));
        System.out.println(new IsTreeBSTImpl().isTreeBSTEfficient(tree));
	}

}

class IsTreeBSTImpl {
	public boolean isTreeBST(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBST(Node root, int minValue, int maxValue) {
		if( root == null ) return true;
		
		if( root.data < minValue || root.data > maxValue ) return false;
		
		return isBST(root.left, minValue, root.data - 1) && isBST(root.right, root.data + 1, maxValue);
	}
	
	public boolean isTreeBSTEfficient(Node root) {
		return isBSTEfficient(root, null, null);
	}

	private boolean isBSTEfficient(Node root, Node left, Node right) {
		if( root == null ) return true;
		
		if( left != null && left.data > root.data ) return false;
		if( right != null && right.data < root.data ) return false;
		
		return isBSTEfficient(root.left, left, root) && isBSTEfficient(root.right, root, right);
	}
}
