/*
 * Problem: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Idea: use a FIFO queue
 */


public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"#", "#", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> result = new LinkedList<>();  // FIFO queue
        if (digits == null || digits.length() == 0) {
            return result;
        }
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            String chars = map[digits.charAt(i)-'0'];
            while (result.peek().length() == i) {
                String str = result.remove(); // dequeue first element
                for (int j = 0; j < chars.length(); j++) {
                    result.add(str + chars.charAt(j)); // add all combinations back to queue
                }
            }
        }
        return result;
    }
}