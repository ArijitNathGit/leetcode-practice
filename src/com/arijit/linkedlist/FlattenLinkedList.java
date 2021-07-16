package com.arijit.linkedlist;

import java.util.Stack;

public class FlattenLinkedList {

	public static void main(String[] args) {
		FlattenNode f1 = new FlattenNode(5, null, null);
		FlattenNode f2 = new FlattenNode(10, null, null);
		FlattenNode f3 = new FlattenNode(19, null, null);
		FlattenNode f4 = new FlattenNode(28, null, null);
		
		f1.down = new FlattenNode(
				7, 
				null, 
				new FlattenNode(
						8, 
						null,
						new FlattenNode(30, null, null)
					)
			);
		
		f2.down = new FlattenNode(
				20, 
				null, 
				null
			);
		
		f3.down = new FlattenNode(
				22, 
				null, 
				new FlattenNode(
						50, 
						null,
						null
					)
			);
		
		f4.down = new FlattenNode(
				35, 
				null, 
				new FlattenNode(
						40, 
						null,
						new FlattenNode(45, null, null)
					)
				);
		
		f1.next = f2;
		f2.next = f3;
		f3.next = f4;
		
		FlattenNode result = new FlattenLinkedListImpl().flatten(f1);
		
		new FlattenLinkedListImpl().traverse(result);		
	}

}

class FlattenNode {
	int data;
	FlattenNode next;
	FlattenNode down;
	
	public FlattenNode(int data, FlattenNode next, FlattenNode down) {
		super();
		this.data = data;
		this.next = next;
		this.down = down;
	}
}

class FlattenLinkedListImpl {
	public FlattenNode flatten(FlattenNode node) {
		if(node == null) return node;
		
		Stack<FlattenNode> stack = new Stack<>();
		FlattenNode temp = node;
		
		while( temp != null ) {
			stack.push(temp);
			temp = temp.next;
		}
		
		while( stack.size() > 1 ) {
			FlattenNode t1 = stack.pop();
			FlattenNode t2 = stack.pop();
			
			stack.push(merge(t1, t2));
		}
		
		return stack.pop();
	}
	
	public FlattenNode merge(FlattenNode list1, FlattenNode list2) {
		FlattenNode temp = new FlattenNode(0, null, null), result = temp;
		
		while( list1 != null && list2 != null ) {
			if( list1.data <= list2.data ) {
				temp.down = list1;
				
				list1 = list1.down;
			}
			else {
				temp.down = list2;
				list2 = list2.down;
			}
			
			temp = temp.down;
		}
		
		temp.down = ( list1 == null ) ? list2 : list1;
		
		result.down.next = null;
		return result.down;
	}
	
	public void traverse(FlattenNode list) {
		FlattenNode temp = list;
		
		while(temp != null)  {
			System.out.println(temp.data);
			temp = temp.down;
		}
	}
}