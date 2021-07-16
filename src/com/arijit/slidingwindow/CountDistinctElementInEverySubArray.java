package com.arijit.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class CountDistinctElementInEverySubArray {

	public static void main(String[] args) {
		IntStream.of(new CountDistinctElementInEverySubArrayImpl().count(new int[]{1, 2, 1, 3, 4, 2, 3}, 4)).forEach(s -> System.out.print(s + " "));
		System.out.println();
		IntStream.of(new CountDistinctElementInEverySubArrayImpl().count(new int[]{1, 2, 4, 4}, 2)).forEach(s -> System.out.print(s + " "));
	}

}

class CountDistinctElementInEverySubArrayImpl{
	public int[] count(int[] arr, int k) {
		int n = arr.length;
		int numOfWindows = n - k + 1;
		int[] result = new int[numOfWindows];
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		result[0] = map.size();
		
		for(int wStart = 1, wEnd = k; wEnd < n; wStart++, wEnd++) {
			if( map.put(arr[wStart - 1], map.getOrDefault(arr[wStart - 1], 0) - 1) == 1 ) {
				map.remove(arr[wStart - 1]);
			}
			
			map.put(arr[wEnd], map.getOrDefault(arr[wEnd], 0) + 1);
			result[wStart] = map.size();
		}
				
		return result;
	}
}