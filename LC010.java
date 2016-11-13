/*
 * Problem: https://leetcode.com/problems/regular-expression-matching/
 * 
 * Idea: Recursion, start from the last char in pattern and work our way to the front,
 *       If encounter '*' character, we either match the proceeding char zero or one time
 *       E.g. 
 *            1. isMatch("abbb", "abb*") -> isMatch("abbb", "ab") || isMatch("abb", "abb*")
 *            2. isMatch("abbc", "acd.") -> isMatch("abb", "acd")
 *            3. isMatch("adef", "acdd") -> false
 *            4. isMatch("", "") -> true (base case)
 *            5. isMatch("", "a.") -> false (base case)
 *            6. isMatch("ac", "") -> false (base case)
 *
 */


public class Solution {
    public boolean isMatch(String s, String p) {
        // recursion base case
    	if (s.isEmpty() && p.isEmpty()) {
    		return true;
    	} else if (s.isEmpty() && p.charAt(p.length() - 1) != '*') {
    		return false;
    	} else if (p.isEmpty() && !s.isEmpty()) {
    		return false;
    	}
    	    	
    	// examine the last char of regex p 
    	char c = p.charAt(p.length() - 1);
		if ((s.length() > 0 && c == s.charAt(s.length() - 1)) || c == '.') {
			// recursively match the remaining string
			return isMatch(s.substring(0, s.length() - 1),
					       p.substring(0, p.length() - 1));
		} else if (c == '*') {
			char proceedingChar = p.charAt(p.length() - 2);
			int pos = s.length() - 1;
			
			// patterns like "a*" can count as both a match and no match
			boolean matchZeroTimes = isMatch(s.substring(0, pos + 1), p.substring(0, p.length() - 2));
			if (matchZeroTimes) {
			    return true;
			}
			boolean matchOneTime = false;
			if ((pos >= 0) && (proceedingChar == s.charAt(pos) || (proceedingChar == '.'))) {
				matchOneTime = isMatch(s.substring(0, pos), p);
			}			
			return matchZeroTimes || matchOneTime;
			
		} else {
			return false;
		}
    }
}