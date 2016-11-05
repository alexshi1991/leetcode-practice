public class Solution {

    /*
     * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
     *
     * Idea: 1. use two pointers, left and right
     *       2. use hashmap to store <char, index> pairs
     *       3. update left pointer when we encounter a repeating character
     *       4. when check for existance in hashmap, need to compare the index with left pointer
     *       5. make sure inputs such as "orange" get correct result, final check after while loop
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) { return 0;}
        int maxLen = 1;
        int left = 0, right = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            // all the entries that maps chars to indices smaller than left are invalid entries
            if (charMap.containsKey(c) && charMap.get(c) >= left) {
                maxLen = Math.max(maxLen, right-left);
                left = charMap.get(c) + 1;
            }
            charMap.put(c, right); // overwrite the prev index for c if c has appeared before
            right++;
        }
        return Math.max(maxLen, right-left);
    }
}