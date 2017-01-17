/*
 * Problem:  https://leetcode.com/problems/word-pattern/
 *
 * Idea:     hashmap + set (to keep track of mapped values)
 */

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length)  return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> usedMapping = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(c)) {
                if (!map.get(c).equals(word)) {
                    return false;  // same pattern -> diff word
                }
            } else {
                if (usedMapping.contains(word)) {
                    return false;  // diff pattern -> same word
                }
                map.put(c, word);
                usedMapping.add(word);
            }
        }
        return true;
    }
}
