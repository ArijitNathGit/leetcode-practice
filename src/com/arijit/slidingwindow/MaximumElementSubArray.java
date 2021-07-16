package com.arijit.slidingwindow;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class MaximumElementSubArray {

	public static void main(String[] args) {
		IntStream.of(new MaximumElementSubArrayImpl().find(new int[] {1,3,-1,-3,5,3,6,7}, 3)).forEach(System.out::println);
	}

}

class MaximumElementSubArrayImpl {
	public int[] find(int[] arr, int windowSize) {
		if ( arr.length == 1 ) return new int[]{arr[0]};
		
		int n = arr.length;
		int noOfWindows = n - windowSize + 1;
		int[] result = new int[noOfWindows];
		Queue<QueueData> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < windowSize; i++) {
			pQueue.add(new QueueData(arr[i], i));
		}
		
		result[0] = pQueue.peek().data;
		
		for(int wStart = 1, wEnd = windowSize; wEnd < n; wStart++, wEnd++) {
			pQueue.add(new QueueData(arr[wEnd], wEnd));
			
			while( pQueue.peek().index < wStart ) pQueue.poll();
			result[wStart] = pQueue.peek().data;
		}
		
		return result;
	}
}

class QueueData implements Comparable<QueueData> {
	int data;
	int index;
	
	public QueueData(int data, int index) {
		super();
		this.data = data;
		this.index = index;
	}
	
	@Override
	public String toString() {
		return "QueueData [data=" + data + ", index=" + index + "]";
	}

	@Override
	public int compareTo(QueueData o) {
		return this.data - o.data;
	}
}