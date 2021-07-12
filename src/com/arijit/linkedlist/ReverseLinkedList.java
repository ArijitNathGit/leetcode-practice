package com.arijit.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node list = new Node(5);
		list.next = new Node(5);
		list.next.next = new Node(7);
		list.next.next.next = new Node(7);
		list.next.next.next.next = new Node(9);
		list.next.next.next.next.next = new Node(9);
		
		ReverseLinkedListImpl obj = new ReverseLinkedListImpl();
		Node head = obj.reverse(list);
		obj.traverse(head);
	}

}

class ReverseLinkedListImpl {
	public Node reverse(Node list) {
		Node current = list, prev = null;
		
		while(current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}
	
	public void traverse(Node list) {
		Node temp = list;
		
		while(temp != null)  {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
