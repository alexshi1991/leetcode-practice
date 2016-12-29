/*
 * Problem: https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * Idea:    1. scan input string backwards
 *          2. extract every word and append it to the result (use a StringBuilder)
 */


public class Solution {
    
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        
		StringBuilder result = new StringBuilder();
		
		int idx = s.length() - 1; // start from last char
		boolean inWord = false;
		int startIdx = 0, endIdx = 0;
		while (idx >= 0) {
			char c = s.charAt(idx);
			if (c != ' ' && !inWord) {
				inWord = true;
				endIdx = idx + 1;
			}
			if (c == ' ' && inWord) {
				inWord = false;
				startIdx = idx + 1;
				// extract that word
				result.append(s.substring(startIdx, endIdx) + " ");
			}
			idx--;
		}
		
		if (s.charAt(0) != ' ' && inWord) {
			// there is a last word to output
			startIdx = 0;
			result.append(s.substring(startIdx, endIdx));
		} else {
			// remove trailing space if result is not empty
			if (result.length() > 0) {
				result.deleteCharAt(result.length() - 1);
			}
		}
		return result.toString();        
    }
}
