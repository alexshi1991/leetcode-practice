/*
 * Problem: https://leetcode.com/problems/minimum-window-substring/
 * 
 * Idea:    1. sliding window, two pointers
 *             a) move right ptr to find new valid window
 *             b) when valid window found, move start to find smaller window  
 *          2. build a hashmap to track num of diff chars needed for current window
 *          3. O(n) time complexity
 */


public class Solution {
    public static String minWindow(String s, String t) {

        // this map tracks the number of different chars needed for current window
        // e.g how many 'A's, how many 'B's
        // (A, 1) means we are still short of 1 'A' for the current window
        // (A, 0) means we have just enough 'A' for the current window
        // (A, -1) means we have one extra 'A' for the current window
        // map gets updated as s is scanned
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int count = 0;
            if (charMap.containsKey(c)) {
                count = charMap.get(c);
            }
            count++;
            charMap.put(c, count);
        }

        int start = 0, end = 0;
        int counter = t.length(); // tracks how many chars in t still not yet accounted for
        int minStart = 0, minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            char cEnd = s.charAt(end);
            if (charMap.containsKey(cEnd)) {
                int numOfCharNeeded = charMap.get(cEnd);
                // do we still want more of this char ?
                if (numOfCharNeeded > 0) {
                    counter--;
                }
                charMap.put(cEnd, numOfCharNeeded-1); // negative means an excess of this char
            }
            end++;
            // found a valid window, move start ptr to find smaller window
            while (counter == 0) {
                char cStart = s.charAt(start);
                if ((end - start) < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                if (charMap.containsKey(cStart)) {
                    int numOfCharNeeded = charMap.get(cStart) + 1;
                    charMap.put(cStart, numOfCharNeeded);
                    if (numOfCharNeeded > 0) {
                        counter++;
                    }
                }
                start++;
            }
        }
        if (minLen != Integer.MAX_VALUE) {
            return s.substring(minStart, minStart + minLen);
        }
        return "";
    }
}
