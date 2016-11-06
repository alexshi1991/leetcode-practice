/*
 * Problem: https://leetcode.com/problems/longest-palindromic-substring/
 */


public class Solution {
    
/*********************** Approach 1 ****************************/

    // brute-force algorithm, check all the possible substrings,
    // O(N*N*N) time complexity
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) { return s; }
        int maxLen = 1;
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String substr = s.substring(i, j+1);
                if (isPalindrome(substr)) {
                    if (substr.length() > maxLen) {
                        maxLen = substr.length();
                        result = substr;
                    }
                }
            }
        }
        return result;
    }
    
    // return true if a give string is a palindrome
    private boolean isPalindrome(String str) {
        if (str == null) return false;
        if (str.equals("")) return true;
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            } 
            left++;
            right--;
        }
        return true;
    }

/*********************** Approach 2 ****************************/

    // expand-around-center approach
    // O(N * N) time complexity
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) { return s; }
        int maxLen = 1;
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // use s[i] as potential palindrome center (aba style)
            String str1 = expandLeftRight(s, i-1, i+1);
            if (str1.length() > maxLen) {
                maxLen = str1.length();
                result = str1;
            }
            
            // use s[i] and s[i+1] as potential palindrome center (abba style)
            if (i + 1 <= s.length() - 1 && (s.charAt(i) == s.charAt(i+1))) {
                String str2 = expandLeftRight(s, i-1, i+2);
                if (str2.length() > maxLen) {
                    maxLen = str2.length();
                    result = str2;
                }
            }
        }
        
        return result;
    }
    
    // given a center (one char or two same chars),
    // expand towards left and right to find the max-length palindrome substring
    private String expandLeftRight(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 
               && s.charAt(left) == s.charAt(right)) {
            left--; 
            right++;
        }
        return s.substring(left+1, right);
    }
}