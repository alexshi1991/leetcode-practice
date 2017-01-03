/*
 * Problem:  https://leetcode.com/problems/repeated-dna-sequences/
 *
 * Idea:     sliding window + hashmap
 *
 */

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 10) { return result; }
        
        StringBuilder sb = new StringBuilder();
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        int idx = 0;
        while (idx < 10) {
            sb.append(s.charAt(idx));
            idx++;
        }
        map.put(sb.toString(), false);
        while (idx < s.length()) {
            // use delete and append method to generate a new str
            sb.delete(0, 1);
            sb.append(s.charAt(idx));
            String currStr = sb.toString();
            if (map.containsKey(currStr)) {
                if (map.get(currStr) == false) {
                    result.add(currStr);
                    map.put(currStr, true);
                }
            } else {
                map.put(currStr, false);
            }
            idx++;
        }
        return result;        
    }
}
