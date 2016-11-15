/*
 * Problem: https://leetcode.com/problems/longest-common-prefix/
 *
 * Idea: 1. find out the shortest among all the strings
 *       2. vertical scan to match characters in shortest str with chars in other strings
 *       3. match one char at a time
 */


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0) { return "";}
        
        // identify the string with the shortest length
        String shortest = strs[0];
        for (String str: strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        
        // vertical scan to find out the longest common prefix
        String longestPrefix = "";
        for (int i = 0; i < shortest.length(); i++) {
            String prefix = shortest.substring(0, i+1);
            boolean validPrefix = true;
            for (String str: strs) {
                if (str.charAt(i) != shortest.charAt(i)) {
                    validPrefix = false;
                    break;
                }
            }
            if (validPrefix) {
                longestPrefix = prefix;
            } else {
                break;
            }
        }
        
        return longestPrefix;
    }
}
