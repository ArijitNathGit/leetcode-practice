package com.arijit.tree;

/* https://leetcode.com/problems/same-tree/ */

/**
 * Solution:
 * 
 * At any level, if p and q are both null then they are identical
 * If either one of p or q is null but not both, then they are not identical
 * else we will traverse the left and right subtree and check if the values are same and the above properties hold true
 * 
 * */

public class SameBinaryTree {

	public static void main(String[] args) {
		Node root1 = new Node(3);
		root1.left = new Node(1);
		root1.right = new Node(4);
		root1.left.left = new Node(3);
		root1.right.left = new Node(1);
		root1.right.right = new Node(5);
		
		Node root2 = new Node(3);
		root2.left = new Node(1);
		root2.right = new Node(4);
		root2.left.left = new Node(3);
		root2.right.left = new Node(1);
		root2.right.right = new Node(5);
		
		System.out.println(new SameBinaryTreeImpl().isSameTree(root1, root2));
	}

}

class SameBinaryTreeImpl {
	public boolean isSameTree(Node p, Node q) {
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right) && (p.data == q.data);
	}
}