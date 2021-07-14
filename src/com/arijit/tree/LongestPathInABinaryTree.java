package com.arijit.tree;

import java.util.ArrayList;
import java.util.List;

public class LongestPathInABinaryTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		new LongestPathInABinaryTreeImpl().find(root).stream().sorted().forEach(System.out::println);
	}

}

class LongestPathInABinaryTreeImpl {
	public List<Integer> find(Node root) {
		if( root == null) {
			return new ArrayList<Integer>();
		}
		
		List<Integer> right = find(root.right); 
		List<Integer> left = find(root.left);
		
		if( right.size() < left.size() ) {
			left.add(root.data);
		}
		else {
			right.add(root.data);
		}
		
		return (left.size() > right.size()) ? left : right;
	}
}
