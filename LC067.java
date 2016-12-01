/*
 * Problem: https://leetcode.com/problems/add-binary/
 *
 * Idea:    add digit by digit, starting from the LSB
 */

public class Solution {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        char[] result = new char[Math.max(len1, len2) + 1];
        result[0] = 0;
        
        int carryover = 0;
        for (int i = 0; i < result.length; i++) {
            int num1 = 0, num2 = 0;
            if (i < a.length()) {
                num1 = a.charAt(a.length()-1-i) - '0';
            }
            if (i < b.length()) {
                num2 = b.charAt(b.length()-1-i) - '0';
            }
            // result for this position
            int digit = (num1 + num2 + carryover) % 2;
            carryover = (num1 + num2 + carryover) / 2;
            int pos = result.length - 1 - i;
            result[pos] = Character.forDigit(digit, 2);;
        }
        
        String resultStr = new String(result);
        
        if (result[0] == '0') {
            return resultStr.substring(1);
        }
        return resultStr;
    }
}
