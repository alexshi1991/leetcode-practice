/*
 * Problem: https://leetcode.com/problems/length-of-last-word/
 *
 * Idea:    1. java string's trim() method helps remove trailing whitespaces
 *          2. start from the last char of the string, increment length if encounter non-whitespace char
 *          3. return length when encounter whitespace
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.length() == 0) return 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') break;
            count++;
        }
        return count;
    }
}
