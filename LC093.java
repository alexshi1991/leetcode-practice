/*
 * Problem: https://leetcode.com/problems/restore-ip-addresses/
 *
 * Idea:    1. recursion, backtracking, depth-first search
 *          2. when the split generates exactly 4 numbers and the input str is exhausted, add to result
 *          2. when the split contains more than 4 numbers, immediately backtrack
 *          2. when str.split() is called, needs to escape '.' (a regex that matches to any char)
 */

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) {
            return result;
        }
        extract(s, 0, new String(), result);
        return result;
    }
    
    // dfs routine tries to extract the next value(0-255) from index: start
	private void extract(String s, int start, String curr, List<String> result) {
		if (start == s.length()) {
		    String str = curr.substring(0, curr.length() - 1); // last char is '.'
		    if (str.split("\\.").length == 4) {
		        result.add(str);
		    }
			return;
		}
		if (curr.split("\\.").length > 3) return;
		
		for (int end = start + 1; end <= start + 3 && end <= s.length(); end++) {
			int num = Integer.parseInt(s.substring(start, end));
			if (end - start >= 2 && num < 10) break;
			if (num >= 0 && num <= 255) {
				int len = (end - start) + 1;
				curr += s.substring(start, end) + ".";
				extract(s, end, curr, result);
				curr = curr.substring(0, curr.length() - len); // backtracking
			}
		}
	}
}
