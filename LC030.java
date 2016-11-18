/*
 * Problem: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 *
 * Idea: hashmap, this version currently exceeds time limit
 */


public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length == 0) { return result; }
        int wordLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            int count = 1;
            if (map.containsKey(word)) {
                count = map.get(word)+1;
            }
            map.put(word, count);
        }
        Map<String, Integer> usedWords = new HashMap<>();
        for (int i = 0; i <= s.length() - wordLen * words.length; i++) {
            
            // restore word map, add previously removed entries back
            // this is used to avoid making a copy of the wordMap for each iteration
            for (String w: usedWords.keySet()) {
                if (!map.containsKey(w)) {
                    map.put(w, usedWords.get(w));
                } else {
                    // increase the count back
                    map.put(w, usedWords.get(w) + map.get(w));
                }
            }
            usedWords.clear();
            
            for (int j = 0; j < words.length; j++) {
                String word = s.substring(i+j*wordLen, i+(j+1)*wordLen);
                if (map.containsKey(word)) {
                    int count = map.get(word);
                    // remove or decrement the count from copy map
                    if (count == 1) {
                        map.remove(word);
                    } else {
                        map.put(word, count-1);
                    }
                    // add or increment the count to usedWords map
                    if (usedWords.containsKey(word)) {
                        usedWords.put(word, usedWords.get(word)+1);
                    } else {
                        usedWords.put(word, 1);
                    }
                    if (map.isEmpty()) {
                        result.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
