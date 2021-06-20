package com.arijit.tree;

public class TreeTraversals {

	public static void main(String[] args) {
		Node head = new Node(3);
		head.left = new Node(1);
		head.right = new Node(4);
		head.left.left = new Node(3);
		head.right.left = new Node(1);
		head.right.right = new Node(5);	
		
		TreeTraversalsImpl tree = new TreeTraversalsImpl();
		System.out.println("Height: " + tree.height(head));
		tree.inOrder(head);
		System.out.println();
		tree.preOrder(head);
		System.out.println();
		tree.postOrder(head);
		System.out.println();
		tree.levelOrder(head);
		System.out.println();
		System.out.println("Max: " + tree.findMax(head));
		System.out.println();
		System.out.println("Min: " + tree.findMin(head));
		System.out.println();
		tree.leftView(head);
		System.out.println();
		tree.rightView(head);
	}

}

class TreeTraversalsImpl {
	
	private int max_level = 0;
	
	public void inOrder(Node head) {
		if ( head == null ) return;
		
		inOrder(head.left);
		System.out.print(head.data + " ");
		inOrder(head.right);
	}
	
	public void preOrder(Node head) {
		if ( head == null ) return;
		
		System.out.print(head.data + " ");
		preOrder(head.left);
		preOrder(head.right);
	}
	
	public void postOrder(Node head) {
		if ( head == null ) return;
		
		postOrder(head.left);
		postOrder(head.right);
		System.out.print(head.data + " ");
	}
	
	public int height(Node head) {
		if( head == null ) return -1;
		
		int lHeight = height(head.left);
		int rHeight = height(head.right);
		
		return Math.max(lHeight, rHeight) + 1;
	}
	
	public int findMinDepth(Node root) {
		if(root == null) return 0;
		
		if(root.left == null) return findMinDepth(root.right) + 1;
		if(root.right == null) return findMinDepth(root.left) + 1;
		
		return Math.min(findMinDepth(root.left), findMinDepth(root.right)) + 1;
	}
	
	public void levelOrder(Node head) {
		int height = height(head);
		
		for(int i = 0; i <= height; i++) {
			printLevelorder(head, i);
		}
	}

	private void printLevelorder(Node head, int i) {
		if( head == null ) return;
		if ( i == 0 ) System.out.print(head.data + " ");
		else  {
			printLevelorder(head.left, i - 1);
			printLevelorder(head.right, i - 1 );
		}
	}
	
	public int findMax(Node head) {
		if( head == null ) return Integer.MIN_VALUE;
		
		int max = head.data;
		int lres = findMax(head.left);
		int rres = findMax(head.right);
		
		if( lres > max) max = lres;
		if( rres > max) max = rres;
		
		return max;
		
	}
	
	public int findMin(Node head) {
		if( head == null ) return Integer.MIN_VALUE;
		
		int min = head.data;
		int lres = findMax(head.left);
		int rres = findMax(head.right);
		
		if( lres < min) min = lres;
		if( rres < min) min = rres;
		
		return min;
	}
	
	public void leftView(Node head) {
		max_level = 0;
		printLeftView(head, 1);
	}

	private void printLeftView(Node head, int level) {
		if (head == null) return;
		
		if(max_level < level) {
			System.out.print(head.data + " ");
			max_level = level;
		}
		
		printLeftView(head.left, level + 1);
		printLeftView(head.right, level + 1);
	}
	
	public void rightView(Node head) {
		max_level = 0;
		printRightView(head, 1);
	}

	private void printRightView(Node head, int level) {
		if (head == null) return;
		
		if(max_level < level) {
			System.out.print(head.data + " ");
			max_level = level;
		}
		
		printRightView(head.right, level + 1);
		printRightView(head.left, level + 1);
	}
}
