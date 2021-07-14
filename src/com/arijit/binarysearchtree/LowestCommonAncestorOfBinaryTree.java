package com.arijit.binarysearchtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorOfBinaryTree {

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(1);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(1);
		root.right.right = new Node(5);	
		
		System.out.println(new LowestCommonAncestorOfBinaryTreeImp().find(root, root, root));
	}

}

class LowestCommonAncestorOfBinaryTreeImp {
	public int find(Node root, Node a, Node b) {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		Map<Node, Node> parent = new HashMap<>();
		parent.put(root, null);
		
		while(!parent.containsKey(a) || !parent.containsKey(b)) {
			Node current = stack.pop();
			
			if(current.left != null) {
				stack.push(current.left);
				parent.put(current.left, current);
			}
			
			if(current.right != null) {
				stack.push(current.right);
				parent.put(current.right, current);
			}
		}
		
		Set<Node> ancestors = new HashSet<>();
		
		while(a != null) {
			ancestors.add(a);
			a = parent.get(a);
		}
		
		while( !ancestors.contains(b) ) {
			b = parent.get(b);
		}
		
		return b.data;
	}
}
