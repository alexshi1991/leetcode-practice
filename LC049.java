/*
 * Problem: https://leetcode.com/problems/anagrams/
 *
 * Idea: 1. use a hashmap <String, List<String>>
 *       2. key is the unique sorted strs in input array
 *       3. "eat", "ate", "tea"   ->   all map to key "aet"
 *       4. time complexity is O(n*mlgm), where n is the number of strs and m is the average length of the strs
 */


public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        if (strs == null || strs.length == 0) 
            return new ArrayList<List<String>>();
        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<String>());
            }
            groups.get(key).add(str);
        }
        return new ArrayList<List<String>>(groups.values());
    }
}
