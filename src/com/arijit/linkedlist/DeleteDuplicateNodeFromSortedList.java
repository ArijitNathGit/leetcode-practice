package com.arijit.linkedlist;

public class DeleteDuplicateNodeFromSortedList {

	public static void main(String[] args) {
		
		Node list = new Node(5);
		list.next = new Node(5);
		list.next.next = new Node(7);
		list.next.next.next = new Node(7);
		list.next.next.next.next = new Node(9);
		list.next.next.next.next.next = new Node(9);
		
		DeleteDuplicateNodeFromSortedListImpl obj = new DeleteDuplicateNodeFromSortedListImpl();
		obj.delete(list);
		obj.traverse(list);
	}

}

class DeleteDuplicateNodeFromSortedListImpl {
	public void delete(Node list) {
		Node temp = list;
		
		while(temp != null && temp.next != null) {
			if( temp.data == temp.next.data ) {
				temp.next = temp.next.next;
			}
			else {
				temp = temp.next;
			}
		}
	}
	
	public void traverse(Node list) {
		Node temp = list;
		
		while(temp != null)  {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
 