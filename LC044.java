/*
 * Problem: https://leetcode.com/problems/wildcard-matching/
 *
 * Idea:    1. recursively match the last char in p to last char in s
 *          2. '?' can be used to match any character
 *          3. '*' can be used to match a sequence of ZERO or ONE chars
 *          4. general idea similar to Regular Expression Matching problem
 */


public class Solution {

	// exceeds time limit for some LeetCode OJ test cases
    public boolean isMatch(String s, String p) {
        // recursion base case
    	if (s.isEmpty() && p.isEmpty()) {
    		return true;
    	} else if (s.isEmpty() && p.charAt(p.length() - 1) != '*') {
    		return false;
    	} else if (p.isEmpty() && !s.isEmpty()) {
    		return false;
    	}
    	    	
    	// examine the last char of pattern p 
    	char c = p.charAt(p.length() - 1);
		if ((s.length() > 0 && c == s.charAt(s.length() - 1)) || c == '?') {
			// recursively match the remaining string
			return isMatch(s.substring(0, s.length() - 1),
					       p.substring(0, p.length() - 1));
		} else if (c == '*') {
			int pos = s.length() - 1;
			
			// discard '*' in p, i.e. '*' is used to match a sequence of ZERO chars
			boolean matchZeroTimes = isMatch(s.substring(0, pos + 1), p.substring(0, p.length() - 1));
			if (matchZeroTimes) {
			    return true;
			}
			
			// use '*' to match the one character in s, then do recursion
		    boolean matchOneTime = false;
			if (pos >= 0) {
				matchOneTime = isMatch(s.substring(0, pos), p);
			}
			
			return matchZeroTimes || matchOneTime;
			
		} else {
			return false;
		}
    }
}
