package com.arijit.binarysearchtree;

public class ClosestNeighbourInBST {

	public static void main(String[] args) {
		
	}

}

class ClosestNeighbourInBSTImpl {
	private Integer closest = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE, minDiffVal = 0 ;
    
    public int closestValue(Node root, double target) {
        closest(root, target);
        return minDiffVal;
    }
    
    private void closest(Node root, double target) {
        if( root == null ) return;
        
        closest = Math.abs((int)(Math.round(target)) - root.data);
        if( closest < minDiff ) {
            minDiff = closest;
            minDiffVal = root.data;
        }
        
        if( target <= root.data ) closest(root.left, target);
        else closest(root.right, target);
    }
}
