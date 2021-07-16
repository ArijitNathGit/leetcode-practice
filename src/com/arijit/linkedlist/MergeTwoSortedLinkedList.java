package com.arijit.linkedlist;

public class MergeTwoSortedLinkedList {

	public static void main(String[] args) {
		Node list1 = new Node(5);
		list1.next = new Node(7);
		list1.next.next = new Node(9);
		
		Node list2 = new Node(4);
		list2.next = new Node(6);
		list2.next.next = new Node(8);
		
		Node merged = new MergeTwoSortedLinkedListImpl().mergeEfficient(list1, list2);
		new MergeTwoSortedLinkedListImpl().traverse(merged);		
	}

}

class MergeTwoSortedLinkedListImpl {
	public Node merge(Node list1, Node list2) {
		
		Node temp1 = new Node(0), temp2 = list2;
		temp1.next = list1;
		
		Node temp3 = temp1;
		
		while( temp2 != null && temp3.next != null  ) {
			if( temp3.data <= temp2.data && temp3.next.data > temp2.data ) {
				Node t = temp3.next;
				temp3.next = temp2;
				temp2 = temp2.next;
				temp3.next.next = t;
			}

			temp3 = temp3.next;
		}
				
		return temp1.next;
	}
	
	public Node mergeEfficient(Node list1, Node list2) {
		Node temp = new Node(0), result = temp;
		
		while( list1 != null && list2 != null ) {
			if( list1.data <= list2.data ) {
				temp.next = list1;
				
				list1 = list1.next;
			}
			else {
				temp.next = list2;
				list2 = list2.next;
			}
			
			temp = temp.next;
		}
		
		temp.next = ( list1 == null ) ? list2 : list1;
		
		return result.next;
	}
	
	public void traverse(Node list) {
		Node temp = list;
		
		while(temp != null)  {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
