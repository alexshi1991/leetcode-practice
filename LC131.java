/*
 * Problem:  https://leetcode.com/problems/palindrome-partitioning/
 *
 * Idea:     1. dynamic programming
 *           2. get result[i] (all possible partitions for s[0...i]) for 0 <= i <= s.length()
 *           3. use a 2D boolean array to track whether s[i...j] is palindrome
 *           4. when looking at a new problem size:
 *              a. first find out all the palindromes that ends with char at index i
 *              b. each new palindrome represents a split point
 *              c. use that split point to find the solution to a prev solved smaller prob 
 *              d. add the new palindrome to the prev smaller prob result, 
 *                 these are the new possible splits for the curr prob size
 *           5. for example: if we already know that for string "aab", there are the following splits:
 *
 *              "aab"   ===>   ["aa", "b"],   ["a", "a", "b"]
 *
 *              then, when we look at string "aaba", we first find all the new palindrome that make use of the last "a"
 *              they are:  "aba" and "a"
 *                  for "aba", we need the solution to a smaller prob:  "a"  ==> ["a"]
 *                  for "a", we need the solution to a smaller prob: "aab"   ==> ["aa", "b"], ["a", "a", "b"]
 *
 *              so the solution to "aaba" is:  ["a", "aba"], ["aa", "b", "a"], ["a", "a", "b", "a"] 
 *
 */

public class Solution {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1]; // result[i] is all possible partitions for s[0...i]
        result[0] = new ArrayList<>();
        result[0].add(new ArrayList<String>());
        
        boolean[][] isPalindrome = new boolean[len][len];// whether s[i...j] is palindrome
        for (int i = 0; i < s.length(); i++) {
            result[i+1] = new ArrayList<>();
            for (int left = 0; left <= i; left++) {
                // find all palindromes that ends with char at index i
                if (s.charAt(left) == s.charAt(i) && (i - left <= 1 || isPalindrome[left+1][i-1])) {
                    isPalindrome[left][i] = true;
                    String str = s.substring(left, i+1);
                    for (List<String> list : result[left]) {
                        List<String> listCopy = new ArrayList<>(list);
                        listCopy.add(str);
                        result[i+1].add(listCopy);
                    }
                }
            }
        }
        
        return result[len];
    }
}
