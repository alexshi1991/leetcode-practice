/*
 * Problem: https://leetcode.com/problems/scramble-string/
 *
 * Idea:    1. recursion
 *          2. use a hashmap to match chars in both strings,
 *             return false if s1, s2 does not have the same chars
 *          3. when checking if s1 and s2 are scrambles:
 *             a) try partition the strings at each index 1...len(str)-1
 *             b) with each partition, recursively check if childrens are scrambles:
 *                i)  match s1.left -> s2.left,  s1.right -> s2.right
 *                ii) match s1.left -> s2.right, s1.right -> s2.left
 *                
 */


public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        
        // match chars in both strings,
        // every char in s1 should be accounted for in s2
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (letters[i] != 0) return false;
        
        // recursion, index i partitions the string s1, s2 into two non-empty substrings
        // consider them left child and right child
        for (int i = 1; i < s1.length(); i++) {
            // not swapping the left child and right child
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
             && isScramble(s1.substring(i), s2.substring(i))) {
                 return true;
            }
            // swapping the left child and right child
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
             && isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) {
                return true;     
            }
        }
        return false;
    }
}
