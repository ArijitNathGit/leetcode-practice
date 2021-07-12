package com.arijit.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(new LongestSubstringWithRepeatingCharactersImpl().longestSubstring("abcabcbb"));
		System.out.println(new LongestSubstringWithRepeatingCharactersImpl().longestSubstring("pwwkew"));
	}

}

class LongestSubstringWithRepeatingCharactersImpl {
	public int longestSubstring(String str) {
		
		if( "".equals(str) ) return 0;
		
		int maxStore = 1, left = 0, right = 0;
		
		Map<String, Integer> index = new HashMap<>();
		
		while( right < str.length() && left <= right  ) {
			
			String ch = String.valueOf(str.charAt(right));
			
			if ( index.containsKey(ch) ) {
				left = Math.max(left, index.get(ch) + 1);
			}
			
			index.put(ch, right++);
			maxStore = Math.max(maxStore, (right - left));
		}
		
		return maxStore;
	}
}
