/*
 * Problem: https://leetcode.com/problems/valid-palindrome/
 *
 * Idea:    1. use regular expression to preprocess the string
 *          2. scan string to compare char with its mirror position
 */


public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) { return false;}
        if (s.length() == 0) {return true;}
        
        // use regular expression
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}

		return true;
    }
}

