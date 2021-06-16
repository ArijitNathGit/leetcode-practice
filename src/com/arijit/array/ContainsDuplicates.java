package com.arijit.array;

import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/problems/contains-duplicate/solution/ */

/**
 * Solution:
 * 
 * Create a Set and add elements if its not present in set. 
 * If present then return true;
 * Else if after entire array traversal, no elements are found to be duplicate, return false
 * 
 * */

public class ContainsDuplicates {

	public static void main(String[] args) {
		ContainsDuplicatesImpl obj = new ContainsDuplicatesImpl();
		
		System.out.println(obj.containsDuplicate(new int[] {1,2,3,1}));
		System.out.println(obj.containsDuplicate(new int[] {1,2,3,4}));
		System.out.println(obj.containsDuplicate(new int[] {1,1,1,3,3,4,3,2,4,2}));
	}
}

class ContainsDuplicatesImpl {
	public boolean containsDuplicate(int[] nums) {
        Set<Integer> dup = new HashSet<>();
        
        for(int num : nums) {
            if( dup.contains(num) ) return true;
            else dup.add(num);
        }
        
        return false;
    }
}
