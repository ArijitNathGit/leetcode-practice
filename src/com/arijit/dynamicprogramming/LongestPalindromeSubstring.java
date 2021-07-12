package com.arijit.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/longest-palindromic-substring/ */

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		System.out.println(new LongestPalindromeSubstringImpl().find("babaddtattarrattatddetartrateedredividerb"));
		System.out.println(new LongestPalindromeSubstringImpl().find("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}

}

class LongestPalindromeSubstringImpl {
	
	public String find(String s) {
		return find(s, new HashMap<String, String>());
	}
	
	public String find(String s, Map<String, String> memo) {
		if( memo.containsKey(s) ) return memo.get(s);
		if( s.length() == 1 ) return s;
		
		String lLargest = find(s.substring(0, s.length() - 1), memo);
		String rLargest = find(s.substring(1, s.length()), memo);
		
		String largest = ( lLargest.length() > rLargest.length() ) ? lLargest : rLargest;
		
		if( isPalindrome(s) ) {
			largest = ( s.length() > largest.length() ) ? s : largest;
		}
		
		memo.put(s, largest);
		
		return largest;
	}

	private boolean isPalindrome(String s) {
		for(int i = 0, j = s.length() - 1; i <= j; i++, j-- ) {
            if( s.charAt(i) != s.charAt(j) ) return false;
        }
        
        return true;
	}
}
