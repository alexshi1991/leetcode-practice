/*
 * Problem:  https://leetcode.com/problems/valid-anagram/
 *
 * Idea:     hashmap
 *
 */

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null)  return false;
        if (s.length() != t.length()) return false;
        
        // build hashmap with chars in s (char -> # of occurs)  
        Map<Character, Integer> map = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1: 1);
        }
        
        // consume hashmap with chars in t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) return false;
            else {
                int count = map.get(c); 
                count--;  // decrement count
                if (count == 0) map.remove(c); // remove
                else map.put(c, count);
            }
        }
        
        return map.isEmpty();
    }
}
