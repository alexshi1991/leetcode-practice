/*
 * Problem: https://leetcode.com/problems/roman-to-integer/
 * 
 * Idea: 1. map roman chars to its integer counterparts
 *       2. scan roman numeral from left to right
 *       3. subtract from sum if curr mapped integer is less than next mapped integer (i.e. "CD")
 *       4. add to sum if curr mapped integer is greater than or equal to next mapped integer (i.e. "MC")
 *       5. one scan of the input string, O(n)
 */


public class Solution {
    public int romanToInt(String s) {
        
        if (s == null || s.length() == 0) { return 0; }
        
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('M', 1000);
        romanMap.put('D', 500);
        romanMap.put('C', 100);
        romanMap.put('L', 50);
        romanMap.put('X', 10);
        romanMap.put('V', 5);
        romanMap.put('I', 1);
        
        int sum = 0;
        int next = romanMap.get(s.charAt(0));
        for (int i = 0; i < s.length()-1; i++) {
            int curr = next;
            next = romanMap.get(s.charAt(i+1));
            if (curr < next) {
                sum -= curr;
            } else {
                sum += curr;
            }
        }

        return sum + romanMap.get(s.charAt(s.length()-1));
    }
}
