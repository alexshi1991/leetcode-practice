/*
 * Problem:  https://leetcode.com/problems/bulls-and-cows/
 *
 * Idea:     hashtable
 */

public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        // go through chars in the secret number, count bulls
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            char charS = secret.charAt(i);
            char charG = guess.charAt(i);
            if (charS == charG) {
                bulls++;
            } else {
                int count = 1;
                if (map.containsKey(charS)) {
                    count = map.get(charS);
                    count++;
                }
                map.put(charS, count);
            }
        }
        
        // go through chars in the guess number, count cows
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            char charS = secret.charAt(i);
            char charG = guess.charAt(i);
            if (charG != charS) {
                if (map.containsKey(charG)) {
                    cows++;
                    int count = map.get(charG);
                    count--;
                    if (count == 0) {
                        map.remove(charG);
                    } else {
                        map.put(charG, count);
                    }
                }
            }
        }
        
        return new String(bulls + "A" + cows + "B");        
    }
}
