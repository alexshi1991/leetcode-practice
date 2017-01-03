/*
 * Problem:  https://leetcode.com/problems/isomorphic-strings/
 *
 * Idea:     1. hashtable 
 *           2. in this prob, a char can either be used as a mapping key or mapping val, but not both
 *              meaning if a -> b, b can not then be mapped to other chars, cyclic mapping not allowed
 *           
 *
 */

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> mappedChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char val = t.charAt(i);
            if (map.containsKey(key)) {
                if (map.get(key) != val)
                    return false;
            } else if (mappedChars.contains(val)){ 
                return false;
            } else {
                map.put(key, val);
                mappedChars.add(val); 
            }
        }
        return true;        
    }
}
