package com.arijit.linkedlist;

public class MergePointOfTwoList {

	public static void main(String[] args) {
		Node list1 = new Node(3);
		list1.next = new Node(6);
		list1.next.next = new Node(9);
		Node commonNode = new Node(15);
		list1.next.next.next = commonNode;
		commonNode.next = new Node(30);
		
		Node list2 = new Node(10);
		list2.next = commonNode;
		
		System.out.println(new MergePointOfTwoListImpl().find(list1, list2));
	}

}


class MergePointOfTwoListImpl {
	public int find(Node list1, Node list2) {
		Node p1 = list1, p2 = list2;
		
		while(p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
			
			if( p1 == p2 ) return p1.data;
			
			if(p1 == null) p1 = list2;
			if(p2 == null) p2 = list1;
		}
		
		return p1.data;
	}
}

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}