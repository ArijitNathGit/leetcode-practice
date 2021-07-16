package com.arijit.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		System.out.println(new SubarraySumEqualsKImpl().subarraySum(new int[] {3,4,7,2,-3,1,4,2}, 7));
	}

}

class SubarraySumEqualsKImpl {
	public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            if(map.containsKey(sum - k))
                count += map.get(sum-k);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}