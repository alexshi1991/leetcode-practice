/*
 * Problem:  https://leetcode.com/problems/shortest-palindrome/
 *
 * Idea:     1. get the reverse of string s, this is the maximum prefix 
 *              "cbcac"   ---> (reverse)    "cacbc" , 
 *              if we were to prepend "cacbc" to "cbcac", we are guaranteed a palindrome
 *           2. find the smallest prefix by examining if original.startsWith(reversed.substring(i)), 
 *              (0 <= i < s.length())  
 *
 */

public class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s).reverse();
        int idx;
        for (idx = 0; idx < s.length(); idx++) {
            if (s.startsWith(sb.substring(idx))) {
                break; // found the minimum prepending needed
            }
        }
        return sb.substring(0, idx) + s;
    }
}
