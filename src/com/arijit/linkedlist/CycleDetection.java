package com.arijit.linkedlist;

public class CycleDetection {

	public static void main(String[] args) {
		
	}

}

class CycleDetectionImpl {
	public boolean isPresent(Node list1) {
		Node slow = list1, fast = list1;
		
		while( fast != null && fast.next != null && slow.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(fast == slow) return true;
		}
		
		return false;
	}
}
